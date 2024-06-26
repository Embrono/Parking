/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

import java.util.ArrayList;
import observador.Observable;
import parkingsystem.Entidad.Cochera;
import parkingsystem.Entidad.Etiqueta;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.Propietario;
import parkingsystem.Entidad.Tarifa;
import parkingsystem.Entidad.Vehiculo;
import simuladortransito.Estacionable;
import simuladortransito.Sensor;
import simuladortransito.Transitable;

/**
 *
 * @author Embrono
 */
public class SistemaParking {
    private static SistemaParking instancia;
    
    // Private constructor to prevent instantiation
    private SistemaParking() {
        vehiculos = new ArrayList<>();
        cochera = new ArrayList<>();
        parkings = new ArrayList<>();
        propietarios = new ArrayList<>();
    }
    // Public method to provide access to the singleton instance
    public static SistemaParking getInstancia() {
        if (instancia == null) {
            instancia = new SistemaParking();
        }
        return instancia;
    }
    // Member variables
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cochera> cochera;
    private ArrayList<Parking> parkings;
    private ArrayList<Propietario> propietarios;

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Cochera> getCochera() {
        return cochera;
    }

    public void setCochera(ArrayList<Cochera> cochera) {
        this.cochera = cochera;
    }

    public ArrayList<Parking> getParkings() {
        return parkings;
    }

    public void setParkings(ArrayList<Parking> parkings) {
        this.parkings = parkings;
    }

    public ArrayList<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(ArrayList<Propietario> propietarios) {
        this.propietarios = propietarios;
    }
}
