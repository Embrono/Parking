/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Embrono
 */
public class Estadia {
    private Date fechaEntrada;
    private Date fechaSalida;  
    private Cochera cochera;
    private Vehiculo vehiculo;
    private ArrayList<Multa> multas;
    private float facturado;
    private Anomalia anomalia;
    
    public Estadia(Date fechaEntrada, Cochera cochera, Vehiculo vehiculo) {
        this.fechaEntrada = fechaEntrada;
        this.cochera = cochera;
        this.vehiculo = vehiculo;
        this.multas = new ArrayList<Multa>();
        this.facturado = 0;
        cochera.getParking().getEstadias().add(this);
    }
    
    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    public Cochera getCochera() {
        return cochera;
    }

    public void setCochera(Cochera cochera) {
        this.cochera = cochera;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public ArrayList<Multa> getMultas() {
        return multas;
    }

    public void setMultas(ArrayList<Multa> multas) {
        this.multas = multas;
    }
    
    public float getFacturado() {
        return facturado;
    }

    public void setFacturado(float facturado) {
        this.facturado = facturado;
    }
    
    public Anomalia getAnomalia() {
        return anomalia;
    }

    public void setAnomalia(Anomalia anomalia) {
        this.anomalia = anomalia;
    }   
    
    public Parking getParking(){
        return this.cochera.getParking();
    }
    
    public float getTotalMulta(){
        float total = 0;
        for(Multa m: multas){
            total+= m.getMontoTotalMulta();
        }
        return total;
    }
    
    public float getDuracion() {
        if (fechaSalida != null && fechaEntrada != null) {
            return (fechaSalida.getTime() - fechaEntrada.getTime()) / 1000;
        } else {
            return 0;
        }
    }
    
    public float getTotal(){
        return this.facturado + getTotalMulta();
    }
        
    public void agregarMultas() {
        //inicializo hash para almacenr cualquier clase que sea una subclase de etiqueta
        Set<Class<? extends Etiqueta>> etiquetasVehiculo = new HashSet<>();
    
        for (Etiqueta vehiculoEtiqueta : vehiculo.getEtiquetas()) {
            etiquetasVehiculo.add(vehiculoEtiqueta.getClass());
        }
    
        for (Etiqueta cocheraEtiqueta : cochera.getEtiquetas()) {
            if (!etiquetasVehiculo.contains(cocheraEtiqueta.getClass())) {
                Multa multa = new Multa(this, cocheraEtiqueta, cocheraEtiqueta.montoASumarMulta(this.facturado, this.getDuracion()));
                this.multas.add(multa);
            }
        }
    }
}
