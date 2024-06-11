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
import parkingsystem.Entidad.Etiqueta;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.Propietario;
import parkingsystem.Entidad.Vehiculo;
import parkingsystem.Entidad.eventos;
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
        pre.inicio();
        SistemaEtiquetas se = SistemaEtiquetas.getInstancia();
        se.setEtiquetas(pre.getEtiquetas());
        Parking p1 = pre.generarParking("Andres", "Salto y contituyente");
        Parking p2 = pre.generarParking("Facundo", "Salto y contituyente");
        ArrayList<Propietario> prop = pre.generarPropietarios();
        ArrayList<Transitable> transitables = new ArrayList<>();
        SistemaParking sistema = SistemaParking.getInstancia();
        Fachada fachada = Fachada.getInstancia();
                
        // se agregan los vehículos
        for(var p :  prop){
            transitables.addAll(p.getVehiculos());
            sistema.getVehiculos().addAll(p.getVehiculos());
        }
        
        //se agregan las cocheras
        ArrayList<Estacionable> estacionables = new ArrayList<>(p1.getCocheras());
        estacionables.addAll(p2.getCocheras());

        simulador = SimuladorTransito.getInstancia();
        simulador.addTransitables(transitables);
        simulador.addEstacionables(estacionables);
        
        //se programa un flujo de ingreso inicial para simular el ingreso de vehículos al sistema
        var flujoingreso = new FlujoIngreso("Ingreso Inicial", new Periodo(0, 5),3);
        try {
            //simulador.programar(flujoingreso);
            simulador.iniciar(fachada);
        } catch (ConfiguracionException ex) {
            Logger.getLogger(ParkingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        final PanelInicial panelInicial = new PanelInicial();
        // se muestra el simulador de interfaz de usuario para visualizar los vehículos y los estacionables (cocheras)
        new SimuladorIU(null, false,fachada,estacionables,transitables).setVisible(true);
        
        // se muestra la interfaz gráfica inicial del sistema de estacionamiento
        panelInicial.setVisible(true);
        
        // se agregan las cocheras y los parkings
        sistema.getCochera().addAll(p1.getCocheras());
        sistema.getCochera().addAll(p2.getCocheras());
        sistema.getParkings().add(p1);
        sistema.getParkings().add(p2);
        sistema.getPropietarios().addAll(prop);
    }
    
}
