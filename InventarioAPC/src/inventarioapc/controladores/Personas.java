/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioapc.controladores;

/**
 *
 * @author nicolas
 */
public class Personas {
    
    private inventarioapc.vistas.CrearEmpleado crearEmpleado;
    private inventarioapc.vistas.Empleados empleado;
    private inventarioapc.vistas.CrearProveedor crearProveedor;
    private inventarioapc.vistas.Proveedores proveedor;
    private inventarioapc.vistas.Administrador administrador;
    private inventarioapc.controladores.Producto productos;

    public Personas(inventarioapc.vistas.CrearEmpleado crearEmpleado, inventarioapc.vistas.Empleados empleado, inventarioapc.vistas.CrearProveedor crearProveedor, inventarioapc.vistas.Proveedores proveedor, inventarioapc.vistas.Administrador administrador, inventarioapc.controladores.Producto producto) {
        this.crearEmpleado = crearEmpleado;
    }
}
