/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utez.app.desktop.controlador;

import Utilerias.ConexionSQLServer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utez.app.daos.DaoUsuario;
import utez.app.model.UsuarioBean;
import utez.app.utilidades.Biblioteca;
import static com.utez.app.desktop.Constants.*;

/**
 *
 * @author Koffo
 */
public class ControlSesion {
    private static ControlSesion objeto;
    
    
    public static ControlSesion getInstance(){
        if (objeto == null){
            objeto = new ControlSesion();
        }
        return objeto;
    }
    
    private ControlSesion(){
        
    }
    
    
    private UsuarioBean usuario;
    
    public  boolean iniciarSesion(String correo, String pass){
       boolean aunt = false;
       
            DaoUsuario daoUsuario = new DaoUsuario(new Biblioteca(MYSQL).getConection());
	    
            aunt=daoUsuario.autenticar(correo, pass);
            
            if (aunt){
                UsuarioBean usuario = daoUsuario.findByCorreo(correo);
                this.usuario = usuario;
            }else {
                usuario = null;
            }
       
        
        return aunt;
    }

    public void logout(){
        usuario = null;
    }
    
    public UsuarioBean getUsuario() {
        return usuario;
    }
    
    public boolean isAdmin(){
        try{
     return usuario.isEs_admi();
        }catch(NullPointerException e){
            return false;
        }
    }
    public boolean sesionIniciada(){
     return usuario != null;
    }

    
    
}
