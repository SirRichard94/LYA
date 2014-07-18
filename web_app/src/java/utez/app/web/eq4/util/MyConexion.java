/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web.eq4.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.tomcat.dbcp.dbcp.DriverManagerConnectionFactory;

/**
 *
 * @author ricardo
 */
public class MyConexion {
	private static Connection connection = null;
    public static Connection getConnection() {
		try {
			String driver="com.mysql.jdbc.Driver", 
				url="jdbc:mysql://localhost:3306/SB_LYA",
				user="root", password="pass";
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException  ex) {
			Logger.getLogger(MyConexion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(MyConexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		return connection;
    }
}
