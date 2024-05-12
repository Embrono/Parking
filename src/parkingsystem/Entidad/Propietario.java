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
public class Propietario {
    private String documento;
    private String nombreCompleto;
    private ArrayList<Vehiculo> vehiculos;
    //private ArrayList<Pagos> cuentaCorriente; #TODO
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
