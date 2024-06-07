/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

import Excepciones.AnomaliaException;
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
            Estadia estadiaAnterior = c.buscarUltimaEstadia();
            if (estadiaAnterior != null && c.isOcupada()) {
                throw new Excepciones.AnomaliaHoudini(estadiaAnterior, new Date());
            }

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
        } catch (AnomaliaException e) {
            e.generarAnomalia();
        }
    }

    public void egresarEstadia(Vehiculo v, Cochera c) {
        
        Estadia estadia = c.buscarEstadiaActiva(v.getPatente());
        try {

            if (!c.isOcupada()) {
                throw new AnomaliaMistery(estadia, new Date());
            }
            
            if (!estadia.getVehiculo().equals(v)) {
                throw new AnomaliaTransportador(estadia, v, new Date());
            }
            // Finalizar la estadía
            finalizarEstadia(estadia);

            // Restar el monto de la estadía de la cuenta corriente del propietario
            Propietario propietario = v.getPropietario();
            double montoEstadia = estadia.getFacturado();
            propietario.descontarSaldo(montoEstadia);
            c.setOcupada(false);
            v.setEstacionado(false);
            Fachada.getInstancia().avisar(eventos.EGRESO);
            c.getParking().avisar(eventos.EGRESO);
        } catch (AnomaliaException e) {
            e.generarAnomalia();
        }
    }

    public void finalizarEstadia(Estadia e) {
        Date fechaSalida = new Date();
        e.setFechaSalida(fechaSalida);

        long duracionUT = (fechaSalida.getTime() - e.getFechaEntrada().getTime()) / 1000;
        Parking parking = e.getCochera().getParking();
        Tarifa tarifario = parking.getTarifaFor(e.getVehiculo());
        float pb = (float) tarifario.getPrecio();
        float fd = parking.getFactorDemanda();

        float montoEstadia = pb * duracionUT * fd;

        float montoMultas = e.getTotalMulta();
        float valorFacturado = montoEstadia + montoMultas;
        e.setFacturado(valorFacturado);

        e.getCochera().setOcupada(false);
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

}
