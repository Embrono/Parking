/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

import observador.Observable;
import parkingsystem.Entidad.Cochera;
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
    
    public void agregarEstadia(Vehiculo v, Cochera c){
        sistemaEstadia.agregarEstadia(v,c);
    }
    
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
    }

    @Override
    public void egreso(Transitable transitable, Estacionable estacionable) {
        Vehiculo v = (Vehiculo)transitable;
        Cochera c = (Cochera) estacionable;
        v.setEstacionado(false);
        c.setOcupada(false);
        avisar(null);
    } 
}
