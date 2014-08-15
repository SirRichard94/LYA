/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.utilidades;

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
 * @author AdrianCruz
 */
public class EnviarMail {
    /**
     *      
     * @param destinatario xy@gmail.com
     * @param asunto        recordatorio LeeyAprende
     * @param mensaje       Cuerpo del mensaje...
     */
    public void enviar(String destinatario, String asunto, String mensaje){
      try
        {            
            Properties prop = new Properties();//UTILidad para leer propiedades                
            InputStream inputStream = this.getClass().getClassLoader().
                  getResourceAsStream("datos.properties");//buscar el recurso datos.properties, debe estar en src
            prop.load(inputStream); //cargar el archivo de propiedades                                
            // Preparamos la sesion
            Session session = Session.getDefaultInstance(prop);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(prop.getProperty("mail.smtp.user")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);            
            message.setText(mensaje, 
                            prop.getProperty("utez.coding"),
                            prop.getProperty("utez.MIME.subtype")
            );
            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(prop.getProperty("mail.smtp.user"), prop.getProperty("utez.gmail.pass"));
            t.sendMessage(message, message.getAllRecipients());
            // Cierre.
            t.close();
            System.out.println("mensaje enviado");
        }
        catch (MessagingException e)
        {
            System.err.println("error: "+e.getMessage());
            //e.printStackTrace();
        } catch (IOException ex) {
              System.out.println("******* problema al leer el archivo de propiedades");
             //Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
 }