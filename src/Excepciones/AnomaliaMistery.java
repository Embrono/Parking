/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

import java.util.Date;
import parkingsystem.Entidad.Estadia;
import parkingsystem.Entidad.Vehiculo;
import parkingsystem.Fachada;

/**
 *
 * @author alope
 */
public class AnomaliaMistery extends AnomaliaException{
    private Vehiculo vehiculo;
    public AnomaliaMistery(Estadia estadia, Date fecha,Vehiculo vehiculo) {
        super(estadia, fecha);
        this.vehiculo = vehiculo;
    }
    
    @Override
    public String getCodigo() {
        return "MISTERY";
    }

    @Override
    public void generarAnomalia() {
       Fachada.getInstancia().registrarAnomaliaMistery(this.getEstadia(), vehiculo);
    }
    
}
