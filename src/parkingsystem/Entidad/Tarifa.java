/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import Excepciones.TarifaExcepcion;
import parkingsystem.Entidad.TipoVehiculos.TipoVehiculo;

/**
 *
 * @author Embrono
 */
public class Tarifa {

    private int tiempo = 1;
    private float precio;
    private TipoVehiculo tipo;
    private Parking parking;

    public Tarifa(Parking p) {
        parking = p;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) throws TarifaExcepcion {
        validarPrecio(precio);
        this.precio = precio;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    public TipoVehiculo getVehiculo() {
        return tipo;
    }

    public void setVehiculo(TipoVehiculo vehiculo) {
        this.tipo = vehiculo;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    private void validarPrecio(float precioNuevo) throws TarifaExcepcion {
        if(precioNuevo < 0){
            throw new TarifaExcepcion("El precio debe ser mayor o igual a 0");
        }
        if(precioNuevo >= this.precio * 2 && this.precio != 0){
            throw new TarifaExcepcion("Valor demasiado alto. Elsistema no permite dispersión de precios por encima del 100%. Ingrese un valor menor a" + this.precio *2+ ".");
        }
    }
}
