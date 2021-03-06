/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioapc.vistas;

import inventarioapc.controladores.Ventanas;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 *
 * @author nicolas soler & danny ochoa
 */
public class Botones extends javax.swing.JPanel {
    
    private inventarioapc.controladores.Ventanas controladorVentana;
    
    
    public Botones() {
        initComponents();
        asignarImagenes();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        inicioSesion = new javax.swing.JButton();
        cajero = new javax.swing.JButton();
        inventario = new javax.swing.JButton();
        administrador = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(236, 255, 236));

        inicioSesion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        inicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioSesionActionPerformed(evt);
            }
        });

        cajero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajeroActionPerformed(evt);
            }
        });

        inventario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioActionPerformed(evt);
            }
        });

        administrador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(inicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(cajero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajero, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioActionPerformed
        controladorVentana.cambioVentana(6);
        System.out.println("INVENTARIO");
    }//GEN-LAST:event_inventarioActionPerformed

    private void inicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioSesionActionPerformed
        controladorVentana.cambioVentana(0);
        System.out.println("INICIOSESION");
    }//GEN-LAST:event_inicioSesionActionPerformed

    private void cajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajeroActionPerformed
        controladorVentana.cambioVentana(1);
        System.out.println("CAJERO");
    }//GEN-LAST:event_cajeroActionPerformed

    private void administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administradorActionPerformed
        controladorVentana.cambioVentana(10);
        System.out.println("Administrador");
    }//GEN-LAST:event_administradorActionPerformed

    private void asignarImagenes(){
        inicioSesion.setIcon(setIcon("/images/user.png", inicioSesion));
        cajero.setIcon(setIcon("/images/cajero.png", cajero));
        inventario.setIcon(setIcon("/images/inventario.png", inventario));
        administrador.setIcon(setIcon("/images/administrador.png", administrador));
    }
    
    private Icon setIcon(String url, JButton boton){
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        
        int ancho = boton.getWidth();
        int alto = boton.getHeight();
        
        ImageIcon imagen = new ImageIcon(icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        
        return imagen;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton administrador;
    private javax.swing.JButton cajero;
    private javax.swing.JButton inicioSesion;
    private javax.swing.JButton inventario;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

    public Ventanas getControladorVentana() {
        return controladorVentana;
    }

    public void setControladorVentana(Ventanas controladorVentana) {
        this.controladorVentana = controladorVentana;
    }
}
