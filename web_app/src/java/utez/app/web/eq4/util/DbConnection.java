/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web.eq4.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdrianCruz
 */
public class DbConnection {
private static Connection connection = null;
    public static Connection getConnection() {
        String driver="", url="",user="", password="";                
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();//UTILidad para leer propiedades
                //referencia al flujo de entrada de bytes:
                InputStream inputStream = DbConnection.class.getClassLoader().
                        getResourceAsStream("/db.properties");//buscar el recurso db.properties, debe estar en src
                prop.load(inputStream); //cargar el archivo de propiedades
                driver = prop.getProperty("driver");//recuperar valor de clave driver
                url = prop.getProperty("url");//recuperar valor de clave url
                user = prop.getProperty("user");//recuperar valor de clave user
                password = prop.getProperty("password");//recuperar valor de clave password
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);                                    
                
            } catch(FileNotFoundException ex){
                System.out.println("******* no se enocntró el archivo");
            }
            catch (IOException ex) {
                System.out.println("******* problema al leer el archivo de propiedades");
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);                
            } catch (SQLException ex) {
                System.out.println("****** problema al establecer la conección .getConnection("+url+","+ user+","+ password+")");
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);                
            } catch (ClassNotFoundException ex) {
                System.out.println("****** problema al cargar el Driver: Class.forName("+driver+")");
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);                
            } catch(Exception e){
                System.out.println("***** error no identificado");
		e.printStackTrace();
            }finally{
		    connection = MyConexion.getConnection();
	    }
            return connection;
        }

	
	
    }
    
    public static void main(String[] args){
		if (getConnection() != null){
			System.out.println("Exito!");
		}
	}
}
