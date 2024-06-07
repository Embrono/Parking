/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

import Excepciones.TarifaExcepcion;
import java.util.ArrayList;
import observador.IObservador;
import observador.Observable;
import parkingsystem.Entidad.Anomalia;
import parkingsystem.Entidad.Cochera;
import parkingsystem.Entidad.Estadia;
import parkingsystem.Entidad.Etiqueta;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.Tarifa;
import parkingsystem.Entidad.Vehiculo;
import parkingsystem.Entidad.eventos;
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
    private SistemaAnomalia sistemaAnomalia = SistemaAnomalia.getInstancia();
    private SistemaTarifa sistemaTarifa = SistemaTarifa.getInstancia();


        
    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada() {}

    @Override
    public void ingreso(Transitable transitable, Estacionable estacionable) {
        sistemaEstadia.agregarEstadia(transitable, estacionable);
    }

    @Override
    public void egreso(Transitable transitable, Estacionable estacionable) {
        sistemaEstadia.egresarEstadia(transitable, estacionable);
    } 
    
    public ArrayList<Parking> getParkings(){
        return sistemaParking.getParkings();
    }

    public int getEstadiasCantidad(Parking parking) {
        return parking.getEstadias().size();
    }

    public void registrarAnomaliaMistery(Cochera cochera) {
        sistemaAnomalia.registrarAnomaliaMistery(cochera);
    }

    public void registrarAnomaliaTransportador(Estadia estadia, Vehiculo v) {
        sistemaAnomalia.registrarAnomaliaTransportador(estadia, v);
    }

    public ArrayList<Anomalia> getAnomalias() {
        return sistemaAnomalia.getAnomalias();
    }

    public void registrarAnomaliaHudini(Estadia estadia) {
        sistemaAnomalia.registrarAnomaliaHudini(estadia);
    }
    
    public void setPrecioTarifa(Tarifa t, float precio) throws TarifaExcepcion{
        sistemaTarifa.setPrecioTarifa(t, precio);
    }
    
    public ArrayList<Etiqueta> getEtiquetas(){
       return sistemaEtiquetas.getEtiquetas();
    } 
}
