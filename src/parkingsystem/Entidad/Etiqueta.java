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
public abstract class Etiqueta {

    public Etiqueta() {
        multas = new ArrayList<>();
        vehiculos = new ArrayList<>();
        cocheras = new ArrayList<>();

    }

    private ArrayList<Multa> multas;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cochera> cocheras;

    public ArrayList<Multa> getMultas() {
        return multas;
    }

    public void setMultas(ArrayList<Multa> multas) {
        this.multas = multas;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Cochera> getCochera() {
        return cocheras;
    }

    public void setCochera(ArrayList<Cochera> cochera) {
        this.cocheras = cochera;
    }
    public abstract boolean esElectrico();
    public abstract boolean esDiscapacitado();
    public abstract boolean esEmpleado();

}
