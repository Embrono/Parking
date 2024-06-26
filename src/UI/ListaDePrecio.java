/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UI;

import Controladores.ControladorTarifas;
import Controladores.VistaTarifas;
import Excepciones.TarifaExcepcion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import observador.IObservador;
import observador.Observable;
import parkingsystem.Entidad.Parking;
import parkingsystem.Entidad.Tarifa;
import parkingsystem.Entidad.eventos;
import parkingsystem.Fachada;

/**
 *
 * @author Embrono
 */
public class ListaDePrecio extends javax.swing.JDialog implements VistaTarifas  {

    /**
     * Creates new form ListaDePrecio
     */
    private ControladorTarifas controlador;


    public ListaDePrecio(java.awt.Frame parent, boolean modal, Parking p) {
        super(parent, modal);
        //Fachada.getInstancia().agregarObservador(this);
        controlador = new ControladorTarifas(this, p);
        initComponents();
        this.setTitle(this.getTitle() + "-" + p.getNombre());
        this.DibujarTarifas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListado = new javax.swing.JTable();
        jLabelNuevoValor = new javax.swing.JLabel();
        jTextFieldNuevoValor = new javax.swing.JTextField();
        jButtonCerrar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Lista de precio");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTableListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListado);

        jLabelNuevoValor.setText("Nuevo valor");

        jTextFieldNuevoValor.setText("0");

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCerrarMouseClicked(evt);
            }
        });

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabelNuevoValor))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNuevoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNuevoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNuevoValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCerrar)
                    .addComponent(jButtonGuardar))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCerrarMouseClicked
        // TODO add your handling code here:
        //Fachada.getInstancia().quitarObservador(this);
        this.dispose();
    }//GEN-LAST:event_jButtonCerrarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //Fachada.getInstancia().quitarObservador(this);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jTableListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListadoMouseClicked
        // TODO add your handling code here:
        int selection = jTableListado.getSelectedRow();
        if (selection == -1) {
            return;
        }
        var tarifa = this.controlador.getTarifas().get(selection);
        jTextFieldNuevoValor.setText(String.valueOf(Math.round(tarifa.getPrecio() * 100.0) / 100.0));
    }//GEN-LAST:event_jTableListadoMouseClicked

    private void jButtonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGuardarMouseClicked
        // TODO add your handling code here:
        int selection = jTableListado.getSelectedRow();
        if (selection == -1) {
            return;
        }
        var tarifa = this.controlador.getTarifas().get(selection);
        float nuevoPrecio = 0;
        try {
            nuevoPrecio = Float.parseFloat(jTextFieldNuevoValor.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un numero", "Error al cambiar precio", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            controlador.setPrecioTarifa(tarifa, nuevoPrecio);
        } catch (TarifaExcepcion ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al cambiar precio", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGuardarMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabelNuevoValor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListado;
    private javax.swing.JTextField jTextFieldNuevoValor;
    // End of variables declaration//GEN-END:variables

    

    @Override
    public void DibujarTarifas() {
        ArrayList<Tarifa> tarifario = controlador.getTarifas();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Tipo de Vehiculo");
        model.addColumn("Precio/<UT>");
        model.setRowCount(tarifario.size());

        int fila = 0;
        for (Tarifa a : tarifario) {
            model.setValueAt(a.getTipo().toString(), fila, 0);
            model.setValueAt(Math.round(a.getPrecio() * 100.0) / 100.0, fila, 1);
            fila++;
        }
        jTableListado.setModel(model);
    }
}
