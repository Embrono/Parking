/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

/**
 *
 * @author Embrono
 */
public class Empleado extends Etiqueta{



    @Override
    public boolean esDiscapacitado() {
        return false;
    }

    @Override
    public boolean esElectrico() {
        return false;
    }

    @Override
    public boolean esEmpleado() {
        return true;
    }

    @Override
    public float montoASumarMulta(float precioEstadia, float duracion) {
        return precioEstadia * 0.5f;
    }
    
}
