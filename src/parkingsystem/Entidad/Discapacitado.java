/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

/**
 *
 * @author Embrono
 */
public class Discapacitado extends Etiqueta {
    
       @Override
    public boolean esDiscapacitado() {
        return true;
    }

    @Override
    public boolean esElectrico() {
        return false;
    }

    @Override
    public boolean esEmpleado() {
        return false;
    }

    @Override
    protected float montoASumarMulta(float precioEstadia, float duracion) {
        return 250;
    }
    
}
