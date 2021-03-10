/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioapc.controladores;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author nicolas soler & danny ochoa
 * Clase encargada de realizar la coneccion y verificacion de datos en el inicio de sesion
 * 
 */
public class Autentificacion {
   
    private inventarioapc.vistas.IniciarSesion vistaInicioSesion;
    Connection conn = null;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * la ventana es la vista del inicio de sesion vista por el usuario
     * @param ventana 
     */
    public Autentificacion(inventarioapc.vistas.IniciarSesion ventana){
        this.vistaInicioSesion = ventana;
    } 
    
    //METODOS PARA LA AUTENTIFICACION DEL USUARIO
    public String autentificacion(){
        
        String usuario = vistaInicioSesion.getUsuario().getText();
        String contraseña = vistaInicioSesion.getContraseña().getText();
        String respuesta = "denegado";
        ArrayList<String> db= new ArrayList<String>();
                
        String sql = "SELECT * FROM primera_entrega.tbusuario";
        try {
            conn = Conexion.coneBd();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                db.add(rs.getString(2));
                db.add(rs.getString(3));
            }
        } catch (Exception e) {
            System.err.println("error en el usuario"+e);
        }
        
        for (int i=0; i<db.size()/2; i++){
            if(db.get(i).equals(usuario)&&db.get(i+1).equals(contraseña)){
                respuesta = "aceptado";
            }
        }
        if(respuesta=="denegado"){
            JOptionPane.showMessageDialog(null, "Usuario o contraseña invalidos");
        }
        return respuesta;
    }
    
}
