/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import java.util.ArrayList;
import java.util.Date;
import parkingsystem.Fachada;
import simuladortransito.Estacionable;

/**
 *
 * @author Embrono
 */
public class Cochera implements Estacionable {

    private final int id; 
    private static int ultimoId = 0;
    private Parking parking; 
    private ArrayList<Estadia> estadias;
    private ArrayList<Etiqueta> etiquetas;
    private boolean ocupada;
    
    public Cochera(Parking parking) {
        this.parking = parking;
        id = ++ultimoId;
        estadias = new ArrayList<>();
        etiquetas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Cochera{" + "id=" + id + ", parking=" + parking.toString() + '}';
    }

    public int getId() {
        return id;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public ArrayList<Estadia> getEstadias() {
        return estadias;
    }

    public void setEstadias(ArrayList<Estadia> estadias) {
        this.estadias = estadias;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
         for(var e : etiquetas){
            e.getCochera().add(this);
        }
        this.etiquetas = etiquetas;
    }
    
    public Estadia buscarUltimaEstadia() {
        if (!estadias.isEmpty()) {
            return estadias.get(estadias.size() - 1);
        }
        return null;
    }

    public void registrarIngreso(Vehiculo vehiculo) {
        Date fechaIngreso = new Date();
        Estadia nuevaEstadia = new Estadia(fechaIngreso, this, vehiculo);
        estadias.add(nuevaEstadia);
        ocupada = true;
    }
    
    @Override
    public String getCodigo() {
        return id + "";
    }

    @Override
    public boolean esDiscapacitado() {
        return Fachada.getInstancia().esDiscapacitado(etiquetas);
    }

    @Override
    public boolean esElectrico() {
      return Fachada.getInstancia().esElectrico(etiquetas);
    }

    @Override
    public boolean esEmpleado() {
        return Fachada.getInstancia().esEmpleado(etiquetas);
    }

}
