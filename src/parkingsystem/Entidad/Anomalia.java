/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import java.util.Date;

/**
 *
 * @author facun
 */
public class Anomalia {
    private Estadia estadia;
    private Date fechaHoraDeteccion;
    private String codigoError;
    
    public Anomalia(Estadia estadia, Date fechaHoraDeteccion, String codigoError){
        this.estadia = estadia;
        this.fechaHoraDeteccion = fechaHoraDeteccion;
        this.codigoError = codigoError;
    }
    
    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }

    public Date getFechaHoraDeteccion() {
        return fechaHoraDeteccion;
    }

    public void setFechaHoraDeteccion(Date fechaHoraDeteccion) {
        this.fechaHoraDeteccion = fechaHoraDeteccion;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    @Override
    public String toString() {
        return "Nueva Anomalia: " + "estadia=" + estadia + ", fechaHoraDeteccion=" + fechaHoraDeteccion + ", codigoError='" + codigoError;
    }
}
