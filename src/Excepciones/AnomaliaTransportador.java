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
public class AnomaliaTransportador extends AnomaliaException {
    
    private Vehiculo vehiculo;
    public AnomaliaTransportador(Estadia estadia, Vehiculo v, Date fecha) {
        super(estadia, fecha);
        this.vehiculo = v;

    }
    
    @Override
    public String getCodigo() {
        return "TRANSPORTADOR1";
    }

    @Override
    public void generarAnomalia() {
        Fachada.getInstancia().registrarAnomaliaTransportador(this.getEstadia(), this.vehiculo);
    }
    
}
