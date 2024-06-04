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
import parkingsystem.Entidad.Vehiculo;

/**
 *
 * @author facun
 */
public class SistemaEstadia {
    ArrayList<Estadia> estadias;
    
    private static SistemaEstadia instancia;

    private SistemaEstadia() {
        this.estadias = new ArrayList<Estadia>();
    }

    public void setEstadias(ArrayList<Estadia> estadias) {
        this.estadias = estadias;
    }

    public ArrayList<Estadia> getEstadias() {
        return estadias;
    }

    public static SistemaEstadia getInstancia() {
        if (instancia == null) {
            instancia = new SistemaEstadia();
        }
        return instancia;
    }
    
    public void agregarEstadia(Vehiculo v, Cochera c){
        Date fecha = new Date();
        
        if(c.isOcupada()){
            Estadia ultimaEstadia = c.buscarUltimaEstadia();
            ultimaEstadia.setFechaSalida(null);
            ultimaEstadia.setFacturado(0);
            ultimaEstadia.setMultas(new ArrayList());
            
            Anomalia nuevaAnomalia = new Anomalia(ultimaEstadia, fecha, "HOUDINI");
            ultimaEstadia.setAnomalia(nuevaAnomalia);
        }
        
        estadias.add(new Estadia(fecha, c, v));
        c.setOcupada(true);
    }
    
}
