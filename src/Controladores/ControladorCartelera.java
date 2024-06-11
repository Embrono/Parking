/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.util.ArrayList;
import observador.IObservador;
import observador.Observable;
import parkingsystem.Entidad.Cochera;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.Tarifa;
import parkingsystem.Entidad.eventos;

/**
 *
 * @author alope
 */
public class ControladorCartelera implements IObservador {

    private VistaCartelera tarifa;
    private Parking logica;

    public ControladorCartelera(VistaCartelera tablero, Parking logica) {
        this.tarifa = tablero;
        this.logica = logica;
        logica.agregarObservador(this);
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(eventos.CAMBIO_DE_TARIFA) && origen.equals(logica)) {
            this.tarifa.DibujarTarifas();
        } else if ((evento.equals(eventos.EGRESO) || evento.equals(eventos.INGRESO)) && origen.equals(logica)) {
           this.tarifa.DibujarDisponibilidad();
        }
    }

    public ArrayList<Tarifa> getTarifas() {
        return this.logica.getTarifas();
    }

    public ArrayList<Cochera> getCocheras() {
        return this.logica.getCocheras();
    }

}
