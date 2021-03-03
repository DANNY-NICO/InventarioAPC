/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioapc.controladores;

import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class Autentificacion {
   
    private inventarioapc.vistas.IniciarSesion vistaInicioSesion;
    
    public Autentificacion(inventarioapc.vistas.IniciarSesion ventana){
        this.vistaInicioSesion = ventana;
    } 
    
    //METODOS PARA LA AUTENTIFICACION DEL USUARIO
    public String autentificacion(){
        
        String usuario = vistaInicioSesion.getUsuario().getText();
        String contraseña = vistaInicioSesion.getContraseña().getText();
        String respuesta = "denegado";
        
        if(usuario.equals("") || contraseña.equals("")){
            JOptionPane.showMessageDialog(null, "Debe llenar los campos usuario y contraseña");
        }else {
            System.out.println(usuario + "//" +contraseña);
            respuesta = "aceptado";
        }
        return respuesta;
    }
    
}
