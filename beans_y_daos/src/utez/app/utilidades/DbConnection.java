/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricardo
 */
class DbConnection {
	private static Connection connection = null;
	
	public static Connection getConnection(boolean mysql){
		if (mysql){
			return getMysqlConnection();
		}else{
			return getSQLConnection();
		}
	}
	
	private static Connection getMysqlConnection() {
		
		String driver="com.mysql.jdbc.Driver", 
		url="jdbc:mysql://localhost:3306/SB_LYA",
		user="root", password="pass";
		
		try {
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException  ex) {
			
		} catch (SQLException ex) {
			
		}
		return connection;
    }
	
	private static Connection getSQLConnection() {
		 final String ipAddress = "localhost"; //nota: localhost= 127.0.0.1
		 final String dbName = "SB_LYA";
		 final String user = "sa";
		 final String password = "root";
		 final String service = "1433";
		
		try {
                    String url = "jdbc:sqlserver://" + ipAddress + ":" + service + ";databaseName=" + dbName;
                    System.out.println("conexion=DriverManager.getConnection("+url+", "+user+", "+password+");");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
		connection =  DriverManager.getConnection(url, user, password);
                    
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			
		}
		return connection;
	}


}
