/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import UI.TableroDeControl;
import java.util.ArrayList;
import observador.IObservador;
import observador.Observable;
import parkingsystem.Entidad.Anomalia;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.eventos;
import parkingsystem.Fachada;

/**
 *
 * @author Embrono
 */
public class ControladorTablero implements IObservador {
    private VistaTablero tablero;
    private Fachada logica;

    public ControladorTablero(VistaTablero tablero, Fachada logica) {
        this.tablero = tablero;
        this.logica = logica;
        logica.agregarObservador(this);
    }

    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(eventos.INGRESO)) {
            tablero.DibujarGridParking();
            tablero.TotalEstadiasLabel();
        } else if (evento.equals(eventos.EGRESO)) {
            tablero.DibujarGridParking();
            tablero.TotalEstadiasLabel();
            tablero.TotalFacturado();
        } else if (evento.equals(eventos.ANOMALIAS) && tablero.GetMonitorea()) {
            tablero.DibujarGridAnomalia();
        }else if (evento.equals(eventos.PAGO_REALIZADA)){
            tablero.TotalFacturado();
        }
    }
    
    public ArrayList<Parking> getParkings(){
        return this.logica.getParkings();
    }
    
    public ArrayList<Anomalia> getAnomalias(){
        return this.logica.getAnomalias();
    }
    
}
