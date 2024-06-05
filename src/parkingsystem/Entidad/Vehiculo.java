/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import java.util.ArrayList;
import parkingsystem.Fachada;
import simuladortransito.Transitable;

/**
 *
 * @author Embrono
 */
public abstract class Vehiculo implements Transitable  {
    private String patente;
    private ArrayList<Estadia> estadias;
    private ArrayList<Etiqueta> etiquetas;
    private Propietario propietario;
    private TipoVehiculo tipo;
    private boolean estacionado;
    private static int id = 0;
    
    public ArrayList<Estadia> getEstadias() {
        return estadias;
    }

    public Vehiculo() {
        this.patente = id + "";
        id++;
    }

    public void setEstadias(ArrayList<Estadia> estadias) {
        this.estadias = estadias;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        for(var e : etiquetas){
            e.getVehiculos().add(this);
        }
        this.etiquetas = etiquetas;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getPatente() {
        return this.patente;
    }

    @Override
    public boolean esDiscapacitado() {
        for(Etiqueta e: etiquetas){
            if(e.esDiscapacitado()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esElectrico() {
        for(Etiqueta e: etiquetas){
            if(e.esElectrico()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esEmpleado() {
        for(Etiqueta e: etiquetas){
            if(e.esEmpleado()){
                return true;
            }
        }
        return false;
    }

    public boolean isEstacionado() {
        
        return estacionado;
    }

    public void setEstacionado(boolean estacionado) {
        this.estacionado = estacionado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + patente + ", propietario=" + propietario.getNombreCompleto() + '}';
    }
    
    

}
