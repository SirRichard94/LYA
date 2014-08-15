/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package correo.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 *
 * @author Julio
 */
public class EnviarEmail {
    public void enviar(String destinatario, String asunto, String mensaje){
        Properties prop = new Properties();
        InputStream impoutStream = this.getClass().getClassLoader().
                getResourceAsStream("datos.properties");
        
        
    }
    
}
