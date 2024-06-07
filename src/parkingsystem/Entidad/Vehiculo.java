/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import parkingsystem.Entidad.TipoVehiculos.TipoVehiculo;
import java.util.ArrayList;
import parkingsystem.Fachada;
import simuladortransito.Transitable;

/**
 *
 * @author Embrono
 */
public class Vehiculo implements Transitable  {
    private String patente;
    private ArrayList<Estadia> estadias = new ArrayList<>();
    private ArrayList<Etiqueta> etiquetas = new ArrayList<>();
    private Propietario propietario;
    private boolean estacionado;
    private static int id = 0;
    private Anomalia anomalia;
    private TipoVehiculo tipo;
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

    public Anomalia getAnomalia() {
        return anomalia;
    }

    public void setAnomalia(Anomalia anomalia) {
        this.anomalia = anomalia;
    }

    @Override
    public String getPatente() {
        return this.patente;
    }

    @Override
    public boolean esDiscapacitado() {
        for(Etiqueta e : etiquetas){
            if(e.esDiscapacitado()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esElectrico() {
        for(Etiqueta e : etiquetas){
            if(e.esElectrico()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esEmpleado() {
        for(Etiqueta e : etiquetas){
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
        String eti = "";
        for(var e: etiquetas){
            eti += e.toString() +",";
        }
        return "Tipo:"+ tipo.toString() + ", Pa:" + patente + ", Pro:" + propietario.getNombreCompleto() + ", Eti:"+ eti;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    
    

}
