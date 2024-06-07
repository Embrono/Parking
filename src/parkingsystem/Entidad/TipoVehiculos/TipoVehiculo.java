/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad.TipoVehiculos;

import java.util.ArrayList;
import parkingsystem.Entidad.Tarifa;
import parkingsystem.Entidad.Vehiculo;

/**
 *
 * @author Embrono
 */
public abstract class TipoVehiculo {
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private ArrayList<Tarifa> tarifas = new ArrayList<>();

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(ArrayList<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

}
