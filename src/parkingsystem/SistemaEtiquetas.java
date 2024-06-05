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
}
