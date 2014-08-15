/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.utilidades;



/**
 *
 * @author AdrianCruz
 */
public class Correo {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args)
    {
        EnviarMail correo=new EnviarMail();        
        String to="SirRichard94@gmail.com"; //destinatario gmail | hotmail | yahoo | etc...
        String subject="asuntoX8";
        //si(utez.MIME.subtype=html) se pueden utilizar etiquetas html
        String body="Cuerpo del mensaje <br />nueva línea <h1>Lee y Aprende</h1>";
        correo.enviar(to,subject,body);
    }
}
