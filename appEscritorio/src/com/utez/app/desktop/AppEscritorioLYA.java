/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utez.app.desktop;

//import javafx.scene.input.KeyCode;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Koffo
 */
public class AppEscritorioLYA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	    try {
		    
		    UIManager.setLookAndFeel(
			    UIManager.getSystemLookAndFeelClassName());
	    } catch (ClassNotFoundException ex) {
		    Logger.getLogger(AppEscritorioLYA.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (InstantiationException ex) {
		    Logger.getLogger(AppEscritorioLYA.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (IllegalAccessException ex) {
		    Logger.getLogger(AppEscritorioLYA.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (UnsupportedLookAndFeelException ex) {
		    Logger.getLogger(AppEscritorioLYA.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    
	    
       
	    JFrame app = new Bienvenida();
	    app.setResizable(false);
	    app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    app.setVisible(true);
	    
        
    }

   
   
    
}
