/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Precarga;

import java.util.ArrayList;
import java.util.Random;
import parkingsystem.Entidad.Cochera;
import parkingsystem.Entidad.Etiqueta;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.Propietario;
import parkingsystem.Entidad.TipoVehiculo;
import parkingsystem.Entidad.Vehiculo;

/**
 *
 * @author Embrono
 */
public class PreCarga {
   // private Parking p1 = new Parking("Parking Inicial","Salto y Constituyente"); 
   // private Parking p2 = new Parking("Parking Premium","Carrasco frente a la rambla"); 
    
    
    
    public Parking generarParking(String nombre, String direccion){
        return new Parking(nombre, direccion);
    }
    
    
    public ArrayList<Cochera> generarChocherasPrecarga(Parking p){
        var cocheras = new ArrayList<Cochera>();
        var cantidad = new Random();
        int aux = cantidad.nextInt(50);
        aux += 50;
        for(int i = 0; i < aux; i++){
            var cochera = new Cochera(p);
            cochera.setEtiquetas(generarEtiquetas());
            p.getCocheras().add(cochera);
            cocheras.add(cochera);
        }
        
        return cocheras;
    }
    
    public ArrayList<Vehiculo> generarVehiculoPrecarga(Parking p){
        var cocheras = new ArrayList<Vehiculo>();
        var cantidad = new Random();
        int aux = cantidad.nextInt(50);
        aux += 50;
        for(int i = 0; i < aux; i++){
            var ve = new Vehiculo();
            ve.setEtiquetas(generarEtiquetas());
            ve.setTipo(generarTipoVehiculo());
        }
        
        return cocheras;
    }

    public ArrayList<Etiqueta> generarEtiquetas() {
        return new ArrayList<>();
    }

    public TipoVehiculo generarTipoVehiculo() {
        return new TipoVehiculo();
    }
    
    public Propietario gernerPropietario(String nombre,String documento){
        return new Propietario(nombre,documento);
    }
}


