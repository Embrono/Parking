/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import java.util.ArrayList;
import java.util.Date;
import parkingsystem.Fachada;
import simuladortransito.Estacionable;

/**
 *
 * @author Embrono
 */
public class Cochera implements Estacionable {

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    private int id; 
    private static int ultimoId = 0;
    private Parking parking; 
    private ArrayList<Estadia> estadias;
    private ArrayList<Etiqueta> etiquetas;
    private boolean ocupada;
    
    public Cochera(Parking parking) {
        this.parking = parking;
        id = ++ultimoId;
        estadias = new ArrayList<>();
        etiquetas = new ArrayList<>();
    }

    @Override
    public String toString() {
        String eti = "";
        for(var e: etiquetas){
            eti += e.toString() +",";
        }
        return "Numero:" + id + "," + parking.toString() + "Eti:"+eti;
    }

    public int getId() {
        return id;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public ArrayList<Estadia> getEstadias() {
        return estadias;
    }

    public void setEstadias(ArrayList<Estadia> estadias) {
        this.estadias = estadias;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
         for(var e : etiquetas){
            e.getCochera().add(this);
        }
        this.etiquetas = etiquetas;
    }
        
    @Override
    public String getCodigo() {
        return id + "";
    }

   @Override
    public boolean esDiscapacitado() {
        for(Etiqueta e : etiquetas){
            if(e.esDiscapacitado()){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean esElectrico() {
        for(Etiqueta e : etiquetas){
            if(e.esElectrico()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esEmpleado() {
        for(Etiqueta e : etiquetas){
            if(e.esEmpleado()){
                return true;
            }
        }
        return false;
    }

    
    public Estadia buscarUltimaEstadia() {
        if (estadias.isEmpty()) {
            return null;
        }
        Estadia ultimaEstadia = estadias.get(0);
        for (Estadia estadia : estadias) {
            if (estadia.getFechaEntrada().after(ultimaEstadia.getFechaEntrada())) {
                ultimaEstadia = estadia;
            }
        }
        return ultimaEstadia;
    }
    
    public Estadia buscarEstadiaActiva(String patente) {
        return estadias.get(estadias.size() -1);
        //for (Estadia estadia : estadias) {
        //    if (estadia.getFechaSalida() == null && estadia.getVehiculo().getPatente().equals(patente)) {
        //        return estadia;
        //    }
        //}
        //return null;
    }
    
}
