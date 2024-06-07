/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

import Excepciones.TarifaExcepcion;
import parkingsystem.Entidad.Tarifa;
import parkingsystem.Entidad.eventos;

/**
 *
 * @author alope
 */
public class SistemaTarifa {

    private static SistemaTarifa instancia;

    public static SistemaTarifa getInstancia() {
        if (instancia == null) {
            instancia = new SistemaTarifa();
        }
        return instancia;
    }
    
    public void setPrecioTarifa(Tarifa t, float precio) throws TarifaExcepcion{
        t.setPrecio(precio);
        t.getParking().avisar(eventos.CAMBIO_DE_TARIFA);
        Fachada.getInstancia().avisar(eventos.CAMBIO_DE_TARIFA);
    }
}
