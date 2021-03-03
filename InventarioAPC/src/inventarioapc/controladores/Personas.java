/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioapc.controladores;

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
    private inventarioapc.controladores.Producto productos;

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
    public Personas(inventarioapc.vistas.CrearEmpleado crearEmpleado, inventarioapc.vistas.Empleados empleado, inventarioapc.vistas.CrearProveedor crearProveedor, inventarioapc.vistas.Proveedores proveedor, inventarioapc.vistas.Administrador administrador, inventarioapc.controladores.Producto producto) {
        this.crearEmpleado = crearEmpleado;
        this.empleado = empleado;
        this.crearProveedor = crearProveedor;
        this.proveedor = proveedor;
        this.administrador = administrador;
        this.productos = producto;
    }
    
}
