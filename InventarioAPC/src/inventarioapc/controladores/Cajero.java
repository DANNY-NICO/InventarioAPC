/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioapc.controladores;

/**
 *
 * @author nicolas soler & danny ochoa
 * Clase encargada de administrar toda la funcionalidad del cajero, interactuando entre las distintas vistas y consultas
 */
public class Cajero {
    
    private inventarioapc.vistas.CajeroInicio cajero;
    private inventarioapc.vistas.CajeroFacturaDetalle detalle;
    private inventarioapc.vistas.CajeroFactura factura;
    private inventarioapc.controladores.Producto productos;
    private inventarioapc.controladores.Personas personas;

    /**
     * los parametros cajero, detalle y factura representan las vistas del usuario respectivamente, asi mismo las variables productos y personsas 
     * son los controladores de estos mismos, en los cuales se realizaran las consultas de datos etc.
     * @param cajero
     * @param detalle
     * @param factura
     * @param productos
     * @param personas 
     */
    public Cajero(inventarioapc.vistas.CajeroInicio cajero, inventarioapc.vistas.CajeroFacturaDetalle detalle, inventarioapc.vistas.CajeroFactura factura, inventarioapc.controladores.Producto productos, inventarioapc.controladores.Personas personas) {
    
        this.cajero = cajero;
        this.detalle = detalle;
        this.factura = factura;
        this.productos = productos;
        this.personas = personas;
    }
    
    
}
