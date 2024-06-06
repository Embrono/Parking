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
public class AnomaliaHudini extends AnomaliaException {
    
    public AnomaliaHudini(Estadia estadia, Date fecha) {
        super(estadia, fecha);
    }

    @Override
    public String getCodigo() {
        return "HOUDINI";
    }

    @Override
    public void generarAnomalia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
