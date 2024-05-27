/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Precarga;

import java.util.ArrayList;
import java.util.Random;
import parkingsystem.Entidad.Carga;
import parkingsystem.Entidad.Cochera;
import parkingsystem.Entidad.Etiqueta;
import parkingsystem.Entidad.Motocicleta;
import parkingsystem.Entidad.Pago;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.Pasajeros;
import parkingsystem.Entidad.Propietario;
import parkingsystem.Entidad.Standard;
import parkingsystem.Entidad.Tarifa;
import parkingsystem.Entidad.TipoVehiculo;
import parkingsystem.Entidad.Vehiculo;

/**
 *
 * @author Embrono
 */
public class PreCarga {
    public Parking generarParking(String nombre, String direccion){
        var aux = new Parking(nombre, direccion);
        aux.setCocheras(generarChocherasPrecarga(aux));
        aux.setTarifas(generarTarigasPrecarga(aux));
        return aux;  
    }
    
    
    public ArrayList<Cochera> generarChocherasPrecarga(Parking p){
        var cocheras = new ArrayList<Cochera>();
        var cantidad = new Random();
        int aux = cantidad.nextInt(50,101);
        for(int i = 0; i < aux; i++){
            var cochera = new Cochera(p);
            cochera.setEtiquetas(generarEtiquetas());
            p.getCocheras().add(cochera);
            cocheras.add(cochera);
        }
        
        return cocheras;
    }
    
    private ArrayList<Vehiculo> generarVehiculoPrecarga(Propietario propietario){
        var cocheras = new ArrayList<Vehiculo>();
        var cantidad = new Random();
        int aux = cantidad.nextInt(50,101);
        for(int i = 0; i < aux; i++){
            Vehiculo ve = generarVehiculo();
            ve.setEtiquetas(generarEtiquetas());
            ve.setTipo(generarTipoVehiculo());
            ve.setPropietario(propietario);
            cocheras.add(ve);
        }
        
        return cocheras;
    }

    public ArrayList<Etiqueta> generarEtiquetas() {
        return new ArrayList<>();
    }

    public TipoVehiculo generarTipoVehiculo() {
        return new TipoVehiculo();
    }
    
    public ArrayList<Propietario> generarPropietarios(){
        Random rnd = new Random();
        ArrayList<Propietario> propietarios = new ArrayList<>();
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Andres");
        nombres.add("Manuela");
        nombres.add("Facundo");

        for (int i = 1; i <= 50; i++) {
            String documento = "DOC" + i;
            String nombreCompleto =  nombres.get(i%nombres.size());
            Propietario propietario = new Propietario(documento, nombreCompleto);
            propietario.agregarPago(new Pago(rnd.nextFloat(10, 101),propietario));
            var aux = generarVehiculoPrecarga(propietario);
            propietario.setVehiculos(aux);
            propietarios.add(propietario);
            
        }
        return propietarios;
    }

    private ArrayList<Tarifa> generarTarigasPrecarga(Parking p) {
        var tarifas = new ArrayList<Tarifa>();
        Tarifa t1 = new Tarifa(p);
        Tarifa t2 = new Tarifa(p);
        Tarifa t3 = new Tarifa(p);
        Tarifa t4 = new Tarifa(p);
        tarifas.add(t4);       
        tarifas.add(t3);
        tarifas.add(t2);
        tarifas.add(t1);
        t4.setPrecio(0.1); 
        t4.setVehiculo(new Carga());
        t3.setPrecio(0.1);
        t3.setVehiculo(new Standard());
        t2.setPrecio(0.1);
        t2.setVehiculo(new Pasajeros());
        t1.setPrecio(0.05);
        t1.setVehiculo(new Motocicleta());

        return tarifas;
    }

    private Vehiculo generarVehiculo() {
        int num = new Random().nextInt();
         if(num % 7 == 0 ){
             return new Carga();
         }else if(num % 5 == 0){
            return new Pasajeros();
         }else if(num % 3 == 0){
            return new Motocicleta();
         }else{
            return new Standard();
         }
    }
}


