/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import java.util.ArrayList;
import simuladortransito.Estacionable;
import simuladortransito.Sensor;
import simuladortransito.Transitable;

/**
 *
 * @author Embrono
 */
public class Parking implements Sensor{

    public Parking(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    private String nombre;
    private String direccion;
    private ArrayList<Cochera> Cocheras;
    private ArrayList<Tarifa> Tarifas;

    public ArrayList<Cochera> getCocheras() {
        return Cocheras;
    }

    public void setCocheras(ArrayList<Cochera> Cocheras) {
        this.Cocheras = Cocheras;
    }

    public ArrayList<Tarifa> getTarifas() {
        return Tarifas;
    }

    public void setTarifas(ArrayList<Tarifa> Tarifas) {
        this.Tarifas = Tarifas;
    }

    @Override
    public void ingreso(Transitable transitable, Estacionable estacionable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void egreso(Transitable transitable, Estacionable estacionable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
