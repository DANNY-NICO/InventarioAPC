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
import java.sql.SQLException;
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
    private boolean primerProveedor;
    private boolean primerEmpleado;
    private int codigoProveedor;
    private int codigoEmpleado;

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
        primerEmpleado=true;
        primerProveedor=true;
        cargarTablaProveedor();
        cargarTablaEmpleado();
    }
    
    //EMPLEADO
    public void crearEmpleado(){
        try {
        conn = Conexion.coneBd();   
        ps = conn.prepareStatement("INSERT INTO tbempleado(cod_emp, ced_emp, nom_emp, ape_emp, cor_emp, dir_emp, sal_emp) VALUES(?,?,?,?,?,?,?) ");
        ps.setInt(1, codigoEmpleado);
        codigoEmpleado++;
        ps.setString(2, crearEmpleado.getCedula().getText());
        ps.setString(3, crearEmpleado.getNombre().getText());
        ps.setString(4, crearEmpleado.getApellido().getText());
        ps.setString(5, crearEmpleado.getCorreo().getText());
        ps.setString(6, crearEmpleado.getDireccion().getText());
        ps.setDouble(7, Double.parseDouble(crearEmpleado.getSueldo().getValue().toString()));
        
        int res = ps.executeUpdate();
        
        if (res > 0) {
            listarEmpleado();
            JOptionPane.showMessageDialog(null, "Empleado guardado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar empleado");
        }
        conn.close();
        } catch(Exception e) {
            System.err.println(e);
        }
    }
    
    public void cargarEditarEmpleado(){
        DefaultTableModel modelo = (DefaultTableModel) empleado.getTable().getModel();
        
        int i = empleado.getTable().getSelectedRow();
        
        crearEmpleado.codigoEdit = Integer.parseInt(""+modelo.getValueAt(i, 0));
        
        crearEmpleado.getCedula().setText(""+modelo.getValueAt(i, 1));
        crearEmpleado.getNombre().setText(""+modelo.getValueAt(i, 2));
        crearEmpleado.getApellido().setText(""+modelo.getValueAt(i, 3));
        crearEmpleado.getCorreo().setText(""+modelo.getValueAt(i, 4));
        crearEmpleado.getDireccion().setText(""+modelo.getValueAt(i, 5));
        crearEmpleado.getSueldo().setValue(Integer.parseInt(""+modelo.getValueAt(i, 6)));
    }
    
    public void cargarTablaEmpleado(){
        DefaultTableModel modelo = (DefaultTableModel) empleado.getTable().getModel();
                 
        modelo.addColumn("Codigo");
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Correo");
        modelo.addColumn("Direccion");
        modelo.addColumn("Salario");
        
        listarEmpleado();
        
        empleado.getTable().setModel(modelo);
    }
    
    public void eliminarEmpleado(){
        int i = empleado.getTable().getSelectedRow();
        Object seleccion = empleado.getTable().getValueAt(i, 0);
        int valor = Integer.parseInt(seleccion.toString());
        
        if(i>=0){
            try {
            DefaultTableModel modelo = (DefaultTableModel) empleado.getTable().getModel();
            String sql = "DELETE FROM primera_entrega.tbempleado WHERE cod_emp = ?";
            conn = Conexion.coneBd();
            PreparedStatement st = conn.prepareCall(sql);
            st.setInt(1, valor);
            st.executeUpdate();
            modelo.removeRow(i);
            } catch (SQLException e) {
                System.err.print(e); 
            }
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione fila");
        }
    }
    
    public void eliminarFilaEmpleado(){
        DefaultTableModel modelo = (DefaultTableModel) empleado.getTable().getModel();
        
        int i = empleado.getTable().getSelectedRow();
        
        if(i>=0){
            int aux = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminarlo?");
            if(aux==0){
                eliminarEmpleado();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione fila");
        }
    }
    
        
    public void listarEmpleado(){
        DefaultTableModel modelo = (DefaultTableModel) empleado.getTable().getModel();
        while(modelo.getRowCount() > 0){
            modelo.removeRow(0);
        }
        
        String sql = "SELECT * FROM primera_entrega.tbempleado";
        try {
            conn = Conexion.coneBd();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            String[]datos = new String[7];
            
            
            while (rs.next()) {
                datos[0] = rs.getString(1); //CODIGO
                datos[1] = rs.getString(2); //CEDULA
                datos[2] = rs.getString(3); //NOMBRE
                datos[3] = rs.getString(4); //APELLIDO
                datos[4] = rs.getString(5); //CORREO
                datos[5] = rs.getString(6); //DIRRECCION
                datos[6] = rs.getString(7); //SALARIO
                
                modelo.addRow(datos);
            }
            if(primerEmpleado){
                codigoEmpleado = Integer.parseInt(datos[0])+1;
                primerEmpleado = false;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public void editarEmpleado(){
        try {
        conn = Conexion.coneBd();   
        ps = conn.prepareStatement("UPDATE tbempleado SET cod_emp=?, ced_emp=?, nom_emp=?, ape_emp=?, cor_emp=?, dir_emp=?, sal_emp=? WHERE cod_emp=? ");
        
        ps.setInt(1, crearEmpleado.codigoEdit);
        ps.setString(2, crearEmpleado.getCedula().getText());
        ps.setString(3, crearEmpleado.getNombre().getText());
        ps.setString(4, crearEmpleado.getApellido().getText());
        ps.setString(5, crearEmpleado.getCorreo().getText());
        ps.setString(6, crearEmpleado.getDireccion().getText());
        ps.setDouble(7, Double.parseDouble(crearEmpleado.getSueldo().getValue().toString()));
        ps.setInt(8, crearEmpleado.codigoEdit);
               
        int res = ps.executeUpdate();
        
        if (res > 0) {
            listarEmpleado();
            JOptionPane.showMessageDialog(null, "Empleado actualizado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar empleado");
        }
        conn.close();
        } catch(Exception e) {
            System.err.println(e);
        }
    }
    
    //PROVEEDOR
    public void crearProveedor(){
        try {
        conn = Conexion.coneBd();   
        ps = conn.prepareStatement("INSERT INTO tbproveedor(cod_prv, nom_prv, cel_prv, cor_prv, des_prv) VALUES(?,?,?,?,?) ");
        ps.setInt(1, codigoProveedor);
        codigoProveedor++;
        ps.setString(2, crearProveedor.getEmpresa().getText());
        ps.setString(3, crearProveedor.getContacto().getText());
        ps.setString(4, crearProveedor.getCorreo().getText());
        ps.setString(5, crearProveedor.getDescripcion().getText());
        
        int res = ps.executeUpdate();
        
        if (res > 0) {
            listarProveedor();
            JOptionPane.showMessageDialog(null, "Proveedor guardado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar proveedor");
        }
        conn.close();
        } catch(Exception e) {
            System.err.println(e);
        }
    }
    
    public void editarProveedor(){
        try {
        conn = Conexion.coneBd();   
        ps = conn.prepareStatement("UPDATE tbproveedor SET cod_prv=?, nom_prv=?, cel_prv=?, cor_prv=?, des_prv=? WHERE cod_prv=? ");
        
        int i = Integer.parseInt(crearProveedor.codigoEdit);
        ps.setInt(1, i);
        ps.setString(2, crearProveedor.getEmpresa().getText());
        ps.setString(3, crearProveedor.getContacto().getText());
        ps.setString(4, crearProveedor.getCorreo().getText());
        ps.setString(5, crearProveedor.getDescripcion().getText());
        ps.setInt(6, i);
        int res = ps.executeUpdate();
        
        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Proveedor actualizado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar proveedor");
        }
        conn.close();
        } catch(Exception e) {
            System.err.println(e);
        }
    }
    
    public void cargarEditarProveedor(){
        DefaultTableModel modelo = (DefaultTableModel) proveedor.getTable().getModel();
        
        int i = proveedor.getTable().getSelectedRow();
        
        crearProveedor.codigoEdit =""+modelo.getValueAt(i, 0);
        crearProveedor.getEmpresa().setText(""+modelo.getValueAt(i, 1));
        crearProveedor.getContacto().setText(""+modelo.getValueAt(i, 2));
        crearProveedor.getCorreo().setText(""+modelo.getValueAt(i, 3));
        crearProveedor.getDescripcion().setText(""+modelo.getValueAt(i, 4));
    }
    
    public void listarProveedor(){
        DefaultTableModel modelo = (DefaultTableModel) proveedor.getTable().getModel();
        while(modelo.getRowCount() > 0){
            modelo.removeRow(0);
        }
        
        String sql = "SELECT * FROM primera_entrega.tbproveedor";
        try {
            conn = Conexion.coneBd();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            String[]datos = new String[5];
            
            
            while (rs.next()) {
                datos[0] = rs.getString(1); //CODIGO
                datos[1] = rs.getString(2); //EMPRESA
                datos[2] = rs.getString(3); //CELULAR
                datos[3] = rs.getString(4); //CORREO
                datos[4] = rs.getString(5); //DESCRIPCION
                modelo.addRow(datos);
                System.out.println(datos[3]);
            }
            if(primerProveedor){
                codigoProveedor = Integer.parseInt(datos[0])+1;
                primerProveedor = false;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public void cargarTablaProveedor(){
        DefaultTableModel modelo = (DefaultTableModel) proveedor.getTable().getModel();
        
        modelo.addColumn("Codigo");
        modelo.addColumn("Empesa");
        modelo.addColumn("Contacto");
        modelo.addColumn("Correo");
        modelo.addColumn("Descripcion");
        
        listarProveedor();
        
        proveedor.getTable().setModel(modelo);
    }
    
    public void eliminarFilaProveedor(){
        DefaultTableModel modelo = (DefaultTableModel) proveedor.getTable().getModel();
        int i = proveedor.getTable().getSelectedRow();
        
        if(i>=0){
            int aux = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminarlo?");
            if(aux==0){
                eliminarProveedor();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione fila");
        }
    }
    
    public void eliminarProveedor(){
        int i = proveedor.getTable().getSelectedRow();
        Object seleccion = proveedor.getTable().getValueAt(i, 0);
        int valor = Integer.parseInt(seleccion.toString());
        
        if(i>=0){
            try {
            DefaultTableModel modelo = (DefaultTableModel) proveedor .getTable().getModel();
            String sql = "DELETE FROM primera_entrega.tbproveedor WHERE cod_prv = ?";
            conn = Conexion.coneBd();
            PreparedStatement st = conn.prepareCall(sql);
            st.setInt(1, valor);
            st.executeUpdate();
            modelo.removeRow(i);
            } catch (SQLException e) {
                System.err.print(e); 
            }
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione fila");
        }
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
