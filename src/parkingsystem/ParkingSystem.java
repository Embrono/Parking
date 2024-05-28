/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parkingsystem;

import Precarga.PreCarga;
import UI.PanelInicial;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import parkingsystem.Entidad.Cochera;
import parkingsystem.Entidad.Dectector;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.Propietario;
import parkingsystem.Entidad.Vehiculo;
import simuladorIU.SimuladorIU;
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
        PreCarga pre = new PreCarga();
        Parking p1 = pre.generarParking("Andres", "Salto y contituyente");
        Parking p2 = pre.generarParking("Facuando", "Salto y contituyente");
        ArrayList<Propietario> prop = pre.generarPropietarios();
        ArrayList<Transitable> vehiculos = new ArrayList<>();
        SistemaParking sistema = SistemaParking.getInstancia();
        
        for(var p :  prop){
            vehiculos.addAll(p.getVehiculos());
            sistema.getVehiculos().addAll(p.getVehiculos());
        }
        
        ArrayList<Estacionable> cocheras = new ArrayList<>(p1.getCocheras());
        cocheras.addAll(p2.getCocheras());
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
        new SimuladorIU(null, false,new Dectector(),cocheras,vehiculos).setVisible(true);
        sistema.getCochera().addAll(p1.getCocheras());
        sistema.getCochera().addAll(p2.getCocheras());
        sistema.getParkings().add(p1);
        sistema.getParkings().add(p2);
        sistema.getPropietarios().addAll(prop);
        sistema.getEtiquetas().addAll(pre.etiquetas);
        

        
        
    }
    
}
