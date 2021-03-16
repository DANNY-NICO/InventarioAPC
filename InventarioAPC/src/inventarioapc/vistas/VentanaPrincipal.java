/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioapc.vistas;

import javax.swing.JDialog;
import javax.swing.UIManager;

/**
 *
 * @author nicolas soler & danny ochoa
 * VENTANA DE DESPLIEGUE GENERAL
 * Vista princiapal actua como Main central, donde inicializamos la mayoria de componentes para que compartan direcciones
 * 
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    //CONTROLADORES
    private inventarioapc.controladores.Ventanas controladorVentanas;
    private inventarioapc.controladores.Productos controladorProducto;
    private inventarioapc.controladores.Personas controladorPersonas;
    private inventarioapc.controladores.Cajero controladorCajero;
    private inventarioapc.controladores.sesion contradorSesion;
    
    // VENTANAS
    private inventarioapc.vistas.IniciarSesion iniciarSesion;
    private inventarioapc.vistas.CajeroInicio cajero;
    private inventarioapc.vistas.CajeroFacturaDetalle facturaDetalle;
    private inventarioapc.vistas.CajeroFactura factura;
    private inventarioapc.vistas.CrearProducto crearProducto;
    private inventarioapc.vistas.Empleados empleados;
    private inventarioapc.vistas.Inventario inventario;
    private inventarioapc.vistas.Proveedores proveedor;
    private inventarioapc.vistas.CrearEmpleado crearEmpleado;
    private inventarioapc.vistas.CrearProveedor crearProveedor;
    private inventarioapc.vistas.Administrador administrador;
    
    /**
     * Constructor del aplicativo general, inicializamos las ventanas y controladores, 
     * se asignan las ventanas a los controladores segun requerimientos
     * asignamos el controlador de las ventanas a cada una de las vistas creadas para asi generar una coneccion directas al mismo objeto
     */
    public VentanaPrincipal() {
        initComponents();
        
        
        iniciarSesion = new inventarioapc.vistas.IniciarSesion();
        factura = new inventarioapc.vistas.CajeroFactura();
        facturaDetalle = new inventarioapc.vistas.CajeroFacturaDetalle(factura);
        cajero = new inventarioapc.vistas.CajeroInicio(facturaDetalle);
        crearProducto = new inventarioapc.vistas.CrearProducto();
        empleados = new inventarioapc.vistas.Empleados();
        inventario = new inventarioapc.vistas.Inventario();
        proveedor = new inventarioapc.vistas.Proveedores();
        crearEmpleado = new inventarioapc.vistas.CrearEmpleado();
        crearProveedor = new inventarioapc.vistas.CrearProveedor();
        administrador = new inventarioapc.vistas.Administrador();
        
        
        controladorVentanas = new inventarioapc.controladores.Ventanas(botones1, iniciarSesion, cajero, facturaDetalle, factura, crearProducto, empleados, inventario, proveedor, contenedor, crearEmpleado, crearProveedor, administrador);
        controladorProducto = new inventarioapc.controladores.Productos(crearProducto, inventario, administrador, cajero);
        controladorPersonas = new inventarioapc.controladores.Personas(crearEmpleado, empleados, crearProveedor, proveedor, administrador, controladorProducto);
        controladorCajero = new inventarioapc.controladores.Cajero(cajero, facturaDetalle, factura, controladorProducto, controladorPersonas);
        contradorSesion = new inventarioapc.controladores.sesion();
        
        //ASIGNACION DE CONTROLADOR DE VENTANAS
        proveedor.setControladorNavegacion(controladorVentanas);
        inventario.setControladorNavegacion(controladorVentanas);
        iniciarSesion.setControladorNavegacion(controladorVentanas);
        empleados.setControladorNavegacion(controladorVentanas);
        crearProveedor.setControladorNavegacion(controladorVentanas);
        crearProducto.setControladorNavegacion(controladorVentanas);
        crearEmpleado.setControladorNavegacion(controladorVentanas);
        cajero.setControladorNavegacion(controladorVentanas);
        facturaDetalle.setControladorNavegacion(controladorVentanas);
        factura.setControladorNavegacion(controladorVentanas);
        administrador.setControladorNavegacion(controladorVentanas);
        
        //ASIGNACION DE CONTROLADOR DE PRODUCTOS
        crearProducto.setControladorProductos(controladorProducto);
        proveedor.setControladorPersonas(controladorPersonas);
        crearProveedor.setControladorPersonas(controladorPersonas);
        administrador.setControladorProductos(controladorProducto);
        cajero.setControladorProdcutos(controladorProducto);
        
        //ASIGNACION DE CONTROLADOR DE PERSONAS
        empleados.setControladorPersonas(controladorPersonas);
        crearEmpleado.setControladorPersonas(controladorPersonas);
        
        //ASIGNACION DE CONTROLADOR DE SESION
        iniciarSesion.setSesion(contradorSesion);
        
        botones1.setControladorVentana(controladorVentanas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        botones1 = new inventarioapc.vistas.Botones();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APC APP");
        setExtendedState(6);
        setName("ventanPrincipal"); // NOI18N

        contenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contenedor.setMinimumSize(new java.awt.Dimension(2500, 2500));
        contenedor.setName(""); // NOI18N
        contenedor.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(236, 255, 236));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(909, Short.MAX_VALUE)
                .addComponent(botones1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(894, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        contenedor.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(contenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                  try {
                    VentanaPrincipal.setDefaultLookAndFeelDecorated(true);
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    
                }
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private inventarioapc.vistas.Botones botones1;
    private javax.swing.JPanel contenedor;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
