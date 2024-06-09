/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

import Excepciones.AnomaliaException;
import Excepciones.AnomaliaHoudini;
import Excepciones.AnomaliaMistery;
import Excepciones.AnomaliaTransportador;
import java.util.ArrayList;
import java.util.Date;
import parkingsystem.Entidad.Anomalia;
import parkingsystem.Entidad.Cochera;
import parkingsystem.Entidad.Estadia;
import parkingsystem.Entidad.Etiqueta;
import parkingsystem.Entidad.Multa;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.Propietario;
import parkingsystem.Entidad.Tarifa;
import parkingsystem.Entidad.Vehiculo;
import parkingsystem.Entidad.eventos;
import simuladortransito.Estacionable;
import simuladortransito.Transitable;

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

    public void agregarEstadia(Vehiculo v, Cochera c) {
        try {
            if (c.isOcupada()) {
                manejarCocheraOcupada(c);
            }
        } catch (AnomaliaHoudini e) {
            e.generarAnomalia();
        } finally {
            nuevaEstadia(v, c);
        }
    }

    public void egresarEstadia(Vehiculo v, Cochera c) {

        Estadia estadia = c.buscarEstadiaActiva(v.getPatente());
        try {

            if (!c.isOcupada()) {
                throw new AnomaliaMistery(estadia, new Date(),v);
            }

            if (!estadia.getVehiculo().equals(v)) {
                throw new AnomaliaTransportador(estadia, v, new Date());
            }

        } catch (AnomaliaException e) {
            e.generarAnomalia();

        } finally {
            // Finalizar la estadía
            finalizarEstadia(estadia);
            DescontarEstadoDecuenta(estadia);
            Fachada.getInstancia().avisar(eventos.PAGO_REALIZADA);
            c.getParking().avisar(eventos.EGRESO);
            Fachada.getInstancia().avisar(eventos.EGRESO);

        }
    }

    private void DescontarEstadoDecuenta(Estadia estadia) {
        // Restar el monto de la estadía de la cuenta corriente del propietario
        Propietario propietario = estadia.getVehiculo().getPropietario();
        double montoEstadia = estadia.getFacturadoConMulta();
        propietario.descontarSaldo(montoEstadia);
    }

    public void finalizarEstadia(Estadia e) {
        Date fechaSalida = new Date();
        e.setFechaSalida(fechaSalida);
        Parking parking = e.getCochera().getParking();
        e.getCochera().setOcupada(false);
        e.getVehiculo().setEstacionado(false);
        parking.actualizarFactorDemanda(-1);
    }

    void egresarEstadia(Transitable transitable, Estacionable estacionable) {
        Vehiculo v = (Vehiculo) transitable;
        Cochera c = (Cochera) estacionable;
        this.egresarEstadia(v, c);
    }

    void agregarEstadia(Transitable transitable, Estacionable estacionable) {
        Vehiculo v = (Vehiculo) transitable;
        Cochera c = (Cochera) estacionable;
        this.agregarEstadia(v, c);
    }

    private void nuevaEstadia(Vehiculo v, Cochera c) {
        // Crear una nueva estadía
        Estadia nuevaEstadia = new Estadia(new Date(), c, v);
        nuevaEstadia.agregarMultas();

        // Actualizar el estado de la cochera, vehiculo y agrega estadia
        c.setOcupada(true);
        v.setEstacionado(true);
        c.getEstadias().add(nuevaEstadia);

        // Actualizar el sistema de estadías
        estadias.add(nuevaEstadia);

        // Actualizar el factor de demanda del parking
        Parking parking = c.getParking();
        parking.actualizarFactorDemanda(1);
        Fachada.getInstancia().avisar(eventos.INGRESO);
        c.getParking().avisar(eventos.INGRESO);
    }

    private void manejarCocheraOcupada(Cochera c) throws Excepciones.AnomaliaHoudini {
        Estadia estadiaAnterior = c.buscarUltimaEstadia();
        throw new Excepciones.AnomaliaHoudini(estadiaAnterior, new Date());
    }
}
