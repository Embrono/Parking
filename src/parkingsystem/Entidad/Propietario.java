/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import java.util.ArrayList;

/**
 *
 * @author Embrono
 */
public class Propietario {

    public Propietario(String documento, String nombreCompleto) {
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.vehiculos = new ArrayList<>(); 
        this.cuentaCorriente = new ArrayList<>();
    }
    private String documento;
    private String nombreCompleto;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Pago> cuentaCorriente;

    public String getDocumento() {
        return documento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public ArrayList<Pago> getCuentaCorriente() {
        return cuentaCorriente;
    }
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public void agregarPago(Pago pago){
        cuentaCorriente.add(pago);
    }
}
