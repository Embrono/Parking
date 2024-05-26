/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parkingsystem;

import UI.PanelInicial;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import parkingsystem.Entidad.Cochera;
import parkingsystem.Entidad.Dectector;
import parkingsystem.Entidad.Vehiculo;
import simuladortransito.ConfiguracionException;
import simuladortransito.Estacionable;
import simuladortransito.FlujoIngreso;
import simuladortransito.Periodo;
import simuladortransito.Sensor;
import simuladortransito.SimuladorTransito;
import simuladortransito.Transitable;

/**
 *
 * @author Embrono
 */
public class ParkingSystem {

    private static SimuladorTransito simulador;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Transitable> vehiculos = new ArrayList<Transitable>();
        ArrayList<Estacionable> cocheras = new ArrayList<Estacionable>();
        simulador = SimuladorTransito.getInstancia();
        simulador.addTransitables(vehiculos);
        simulador.addEstacionables(cocheras);
        var flujoingreso = new FlujoIngreso("Ingreso Inicial", new Periodo(0, 5),3);
        try {
            simulador.programar(flujoingreso);
            simulador.iniciar(new Dectector());
        } catch (ConfiguracionException ex) {
            Logger.getLogger(ParkingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        new PanelInicial().setVisible(true);
    }
    
}
