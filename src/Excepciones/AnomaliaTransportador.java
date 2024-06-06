/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

import java.util.Date;
import parkingsystem.Entidad.Estadia;
import parkingsystem.Fachada;

/**
 *
 * @author alope
 */
public class AnomaliaTransportador extends AnomaliaException {
    
    public AnomaliaTransportador(Estadia estadia, Date fecha) {
        super(estadia, fecha);
    }
    
    @Override
    public String getCodigo() {
        return "TRANSPORTADOR1";
    }

    @Override
    public void generarAnomalia() {
        Fachada.getInstancia().registrarAnomaliaTransportador(this.getEstadia());
    }
    
}
