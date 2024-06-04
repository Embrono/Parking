/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

import java.util.ArrayList;
import parkingsystem.Entidad.Discapacitado;
import parkingsystem.Entidad.Electrico;
import parkingsystem.Entidad.Empleado;
import parkingsystem.Entidad.Etiqueta;

/**
 *
 * @author Embrono
 */
public class SistemaEtiquetas {
    private static SistemaEtiquetas instancia;
    private ArrayList<Etiqueta> etiquetas;
    private Discapacitado discapacitado;
    private Electrico electrico; 
    private Empleado empleado; 

    public Discapacitado getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Discapacitado discapacitado) {
        this.discapacitado = discapacitado;
    }

    public Electrico getElectrico() {
        return electrico;
    }

    public void setElectrico(Electrico electrico) {
        this.electrico = electrico;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

     public static SistemaEtiquetas getInstancia() {
        if (instancia == null) {
            instancia = new SistemaEtiquetas();
        }
        return instancia;
    }
    private SistemaEtiquetas(){
        etiquetas = new ArrayList<>();
    }
    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
        
    public boolean esElectrico(ArrayList<Etiqueta> lista){
        return lista.contains(electrico);
    }
    public boolean esEmpleado(ArrayList<Etiqueta> lista){
        return lista.contains(empleado);
    }
    public boolean esDiscapacitado(ArrayList<Etiqueta> lista){
        return lista.contains(discapacitado);
    }
}
