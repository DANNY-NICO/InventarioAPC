/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioapc.controladores;

import inventarioapc.modelos.Producto;
import inventarioapc.modelos.Proveedor;
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
    private DefaultTableModel modelo;

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
        modelo = new DefaultTableModel();
        cargarTabla();
    }
    
    public void crearProveedor(){
        Proveedor temporal = new Proveedor();
        temporal.setCorreo(crearProveedor.getCorreo().getText());
        temporal.setContacto(crearProveedor.getContacto().getText());
        temporal.setDocumento(convertirStringInt(crearProveedor.getCodigo().getText()));
        temporal.setEmpresa(crearProveedor.getEmpresa().getText());
        temporal.setCodigoProducto(crearProveedor.getProductos().getSelectedItem()+"");
        temporal.setPrecio(convertirStringInt(crearProveedor.getPrecio().getText()));
        
        agregarFila(temporal);
    }
    
    public int convertirStringInt (String n){
        try {
            return Integer.parseInt(n);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public void agregarFila(Proveedor entrante){
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
            
    public void cargarTabla(){
                 
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
    
    public void eliminarFila(){
        int i = proveedor.getTable().getSelectedRow();
        
        if(i>=0){
            modelo.removeRow(i);
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione fila");
        }
    }
    
}
