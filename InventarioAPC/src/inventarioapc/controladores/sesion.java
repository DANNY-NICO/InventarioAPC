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
public class sesion {
    
    private boolean autentificado;
    private String usuario;

    public boolean isAutentificado() {
        return autentificado;
    }

    public void setAutentificado(boolean autentificado) {
        this.autentificado = autentificado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
