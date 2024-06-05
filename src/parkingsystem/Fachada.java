/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

import java.util.ArrayList;
import observador.Observable;
import parkingsystem.Entidad.Cochera;
import parkingsystem.Entidad.Etiqueta;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.Vehiculo;
import simuladortransito.Estacionable;
import simuladortransito.Sensor;
import simuladortransito.Transitable;

/**
 *
 * @author facun
 */
public class Fachada extends Observable implements Sensor{
    private SistemaEstadia sistemaEstadia = SistemaEstadia.getInstancia();
    private SistemaParking sistemaParking = SistemaParking.getInstancia();  
    private SistemaEtiquetas sistemaEtiquetas = SistemaEtiquetas.getInstancia();
        
    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada() {}

    @Override
    public void ingreso(Transitable transitable, Estacionable estacionable) {
        Vehiculo v = (Vehiculo)transitable;
        Cochera c = (Cochera) estacionable;
        v.setEstacionado(true);
        c.setOcupada(true); 
        sistemaEstadia.agregarEstadia(v, c);
    }

    @Override
    public void egreso(Transitable transitable, Estacionable estacionable) {
        Vehiculo v = (Vehiculo)transitable;
        Cochera c = (Cochera) estacionable;
        v.setEstacionado(false);
        c.setOcupada(false);
        avisar(null);
    } 
    
    public ArrayList<Parking> getParkings(){
        return sistemaParking.getParkings();
    }
}
