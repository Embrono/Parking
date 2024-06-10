/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Excepciones.TarifaExcepcion;
import java.util.ArrayList;
import observador.IObservador;
import observador.Observable;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.Tarifa;
import parkingsystem.Entidad.eventos;
import parkingsystem.Fachada;

/**
 *
 * @author Embrono
 */
public class ControladorTarifas implements IObservador {

    private VistaTarifas tarifa;
    private Parking logica;

    public ControladorTarifas(VistaTarifas tablero, Parking logica) {
        this.tarifa = tablero;
        this.logica = logica;
        logica.agregarObservador(this);
        this.tarifa.DibujarTarifas();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(eventos.CAMBIO_DE_TARIFA) && origen.equals(this.logica)) {
            this.tarifa.DibujarTarifas();
        }
    }

    public ArrayList<Tarifa> getTarifas() {
        return this.logica.getTarifas();
    }

    public void setPrecioTarifa(Tarifa tarifa, float nuevoPrecio) throws TarifaExcepcion {
        Fachada.getInstancia().setPrecioTarifa(tarifa, nuevoPrecio);
    }
}
