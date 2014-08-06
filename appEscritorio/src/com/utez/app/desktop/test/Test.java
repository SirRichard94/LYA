/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utez.app.desktop.test;

import com.utez.app.desktop.Bienvenida;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Koffo
 */
public class Test {
    public static void main(String[] args) {
        JFrame ventana =  new Bienvenida();
        
        ventana.setName("Putos todos");
        ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventana.setVisible(true);
    }
    
}
