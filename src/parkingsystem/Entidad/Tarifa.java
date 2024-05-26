/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

/**
 *
 * @author Embrono
 */
public class Tarifa {

    public Tarifa(Parking p) {
        parking = p;
    }
   private int tiempo = 1;
   private double precio;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Vehiculo getTipo() {
        return tipo;
    }

    public void setTipo(Vehiculo tipo) {
        this.tipo = tipo;
    }
   private Vehiculo tipo;
   private Parking parking; 

    public Vehiculo getVehiculo() {
        return tipo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.tipo = vehiculo;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
