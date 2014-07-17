/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PROFESOR
 */
public class ConexionSQLServer {

    // Parametros necesarios
    private static final String ipAddress = "localhost"; //nota: localhost= 127.0.0.1
    private static final String dbName = "SB_LYA";
    private static final String user = "sa";
    private static final String password = "Elielo-03";
    private static final String service = "1433";
    
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlserver://" + ipAddress + ":" + service + ";databaseName=" + dbName;
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) throws SQLException {
        Connection con = ConexionSQLServer.getConnection();
        if (con != null) {
            System.out.println("Conexión exitosa");
        }
    }
}
