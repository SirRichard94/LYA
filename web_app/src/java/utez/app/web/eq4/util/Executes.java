/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
****   actualizar: executeUpdate();
****   consultar:  sexecuteQuery(query);
 */

package utez.app.web.eq4.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AdrianCruz
 */
public class Executes {   
    /**
     * 
     * @param conexion la conexión a la BD
     * @param query  e.j.: select * from ...
     * @return ResultSet|null
     */
    public static ResultSet consultar(Connection conexion, String query){
        ResultSet rs=null;
        try {            
            Statement s=conexion.createStatement();
            rs=s.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(Executes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
   public static boolean esAdmin(HttpServletRequest request){
       boolean admin=false;
        HttpSession sesion = request.getSession();        
        admin=(Boolean)sesion.getAttribute("admin");
       return admin;                       
   } 
   public static boolean actualizar(Connection conexion, String sql){
       boolean actualizo=false;
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.executeUpdate();
            actualizo=true;
        } catch (SQLException ex) {
            Logger.getLogger(Executes.class.getName()).log(Level.SEVERE, null, ex);
        }
       return actualizo;
   }
}










