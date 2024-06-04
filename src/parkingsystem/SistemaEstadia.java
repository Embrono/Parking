/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

import java.util.ArrayList;
import parkingsystem.Entidad.Cochera;
import parkingsystem.Entidad.Estadia;
import parkingsystem.Entidad.Vehiculo;

/**
 *
 * @author facun
 */
public class SistemaEstadia {
    ArrayList<Estadia> estadias;
    
    private static SistemaEstadia instancia;

    private SistemaEstadia() {
        this.estadias = new ArrayList<Estadia>();
    }

    public void setEstadias(ArrayList<Estadia> estadias) {
        this.estadias = estadias;
    }

    public ArrayList<Estadia> getEstadias() {
        return estadias;
    }

    public static SistemaEstadia getInstancia() {
        if (instancia == null) {
            instancia = new SistemaEstadia();
        }
        return instancia;
    }
    
    public void agregarEstadia(Vehiculo v, Cochera c){
        
    }
    
}
