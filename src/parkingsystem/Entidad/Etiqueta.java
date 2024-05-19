/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import java.util.ArrayList;

/**
 *
 * @author Embrono
 */
public class Etiqueta {

    public Etiqueta(TipoEtiqueta tipo) {
        this.tipo = tipo;
    }
    private  TipoEtiqueta tipo;

    private ArrayList<Multa> multas;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cochera> cochera;

    
    public TipoEtiqueta getTipo() {
        return tipo;
    }

    public void setTipo(TipoEtiqueta tipo) {
        this.tipo = tipo;
    }
    
    public ArrayList<Multa> getMultas() {
        return multas;
    }

    public void setMultas(ArrayList<Multa> multas) {
        this.multas = multas;
    }

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
    
    private enum TipoEtiqueta{
        Discapacitado,
        Electrico,
        Empleado
    }
}
