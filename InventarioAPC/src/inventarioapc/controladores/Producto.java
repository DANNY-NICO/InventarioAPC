/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioapc.controladores;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicolas soler & danny ochoa
 * Clase encargada de realizar la consulta y carga a la base de datos con todo lo referente a los productos
 * 
 */
public class Producto {
    
    private inventarioapc.vistas.CrearProducto crearProducto;
    private inventarioapc.vistas.Inventario inventario;
    private DefaultTableModel modelo;
    
    /**
     * Los parametros son las vistas especificas para el acceso a los campos que el usuario vera e interactuara con respecto a los productos
     * @param crearProducto
     * @param inventario 
     */
    public Producto(inventarioapc.vistas.CrearProducto crearProducto, inventarioapc.vistas.Inventario inventario){
        this.crearProducto = crearProducto;
        this.inventario = inventario;
        inventario.setControlador(this);
        modelo = new DefaultTableModel();
        cargarTabla();
    } 

    public void cargarTabla(){
         
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("P. Venta");
        modelo.addColumn("P. Compra");
        modelo.addColumn("Stock");
        
        String info[] = new String[5];
        info[0]="1";
        info[1]="prueba";
        info[2]="intento A";
        info[3]="intento B";
        info[4]="10";
        
        modelo.addRow(info);
        
        inventario.getTable().setModel(modelo);
        
        System.out.println(inventario.getTable());
    }
    
    public void eliminarFila(){
        int i = inventario.getTable().getSelectedRow();
        
        if(i>=0){
            modelo.removeRow(i);
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione fila");
        }
    }
    
}