/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import java.util.ArrayList;
import observador.Observable;
import parkingsystem.Fachada;
import simuladortransito.Estacionable;
import simuladortransito.Sensor;
import simuladortransito.Transitable;

/**
 *
 * @author Embrono
 */
public class Parking extends Observable {

    private String nombre;
    private String direccion;
    private ArrayList<Cochera> Cocheras;
    private ArrayList<Tarifa> Tarifas;
    private float factorDemanda;
    private long ultimaActualizacion;
    private String estadoTendencia;
    private int UT;
    private ArrayList<Estadia> estadias = new ArrayList<>();
    private ArrayList<Evento> eventos = new ArrayList<>();

    public Parking(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        Tarifas = new ArrayList<>();
        Cocheras = new ArrayList<>();
        this.factorDemanda = 1.0f;
        this.UT = 1;
        this.estadoTendencia = "Estable";
        this.ultimaActualizacion = System.currentTimeMillis() / 1000;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Parking" + nombre;
    }

    public ArrayList<Cochera> getCocheras() {
        return Cocheras;
    }

    public void setCocheras(ArrayList<Cochera> Cocheras) {
        this.Cocheras = Cocheras;
    }

    public ArrayList<Tarifa> getTarifas() {
        return Tarifas;
    }

    public void setTarifas(ArrayList<Tarifa> Tarifas) {
        this.Tarifas = Tarifas;
    }

    public float getFactorDemanda() {
        actualizarFactorDemanda();
        return factorDemanda;
    }

    public void setFactorDemanda(float factorDemanda) {
        this.factorDemanda = factorDemanda;
    }

    public long getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(long ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    // Actualizar factor de demanda
    public void actualizarFactorDemanda() {
        long tiempoActual = System.currentTimeMillis() / 1000;  // Tiempo actual en UT
        long tiempoTranscurrido = tiempoActual - this.ultimaActualizacion * this.UT;

        if (tiempoTranscurrido < 10) {
            return;
        }

        int capacidad = Cocheras.size();
        float ocupacion = getOcupacion() / capacidad;
        int diferenciaIngresosEgresos = calcularDiferenciaUltimosUT();
        if (Math.abs(diferenciaIngresosEgresos) <= 0.1 * capacidad) {
            this.factorDemanda = Math.max(0.25f, this.factorDemanda - 0.01f * tiempoTranscurrido);
            this.estadoTendencia = "Estable";
        } else if (diferenciaIngresosEgresos > 0.1 * capacidad) {
            this.estadoTendencia = "Positiva";
            if (ocupacion < 0.33) {
                this.factorDemanda = Math.min(10.0f, this.factorDemanda + 0.05f * tiempoTranscurrido);
            } else if (ocupacion < 0.66) {
                this.factorDemanda = Math.min(10.0f, this.factorDemanda + 0.1f * tiempoTranscurrido);
            } else {
                this.factorDemanda = Math.min(10.0f, this.factorDemanda + 0.15f * tiempoTranscurrido);
            }
        } else {
            this.estadoTendencia = "Negativa";
            if (this.factorDemanda > 1.0f) {
                this.factorDemanda = 1.0f;
            } else {
                this.factorDemanda = Math.max(0.25f, this.factorDemanda - 0.05f * tiempoTranscurrido);
            }
        }

        this.ultimaActualizacion = tiempoActual;
    }

    public ArrayList<Estadia> getEstadias() {
        return estadias;
    }

    public float getOcupacion() {
        float ocupadas = 0;
        for (Cochera cochera : Cocheras) {
            if (cochera.isOcupada()) {
                ocupadas++;
            }
        }
        return ocupadas;
    }

    public int getLibres() {
        int ocupadas = 0;
        for (Cochera cochera : Cocheras) {
            if (!cochera.isOcupada()) {
                ocupadas++;
            }
        }
        return ocupadas;
    }

    public String getEstadoTendencia() {
        return this.estadoTendencia;
    }

    public int getCantidadEstadias() {
        return this.estadias.size();
    }

    public float getSubTotalCobradoMulta() {
        float total = 0;
        for (Estadia e : estadias) {
            total += e.getTotalMulta();
        }
        return total;
    }

    public float GetSubTotalParking() {
        float total = 0;
        for (Estadia e : estadias) {
            total += e.getTotal();
        }
        return total;
    }

    public Tarifa getTarifaFor(Vehiculo vehiculo) {

        for (Tarifa t : Tarifas) {
            if (t.getTipo().equals(vehiculo.getTipo())) {
                return t;
            }
        }
        return null;
    }

    public static class Evento {

        public Evento(long tiempo, boolean esIngreso) {
            this.tiempo = tiempo;
            this.esIngreso = esIngreso;
        }
        long tiempo;
        boolean esIngreso;

    }

    private int calcularDiferenciaUltimosUT() {
        long tiempoActual = System.currentTimeMillis() / 1000;
        long tiempoLimite = tiempoActual - (10 * UT);

        int ingresos = 0;
        int egresos = 0;

        ArrayList<Evento> eventosFiltrados = new ArrayList<>();

        for (Evento evento : eventos) {
            if (evento.tiempo >= tiempoLimite) {
                eventosFiltrados.add(evento);
                if (evento.esIngreso) {
                    ingresos++;
                } else {
                    egresos++;
                }
            }
        }

        // Reemplazar la lista original con la lista filtrada
        eventos = eventosFiltrados;
        return ingresos - egresos;
    }

    public void registrarEventoIngreso() {
        long tiempo = System.currentTimeMillis() / 1000;
        eventos.add(new Evento(tiempo, true));
    }

    public void registrarEventoEgreso() {
        long tiempo = System.currentTimeMillis() / 1000;
        eventos.add(new Evento(tiempo, false));
    }
}
