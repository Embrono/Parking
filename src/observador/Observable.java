/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observador;

import java.util.ArrayList;

/**
 *
 * @author Embrono
 */
public class Observable {

    private ArrayList<IObservador> observadores = new ArrayList();
    
    public void agregarObservador(IObservador obs){
        if(!observadores.contains(obs)){
            observadores.add(obs);
        }
    }
    public void quitarObservador(IObservador obs){
        observadores.remove(obs);
    }
    public void avisar(Object evento){
        ArrayList<IObservador> copia = new ArrayList(observadores);
        for(IObservador obs:copia){
            obs.actualizar(evento, this);
        }
    }
    
}
