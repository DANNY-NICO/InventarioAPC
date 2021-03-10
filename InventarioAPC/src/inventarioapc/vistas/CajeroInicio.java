/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventarioapc.vistas;

import inventarioapc.controladores.Productos;
import inventarioapc.controladores.Ventanas;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicolas soler & danny ochoa
 */
public class CajeroInicio extends javax.swing.JPanel {

    private String productoTemporal[];
    private DefaultTableModel modelo;
    public inventarioapc.controladores.Ventanas controladorNavegacion;
    public inventarioapc.controladores.Productos controladorProdcutos;
    public inventarioapc.vistas.CajeroFacturaDetalle detalleFac;
    /** Creates new form Cajero */
    public CajeroInicio(inventarioapc.vistas.CajeroFacturaDetalle detalleFac) {
        initComponents();
        this.detalleFac = detalleFac;
        productoTemporal = new String[7];
        modelo = new DefaultTableModel();
        
        modelo.addColumn("Indice");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        
        facturaPrev.setModel(modelo);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        productos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        facturaPrev = new javax.swing.JTable();
        subTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        codigoFac = new javax.swing.JTextField();
        precioFac = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nombreFac = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cantidadFac = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Marca", "Codigo", "Inventario"
            }
        ));
        productos.setRowHeight(40);
        productos.setRowMargin(2);
        productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(productos);

        jScrollPane1.setViewportView(jScrollPane2);

        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Cancelar Factura");

        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setText("Guardar Factura");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("CODIGO:");

        jTextField1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("MARCA:");

        jComboBox1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        facturaPrev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Nombre", "Cantidad", "Precio"
            }
        ));
        facturaPrev.setRowHeight(40);
        facturaPrev.setRowMargin(2);
        jScrollPane3.setViewportView(facturaPrev);

        subTotal.setEditable(false);
        subTotal.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        subTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        subTotal.setText("0");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("SUB TOTAL: ");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Codigo");

        codigoFac.setEditable(false);
        codigoFac.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        precioFac.setEditable(false);
        precioFac.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Precio");

        nombreFac.setEditable(false);
        nombreFac.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Nombre");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Agregar a factura");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton5.setText("-");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        cantidadFac.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cantidadFac.setText("00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(53, 53, 53)
                        .addComponent(nombreFac, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(codigoFac, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(precioFac, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cantidadFac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(59, 59, 59))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(codigoFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nombreFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(precioFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton6)
                        .addComponent(cantidadFac)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton7.setText("eliminar de factura");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(178, 178, 178)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(120, 120, 120)
                                    .addComponent(jButton7))))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //detalleFac.getTable().setModel(modelo);
        
        DefaultTableModel detalle = new DefaultTableModel();
        
        detalle.addColumn("Nombre");
        detalle.addColumn("Marca");
        detalle.addColumn("Codigo");
        detalle.addColumn("Precio");
        detalle.addColumn("Cantidad");
        String info[] = new String[5];
        int indice;
        
        for (int i = 0; i < facturaPrev.getRowCount(); i++) {
            indice = Integer.parseInt(facturaPrev.getValueAt(i, 0).toString());
            info[0] = productos.getValueAt(indice, 1).toString();
            info[1] = "--";
            info[2] = productos.getValueAt(indice, 0).toString();
            info[3] = facturaPrev.getValueAt(i, 3).toString();
            info[4] = facturaPrev.getValueAt(i, 2).toString();
            
            detalle.addRow(info);
        }
        
        detalleFac.getTotal().setText(subTotal.getText());
        detalleFac.getTable().setModel(detalle);
        controladorNavegacion.cambioVentana(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productosMouseClicked
        int pos = productos.getSelectedRow();
                              
        codigoFac.setText(productos.getModel().getValueAt(pos, 0).toString());
        nombreFac.setText(productos.getModel().getValueAt(pos, 1).toString());
        precioFac.setText(productos.getModel().getValueAt(pos, 4).toString());
        
        productoTemporal[0] = codigoFac.getText();                                  //CODIGO
        productoTemporal[1] = nombreFac.getText();                                  //NOMBRE
        productoTemporal[2] = productos.getModel().getValueAt(pos, 2).toString();   //STOCKLOCAL
        productoTemporal[3] = productos.getModel().getValueAt(pos, 3).toString();   //STOCKBODEGA
        productoTemporal[4] = precioFac.getText();                                  //PRECIOVENTA
        productoTemporal[5] = productos.getModel().getValueAt(pos, 5).toString();   //PRECIOCOMPRA
        productoTemporal[6] = ""+00;                                                //CANTIDAD A LLEVAR
    }//GEN-LAST:event_productosMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(productoTemporal[6]!=null){
            int temp = Integer.parseInt(productoTemporal[6]);
            if(temp > 0){
                productoTemporal[6] = ""+(temp-1);
                if(temp-1 < 10){
                    cantidadFac.setText("0"+productoTemporal[6]);
                }else {
                    cantidadFac.setText(productoTemporal[6]);
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(productoTemporal[6]!=null){
            int temp = Integer.parseInt(productoTemporal[6]);
            int stock = Integer.parseInt(productoTemporal[2]);
            if(temp < stock){
                productoTemporal[6] = ""+(temp+1);
                if(temp-1 < 10){
                    cantidadFac.setText("0"+productoTemporal[6]);
                }else {
                    cantidadFac.setText(productoTemporal[6]);
                }
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int temporal = Integer.parseInt(productoTemporal[6]);
        DefaultTableModel modeloTemp = controladorProdcutos.getModelo();
        int i = productos.getSelectedRow();
        int stock = (Integer.parseInt(modeloTemp.getValueAt(i,2).toString())-temporal);
        if(temporal > 0 && stock >= 0){
            String info[] = new String[4];
            info[0] = ""+i;
            info[1] = productoTemporal[1];
            info[2] = productoTemporal[6];
            info[3] = productoTemporal[4];
           
            
            modeloTemp.setValueAt(stock, i, 2);
            info[3] = ""+ (Integer.parseInt(info[2]) * Integer.parseInt(info[3]));
            int subTotal = Integer.parseInt(this.subTotal.getText()) + Integer.parseInt(info[3]);
            modelo.addRow(info);
            this.subTotal.setText(""+subTotal);
        }else {
            if(stock < 0){
                JOptionPane.showMessageDialog(null, "No hay suficientes productos en el stock local");
            }else{
                JOptionPane.showMessageDialog(null, "Debe ingresar al menos un producto");
            }
        }                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int i = facturaPrev.getSelectedRow();
        DefaultTableModel temporal = controladorProdcutos.getModelo();
        
        int indice = Integer.parseInt(facturaPrev.getValueAt(i, 0).toString());
        int stock = Integer.parseInt(temporal.getValueAt(indice, 2).toString()) + Integer.parseInt(facturaPrev.getValueAt(i, 2).toString());
        temporal.setValueAt(stock, indice, 2);
        
        
        int subTotal = Integer.parseInt(this.subTotal.getText()) - (Integer.parseInt(facturaPrev.getValueAt(i, 2).toString()) * Integer.parseInt(facturaPrev.getValueAt(i, 3).toString()));
        this.subTotal.setText(""+subTotal);
        modelo.removeRow(i);
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cantidadFac;
    private javax.swing.JTextField codigoFac;
    private javax.swing.JTable facturaPrev;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField nombreFac;
    private javax.swing.JTextField precioFac;
    private javax.swing.JTable productos;
    private javax.swing.JTextField subTotal;
    // End of variables declaration//GEN-END:variables
    
    public Ventanas getControladorNavegacion() {
        return controladorNavegacion;
    }

    public void setControladorNavegacion(Ventanas controladorNavegacion) {
        this.controladorNavegacion = controladorNavegacion;
    }

    public JTable getTable() {
        return productos;
    }

    public Productos getControladorProdcutos() {
        return controladorProdcutos;
    }

    public void setControladorProdcutos(Productos controladorProdcutos) {
        this.controladorProdcutos = controladorProdcutos;
    }
    
}
