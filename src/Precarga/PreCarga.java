/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Precarga;

import Excepciones.TarifaExcepcion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import parkingsystem.Entidad.TipoVehiculos.Carga;
import parkingsystem.Entidad.Cochera;
import parkingsystem.Entidad.Discapacitado;
import parkingsystem.Entidad.Electrico;
import parkingsystem.Entidad.Empleado;
import parkingsystem.Entidad.Etiqueta;
import parkingsystem.Entidad.TipoVehiculos.Motocicleta;
import parkingsystem.Entidad.Pago;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.TipoVehiculos.Pasajeros;
import parkingsystem.Entidad.Propietario;
import parkingsystem.Entidad.TipoVehiculos.Standard;
import parkingsystem.Entidad.Tarifa;
import parkingsystem.Entidad.TipoVehiculos.TipoVehiculo;
import parkingsystem.Entidad.Vehiculo;
import parkingsystem.SistemaEtiquetas;

/**
 *
 * @author Embrono
 */
public class PreCarga {

    public static ArrayList<Etiqueta> etiquetas = new ArrayList<>();
    public static ArrayList<TipoVehiculo> tiposVe = new ArrayList<>();

    public Parking generarParking(String nombre, String direccion) {
        var aux = new Parking(nombre, direccion);
        aux.setCocheras(generarChocherasPrecarga(aux));
        aux.setTarifas(generarTarigasPrecarga(aux));
        return aux;
    }

    public void inicio() {
        var dis = new Discapacitado();
        var emp = new Empleado();
        var ele = new Electrico();
        etiquetas.add(ele);
        etiquetas.add(dis);
        etiquetas.add(emp);
        var carga = new Carga();
        var moto = new Motocicleta();
        var standar = new Standard();
        var pasajero = new Pasajeros();
        tiposVe.add(carga);
        tiposVe.add(standar);
        tiposVe.add(pasajero);
        tiposVe.add(moto);
    }

    public ArrayList<Cochera> generarChocherasPrecarga(Parking p) {
        var cocheras = new ArrayList<Cochera>();
        var cantidad = new Random();
        int aux = cantidad.nextInt(50, 101);
        for (int i = 0; i < aux; i++) {
            var cochera = new Cochera(p);
            cochera.setEtiquetas(generarEtiquetas());
            p.getCocheras().add(cochera);
            cocheras.add(cochera);
        }

        return cocheras;
    }

    private ArrayList<Vehiculo> generarVehiculoPrecarga(Propietario propietario) {
        var cocheras = new ArrayList<Vehiculo>();
        var cantidad = new Random();
        int aux = cantidad.nextInt(50, 101);
        for (int i = 0; i < aux; i++) {
            Vehiculo ve = new Vehiculo();
            ve.setEtiquetas(generarEtiquetas());
            TipoVehiculo tipo = generarVehiculo();
            ve.setTipo(tipo);
            ve.setPropietario(propietario);
            tipo.getVehiculos().add(ve);
            cocheras.add(ve);
        }

        return cocheras;
    }

    public ArrayList<Etiqueta> generarEtiquetas() {
        Random random = new Random();
        Collections.shuffle(etiquetas, random);
        int cantidad = random.nextInt(etiquetas.size() + 1); // 0 to etiquetas.size()
        ArrayList<Etiqueta> etiquetasSeleccionadas = new ArrayList<>(etiquetas.subList(0, cantidad));

        return etiquetasSeleccionadas;
    }

    public ArrayList<Propietario> generarPropietarios() {
        Random rnd = new Random();
        ArrayList<Propietario> propietarios = new ArrayList<>();
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Andres");
        nombres.add("Manuela");
        nombres.add("Facundo");

        for (int i = 1; i <= 50; i++) {
            String documento = "DOC" + i;
            String nombreCompleto = nombres.get(i % nombres.size());
            Propietario propietario = new Propietario(documento, nombreCompleto);
            propietario.agregarPago(new Pago(rnd.nextFloat(10, 101), propietario));
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
        try {
            t4.setPrecio(0.1f);
        } catch (TarifaExcepcion ex) {
            Logger.getLogger(PreCarga.class.getName()).log(Level.SEVERE, null, ex);
        }
        t4.setVehiculo(tiposVe.get(0));
        try {
            t3.setPrecio(0.1f);
        } catch (TarifaExcepcion ex) {
            Logger.getLogger(PreCarga.class.getName()).log(Level.SEVERE, null, ex);
        }
        t3.setVehiculo(tiposVe.get(1));
        try {
            t2.setPrecio(0.1f);
        } catch (TarifaExcepcion ex) {
            Logger.getLogger(PreCarga.class.getName()).log(Level.SEVERE, null, ex);
        }
        t2.setVehiculo(tiposVe.get(2));
        try {
            t1.setPrecio(0.05f);
        } catch (TarifaExcepcion ex) {
            Logger.getLogger(PreCarga.class.getName()).log(Level.SEVERE, null, ex);
        }
        t1.setVehiculo(tiposVe.get(3));

        return tarifas;
    }

    private TipoVehiculo generarVehiculo() {
        int num = new Random().nextInt(tiposVe.size());
        return tiposVe.get(num);
    }
    
    public ArrayList<Etiqueta> getEtiquetas(){
        return etiquetas;
    }
}
