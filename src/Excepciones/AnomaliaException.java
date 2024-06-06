/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

import java.util.Date;
import parkingsystem.Entidad.Estadia;

/**
 *
 * @author alope
 */
public abstract class AnomaliaException extends Exception {
    private Estadia estadia;
    private Date fecha;

    public Estadia getEstadia() {
        return estadia;
    }

    public Date getFecha() {
        return fecha;
    }

    public abstract String getCodigo();

    public AnomaliaException(Estadia estadia, Date fecha) {
        this.estadia = estadia;
        this.fecha = fecha;
    }
    
    public abstract void generarAnomalia();
}
