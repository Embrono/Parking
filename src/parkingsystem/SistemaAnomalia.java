/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

import java.util.ArrayList;
import java.util.Date;
import parkingsystem.Entidad.Anomalia;
import parkingsystem.Entidad.Cochera;
import parkingsystem.Entidad.Estadia;
import parkingsystem.Entidad.eventos;

/**
 *
 * @author alope
 */
public class SistemaAnomalia {
    private static SistemaAnomalia instancia;
    private ArrayList<Anomalia> anomalias;

    public static SistemaAnomalia getInstancia() {
        if (instancia == null) {
            instancia = new SistemaAnomalia();
        }
        return instancia;
    }
    
        private SistemaAnomalia() {
        this.anomalias = new ArrayList<Anomalia>();
    }

    public ArrayList<Anomalia> getAnomalias() {
        return anomalias;
    }
    
    public void registrarAnomaliaTransportador(Estadia estadia) {
        estadia.setMultas(new ArrayList<>());
        Anomalia anomaliaEstadia = new Anomalia(estadia, new Date(), "TRANSPORTADOR1");
        estadia.setAnomalia(anomaliaEstadia);
        Anomalia anomaliaVehiculo = new Anomalia(null, new Date(), "TRANSPORTADOR2");
        estadia.getVehiculo().setAnomalia(anomaliaVehiculo);
        this.anomalias.add(anomaliaEstadia);
        this.anomalias.add(anomaliaVehiculo);
        Fachada.getInstancia().avisar(eventos.ANOMALIAS);
    }

    public void registrarAnomaliaMistery(Cochera cochera) {
        Estadia nuevaEstadia = new Estadia(new Date(), cochera, null);
        nuevaEstadia.setFechaSalida(new Date());
        cochera.getEstadias().add(nuevaEstadia);
        Anomalia anomalia = new Anomalia(nuevaEstadia, new Date(), "MISTERY");
        nuevaEstadia.setAnomalia(anomalia);
        this.anomalias.add(anomalia);
        Fachada.getInstancia().avisar(eventos.ANOMALIAS);
    }

    public void registrarAnomaliaHudini(Estadia estadia) {
        estadia.setMultas(new ArrayList<>());
        estadia.setFacturado(0);
        Anomalia anomalia = new Anomalia(estadia, new Date(), "HOUDINI");
        estadia.setAnomalia(anomalia);
        this.anomalias.add(anomalia);
        Fachada.getInstancia().avisar(eventos.ANOMALIAS);
    }
    
}
