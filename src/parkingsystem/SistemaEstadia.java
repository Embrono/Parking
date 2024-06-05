/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

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
    
    public void agregarEstadia(Vehiculo v, Cochera c){
        Date fecha = new Date();
        Estadia estadiaAnterior;
        
        if (c.isOcupada()) {
            estadiaAnterior = c.buscarUltimaEstadia();
            if (estadiaAnterior != null) {
                estadiaAnterior.setFechaSalida(null);
                estadiaAnterior.setFacturado(0);
                Anomalia nuevaAnomalia = new Anomalia(estadiaAnterior, fecha, "HOUDINI");
                estadiaAnterior.setAnomalia(nuevaAnomalia);
            }
        }
        
        // Crear una nueva estadía
        Estadia nuevaEstadia = new Estadia(fecha, c, v);

        // Actualizar el estado de la cochera
        c.setOcupada(true);
        c.getEstadias().add(nuevaEstadia);

        // Actualizar el sistema de estadías
        estadias.add(nuevaEstadia);

        // Actualizar el factor de demanda del parking
        Parking parking = c.getParking();
        parking.actualizarFactorDemanda(1); 
    }
    
    public void egresarEstadia(Vehiculo v, Cochera c){
        if (c.isOcupada()) {
            Estadia estadia = c.buscarEstadiaActiva(v.getPatente());
            if (estadia != null) {
                // Finalizar la estadía
                finalizarEstadia(estadia);

                // Restar el monto de la estadía de la cuenta corriente del propietario
                Propietario propietario = v.getPropietario();
                double montoEstadia = estadia.getFacturado();
                propietario.descontarSaldo(montoEstadia);
                c.setOcupada(false);
            } else {
                // La patente informada no coincide con la patente de la estadía registrada
                registrarAnomaliaTransportador(v, c);
            }
        } else {
            // La cochera se encuentra marcada como “Libre”
            registrarAnomaliaMistery(c);
        }
    }
        
    public void finalizarEstadia(Estadia e) {
        Date fechaSalida = new Date();
        e.setFechaSalida(fechaSalida);

        long duracionUT = (fechaSalida.getTime() - e.getFechaEntrada().getTime()) / 1000;

        Parking parking = e.getCochera().getParking();
        Tarifa tarifario = new Tarifa(parking);
        float pb = (float) tarifario.getPrecioBase(e.getVehiculo());
        float fd = parking.getFactorDemanda();

        float montoEstadia = pb * duracionUT * fd;

        SistemaEtiquetas sistemaEtiquetas = SistemaEtiquetas.getInstancia();

        float montoMultas = 0;
        for (Multa multa : e.getMultas()) {
            if (sistemaEtiquetas.esElectrico(e.getCochera().getEtiquetas()) && !sistemaEtiquetas.esElectrico(e.getVehiculo().getEtiquetas())) {
                montoMultas += montoEstadia * 0.5;
            } else if (sistemaEtiquetas.esEmpleado(e.getCochera().getEtiquetas()) && !sistemaEtiquetas.esEmpleado(e.getVehiculo().getEtiquetas())) {
                montoMultas += (duracionUT / 10);
            } else if (sistemaEtiquetas.esDiscapacitado(e.getCochera().getEtiquetas()) && !sistemaEtiquetas.esDiscapacitado(e.getVehiculo().getEtiquetas())) {
                montoMultas += 250;
            } else {
                montoMultas += multa.getMonto();
            }
        }

        float valorFacturado = montoEstadia + montoMultas;
        e.setFacturado(valorFacturado);

        e.getCochera().setOcupada(false);
        parking.actualizarFactorDemanda(-1);
    }
    
    private void registrarAnomaliaTransportador(Vehiculo v, Cochera c) {
        Estadia estadia = c.buscarUltimaEstadia();
        estadia.setMultas(null);
        Anomalia anomaliaEstadia = new Anomalia(estadia, new Date(), "TRANSPORTADOR1");
        estadia.setAnomalia(anomaliaEstadia);
        Anomalia anomaliaVehiculo = new Anomalia(null, new Date(), "TRANSPORTADOR2");
        v.setAnomalia(anomaliaVehiculo);
    }

    private void registrarAnomaliaMistery(Cochera cochera) {
        Estadia nuevaEstadia = new Estadia(new Date(), cochera, null);
        nuevaEstadia.setFechaSalida(new Date());
        cochera.getEstadias().add(nuevaEstadia);
        Anomalia anomalia = new Anomalia(nuevaEstadia, new Date(), "MISTERY");
        nuevaEstadia.setAnomalia(anomalia);
    }
}
