/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import java.util.ArrayList;

/**
 *
 * @author Embrono
 */
public class Parking {
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
}
