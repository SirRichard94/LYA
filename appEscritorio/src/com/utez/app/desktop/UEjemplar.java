/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utez.app.desktop;

import Utilerias.ConexionSQLServer;
import static com.utez.app.desktop.Constants.*;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utez.app.daos.DaoEditorial;
import utez.app.daos.DaoEjemplar;
import utez.app.daos.DaoLibro;
import utez.app.daos.DaoPrestamo;
import utez.app.model.EditorialBean;
import utez.app.model.EjemplarBean;
import utez.app.model.LibroBean;
import utez.app.utilidades.Biblioteca;


/**
 *
 * @author Koffo
 */
public class UEjemplar extends javax.swing.JFrame {
    //private List<UsuarioBean> lista;
    //private DaoUsuario daoUsuario;
    private Connection conexion;
    private List<LibroBean>libroBeans;
    private EjemplarBean consultaBean;
    private DaoEjemplar daoEjemplar;
    
    public UEjemplar() {
        conexion = new Biblioteca(MYSQL).getConection();
		
       DaoLibro daoLibro=new DaoLibro(conexion);
       daoEjemplar = new DaoEjemplar(conexion);
        libroBeans=daoLibro.getActive();
        for (LibroBean beanLib : libroBeans) {
            modeloLibro.addElement(beanLib.getNombre());
        }
        
        initComponents();
                this.setLocationRelativeTo(null);

    }
    List<EjemplarBean> ejemplares;
    UEjemplar (int... ids ){
	    this();
	    ejemplares = new ArrayList();
	    for (int i : ids) {
		    ejemplares.add(daoEjemplar.get(i));
	    }
	    if (ejemplares.size() > 0){
		modeloLibro.setSelectedItem(ejemplares.get(0).getLibro().getNombre());
		txtLocalizacion.setText(ejemplares.get(0).getLocalizacion());
	    }else{
		    this.dispose();
	    }
    }
    public boolean comprobarTexto(String dato) {
        boolean valido = false;
        if (dato.length() > 0) {
            valido = true;
        }

        return valido;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();
                txtLocalizacion = new javax.swing.JTextField();
                btnCrear = new javax.swing.JButton();
                btnCancelar = new javax.swing.JButton();
                cmbLibro = new javax.swing.JComboBox();
                jLabel3 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Ejemplar"));

                jLabel2.setText("Localizacion");

                txtLocalizacion.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtLocalizacionActionPerformed(evt);
                        }
                });
                txtLocalizacion.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyTyped(java.awt.event.KeyEvent evt) {
                                txtLocalizacionKeyTyped(evt);
                        }
                });

                btnCrear.setText("Guardar");
                btnCrear.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCrearActionPerformed(evt);
                        }
                });
                btnCrear.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                btnCrearKeyPressed(evt);
                        }
                });

                btnCancelar.setText("Cancelar");
                btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelarActionPerformed(evt);
                        }
                });

                cmbLibro.setModel(modeloLibro);

                jLabel3.setText("Libro");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 70, Short.MAX_VALUE)
                                                .addComponent(btnCrear)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnCancelar)
                                                .addGap(23, 23, 23))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(cmbLibro, javax.swing.GroupLayout.Alignment.LEADING, 0, 193, Short.MAX_VALUE)
                                                        .addComponent(txtLocalizacion, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmbLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCrear)
                                        .addComponent(btnCancelar)))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnCrearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCrearKeyPressed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_btnCrearKeyPressed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        DaoEjemplar daoEjemplar= new DaoEjemplar(conexion);
        
        LibroBean libro = libroBeans.get(cmbLibro.getSelectedIndex());
         consultaBean=new EjemplarBean();
         consultaBean.setLocalizacion(txtLocalizacion.getText());
         consultaBean.setLibro(libro);
        
        for (EjemplarBean ejemplar : ejemplares){
	     consultaBean.setEjemplar_id(ejemplar.getEjemplar_id());
             if(!daoEjemplar.update(consultaBean)){
                 JOptionPane.showMessageDialog(rootPane, "Error al registrar");
                 return;
             }
        }
         JOptionPane.showMessageDialog(rootPane, "Registro Exitoso");
         JFrame jf = new Ejemplares(); jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	       jf.setVisible(true);
         this.dispose();
            
        
    }//GEN-LAST:event_btnCrearActionPerformed
    
    private void txtLocalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalizacionActionPerformed

    private void txtLocalizacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalizacionKeyTyped
        // TODO add your handling code here:
         char car = evt.getKeyChar();
       if((car<'a' || car>'z') && (car<'A' || car>'Z')            
        && car !='á' //Minúsculas            
        && car !='é'           
        && car !='í'           
        && car !='ó'          
        && car !='ú'  
        && car !='Á' //Mayúsculas            
        && car !='É'           
        && car !='Í'           
        && car !='Ó'
        && car !='Ú'
        && car !='ñ'
        && car !='Ñ'    
        && (car!=(char)KeyEvent.VK_SPACE))
    {     
    evt.consume();  

    }
    }//GEN-LAST:event_txtLocalizacionKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        
	       this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UEjemplar().setVisible(true);
            }
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnCancelar;
        private javax.swing.JButton btnCrear;
        private javax.swing.JComboBox cmbLibro;
        private DefaultComboBoxModel modeloLibro=new DefaultComboBoxModel();
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField txtLocalizacion;
        // End of variables declaration//GEN-END:variables
}
