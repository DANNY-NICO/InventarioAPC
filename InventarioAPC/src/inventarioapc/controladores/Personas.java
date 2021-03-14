/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioapc.controladores;

import config.Conexion;
import inventarioapc.modelos.Producto;
import inventarioapc.modelos.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicolas soler & danny ochoa
 * Clase encargada de administrar tanto los proveedores y empleados, tanto su consulta como su creacion
 * 
 */
public class Personas {
    
    private inventarioapc.vistas.CrearEmpleado crearEmpleado;
    private inventarioapc.vistas.Empleados empleado;
    private inventarioapc.vistas.CrearProveedor crearProveedor;
    private inventarioapc.vistas.Proveedores proveedor;
    private inventarioapc.vistas.Administrador administrador;
    private inventarioapc.controladores.Productos productos;
    Connection conn = null;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;

    /**
     * los parametros crearEmpleado, empleado, crearProveedor y proveedor se refieren a las vistas del usuario, 
     * administrador y producto son los controladores respectivos para su consulta en base de datos
     * @param crearEmpleado
     * @param empleado
     * @param crearProveedor
     * @param proveedor
     * @param administrador
     * @param producto 
     */
    public Personas(inventarioapc.vistas.CrearEmpleado crearEmpleado, inventarioapc.vistas.Empleados empleado, inventarioapc.vistas.CrearProveedor crearProveedor, inventarioapc.vistas.Proveedores proveedor, inventarioapc.vistas.Administrador administrador, inventarioapc.controladores.Productos producto) {
        this.crearEmpleado = crearEmpleado;
        this.empleado = empleado;
        this.crearProveedor = crearProveedor;
        this.proveedor = proveedor;
        this.administrador = administrador;
        this.productos = producto;
        cargarTablaProveedor();
        cargarTablaEmpleado();
    }
    
    //EMPLEADO
    public void crearEmpleado(){
        try {
        conn = Conexion.coneBd();   
        ps = conn.prepareStatement("INSERT INTO tbproducto(cod_pro, nom_pro, stk_pro, stk_pro_bod, com_pro, ven_proi) VALUES(?,?,?,?,?,?) ");
        ps.setInt(1, 0);
        /**
         * ps.setString(2, crearProducto.getNombreTxt().getText());
        ps.setInt(3, convertirStringInt(crearProducto.getLocalStock().getValue()+""));
        ps.setInt(4, convertirStringInt(crearProducto.getBodegaStock().getValue()+""));
        ps.setDouble(5, convertirStringDouble(crearProducto.getPrecioCompra().getText()+""));
        ps.setDouble(6, convertirStringDouble(crearProducto.getPrecioVenta().getText()+""));
         */
        
        int res = ps.executeUpdate();
        
        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Empleado guardado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar empleado");
        }
        conn.close();
        } catch(Exception e) {
            System.err.println(e);
        }
    }

    
    public void cargarTablaEmpleado(){
        DefaultTableModel modelo = (DefaultTableModel) empleado.getTable().getModel();
                 
        modelo.addColumn("Empesa");
        modelo.addColumn("Contacto");
        modelo.addColumn("Correo");
        modelo.addColumn("Precio");
        modelo.addColumn("Productos");
        
        
        String info[] = new String[5];
        info[0]="Prueba";
        info[1]="3002582536";
        info[2]="prueba@gmail.com";
        info[3]="15000";
        info[4]="chapa";
        
        modelo.addRow(info);
        proveedor.getTable().setModel(modelo);
    }
    
    public void eliminarFilaEmpleado(){
        DefaultTableModel modelo = (DefaultTableModel) empleado.getTable().getModel();
        int i = empleado.getTable().getSelectedRow();
        
        if(i>=0){
            int aux = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminarlo?");
            if(aux==0){
                modelo.removeRow(i);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione fila");
        }
    }
    
        
    public void listarEmpleado(){
        
    }
    
    //PROVEEDOR
    public void crearProveedor(){
        Proveedor temporal = new Proveedor();
        temporal.setCorreo(crearProveedor.getCorreo().getText());
        temporal.setContacto(crearProveedor.getContacto().getText());
        temporal.setDocumento(convertirStringInt(crearProveedor.getCodigo().getText()));
        temporal.setEmpresa(crearProveedor.getEmpresa().getText());
        temporal.setCodigoProducto(crearProveedor.getProductos().getSelectedItem()+"");
        temporal.setPrecio(convertirStringInt(crearProveedor.getPrecio().getText()));
        
        agregarFilaProveedor(temporal);
    }
    
    public void agregarFilaProveedor(Proveedor entrante){
        DefaultTableModel modelo = (DefaultTableModel) proveedor.getTable().getModel();
        
        String info[] = new String[5];
        info[0]=""+entrante.getEmpresa();
        info[1]=""+entrante.getContacto();
        info[2]=""+entrante.getCorreo();
        info[3]=""+entrante.getPrecio();
        info[4]=""+entrante.getCodigoProducto();
        
        modelo.addRow(info);
        proveedor.getTable().setModel(modelo);
        System.out.println("hechoi");
    }
    
    public void cargarTablaProveedor(){
        DefaultTableModel modelo = (DefaultTableModel) proveedor.getTable().getModel();
        
        for (int i = 0; i < 10; i++) {
            
        }
        
        modelo.addColumn("Empesa");
        modelo.addColumn("Contacto");
        modelo.addColumn("Correo");
        modelo.addColumn("Precio");
        modelo.addColumn("Productos");
        
        String info[] = new String[5];
        info[0]="Prueba";
        info[1]="3002582536";
        info[2]="prueba@gmail.com";
        info[3]="15000";
        info[4]="chapa";
        
        modelo.addRow(info);
        proveedor.getTable().setModel(modelo);
    }
    
    public void eliminarFilaProveedor(){
        DefaultTableModel modelo = (DefaultTableModel) proveedor.getTable().getModel();
        int i = proveedor.getTable().getSelectedRow();
        
        if(i>=0){
            int aux = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminarlo?");
            if(aux==0){
                modelo.removeRow(i);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione fila");
        }
    }
    
        
    public void listarProveedor(){
        
    }
        
    //GENERAL
    public int convertirStringInt (String n){
        try {
            return Integer.parseInt(n);
        } catch (Exception e) {
            return 0;
        }
    }
       
}
