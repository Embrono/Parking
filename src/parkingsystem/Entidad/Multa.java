/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem.Entidad;

/**
 *
 * @author Embrono
 */
public class Multa {
    private Estadia estadia;
    private Etiqueta etiqueta;
    public Multa(Estadia estadia, Etiqueta etiqueta) {
        this.estadia = estadia;
        this.etiqueta = etiqueta;
    }
    public Estadia getEstadia() {
        return estadia;
    }
    public Etiqueta getEtiqueta() {
        return etiqueta;
    }
    public float getMontoMulta(){
        return etiqueta.CalcularMontoMulta(this.estadia.getFacturadoSinMulta(), this.estadia.getDuracion());
    }
}
