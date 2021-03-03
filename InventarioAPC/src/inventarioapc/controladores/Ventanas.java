/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioapc.controladores;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author nicolas soler & danny ochoa
 * Clase encargada de toda la navegacion del aplicativo
 * 
 */
public class Ventanas {
   
    private ArrayList<JPanel> lista;
    private JPanel main;

    /**
     * Cada uno de los parametros se refiere a una ventana mostrada en el aplicativo, cada uno es un JPAnel  los cuales seran almacenados en la lista
     * @param boton
     * @param inicioSesion
     * @param cajero
     * @param facturaDetalle
     * @param factura
     * @param crearProducto
     * @param empleados
     * @param inventario
     * @param proveedor
     * @param contenedor
     * @param crearEmpleado
     * @param crearProveedor
     * @param administrador 
     */
    public Ventanas(JPanel boton, JPanel inicioSesion, JPanel cajero, JPanel facturaDetalle, JPanel factura, JPanel crearProducto, JPanel empleados, JPanel inventario, JPanel proveedor, JPanel contenedor, JPanel crearEmpleado, JPanel crearProveedor, JPanel administrador) {
        
        //-------------INICIO DE LA LISTA CON LAS VENTANAS----
        lista = new ArrayList<JPanel>();
        lista.add(inicioSesion);
        lista.add(cajero);
        lista.add(facturaDetalle);
        lista.add(factura);
        lista.add(crearProducto);
        lista.add(empleados);
        lista.add(inventario);
        lista.add(proveedor);
        lista.add(crearEmpleado);
        lista.add(crearProveedor);
        lista.add(administrador);
        
        //------------Frame principal-------------------------
        this.main = contenedor;
        
        main.add(inicioSesion);
        
        System.out.println("INICIO CORRECTAMENTE");
    }
    
    /**
     * Metodo encargado de realizar el cambio entre ventana siguiendo la siguiente tabla de asignacion
     * 
     * 0 = inicio Sesion
     * 1 = cajero
     * 2 = facturaDetalle
     * 3 = factura
     * 4 = crearProducto
     * 5 = empleados
     * 6 = inventario
     * 7 = proveedor
     * 8 = crear empleado
     * 9 = crear proveedor
     * 10 = administrador
     * @param nuevaVentana 
     */
    public void cambioVentana(int nuevaVentana){
        switch( nuevaVentana ){
            case 0:
                main.remove(1);
                main.updateUI();
                main.repaint();
                main.add(lista.get(0));
                break;
            
            case 1:
                main.remove(1);
                main.updateUI();
                main.repaint();
                main.add(lista.get(1));
                break;
                
            case 2: 
                main.remove(1);
                main.updateUI();
                main.repaint();
                main.add(lista.get(2));
                break;
                
            case 3:
                main.remove(1);
                main.updateUI();
                main.repaint();
                main.add(lista.get(3));
                break;
                
            case 4:
                main.remove(1);
                main.updateUI();
                main.repaint();
                main.add(lista.get(4));
                break;
                
            case 5:
                main.remove(1);
                main.updateUI();
                main.repaint();
                main.add(lista.get(5));
                break;
                
            case 6:
                main.remove(1);
                main.updateUI();
                main.repaint();
                main.add(lista.get(6));
                break;
                
            case 7:
                main.remove(1);
                main.updateUI();
                main.repaint();
                main.add(lista.get(7));
                break;
                
            case 8:
                main.remove(1);
                main.updateUI();
                main.repaint();
                main.add(lista.get(8));
                break;
                
            case 9:
                main.remove(1);
                main.updateUI();
                main.repaint();
                main.add(lista.get(9));
                break;
                
            case 10:
                main.remove(1);
                main.updateUI();
                main.repaint();
                main.add(lista.get(10));
                break;
        } 
    }
    
}
