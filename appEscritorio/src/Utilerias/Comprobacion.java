/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilerias;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author Koffo
 */
public class Comprobacion {
    
    
    
    public boolean correo(String dato){
        boolean validado;
         String correo ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
          //String texto ="^[-{0,1}][0-9]*";
          Pattern patron = Pattern.compile(correo);
        Matcher match = patron.matcher((CharSequence) dato);
        
        if(match.matches()){
           
            validado=true;
        }else{
            JOptionPane.showMessageDialog(null, "No Valido");
            validado =false;
        }
        
        return validado;
}

    
}

