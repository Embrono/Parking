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
    
    private int tiempo = 1;
    private double precio;
    private Vehiculo tipo;
    private Parking parking; 

    public Tarifa(Parking p) {
        parking = p;
    }

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
    
    public double getPrecioBase(Vehiculo vehiculo) {
        if (vehiculo instanceof Motocicleta) {
            return 0.05;
        } else if (vehiculo instanceof Standard || vehiculo instanceof Carga || vehiculo instanceof Pasajeros) {
            return 0.1;
        } else {
            throw new IllegalArgumentException("Tipo de vehículo desconocido: " + vehiculo.getTipo());
        }
    }
}
