/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import java.util.ArrayList;
import simuladortransito.Estacionable;

/**
 *
 * @author Embrono
 */
public class Cochera implements Estacionable {

    public Cochera(Parking parking) {
        this.parking = parking;
        id = ++ultimoId;
        estadias = new ArrayList<>();
        etiquetas = new ArrayList<>();
    }
    private final int id; 
    private static int ultimoId = 0;
    private Parking parking; 
    private ArrayList<Estadia> estadias;
    private ArrayList<Etiqueta> etiquetas;
    private boolean ocupada;

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    public int getId() {
        return id;
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
        this.etiquetas = etiquetas;
    }
    @Override
    public String getCodigo() {
        return id + "";
    }

    @Override
    public boolean esDiscapacitado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean esElectrico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean esEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
