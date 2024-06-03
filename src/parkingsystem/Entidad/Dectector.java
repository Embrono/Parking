/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

import observador.Observable;
import simuladortransito.Estacionable;
import simuladortransito.Sensor;
import simuladortransito.Transitable;

/**
 *
 * @author Embrono
 */
public class Dectector extends Observable implements Sensor {
        @Override
        public void ingreso(Transitable transitable, Estacionable estacionable) {
            Vehiculo v = (Vehiculo)transitable;
            Cochera c = (Cochera) estacionable;
            v.setEstacionado(true);
            c.setOcupada(true);
            
        }

        @Override
        public void egreso(Transitable transitable, Estacionable estacionable) {
            Vehiculo v = (Vehiculo)transitable;
            Cochera c = (Cochera) estacionable;
            v.setEstacionado(false);
            c.setOcupada(false);
            avisar(null);
        }   
}
