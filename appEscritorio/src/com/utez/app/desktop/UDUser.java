/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.app.desktop;

import Utilerias.Comprobacion;
import Utilerias.ConexionSQLServer;
import static com.utez.app.desktop.Constants.*;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxEditor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utez.app.daos.DaoUsuario;
import utez.app.model.UsuarioBean;
import utez.app.utilidades.Biblioteca;

/**
 *
 * @author Koffo
 */
public class UDUser extends javax.swing.JFrame {

    //private List<UsuarioBean> lista;
    //private DaoUsuario daoUsuario;
    private Connection conexion;
    private UsuarioBean usuarioBean;
    private UsuarioBean consultaBean;

    public UDUser() {
	conexion = new Biblioteca(MYSQL).getConection();

        initComponents();
        this.setLocationRelativeTo(null);

    }

    public UDUser(UsuarioBean consultaBean) {
        this();
        this.consultaBean = consultaBean;
        llenarValores();
    }

    private void llenarValores() {
        txtNombre.setText(consultaBean.getNombre());
        txtDireccion.setText(consultaBean.getDireccion());
        txtTelefono.setText(consultaBean.getTelefono());
        txtCorreo.setText(consultaBean.getCorreo());
        txtPass.setText(consultaBean.getPasswd());
        if (consultaBean.isEs_admi()) {
            cmbTipo.setSelectedIndex(0);
        } else {
            cmbTipo.setSelectedIndex(1);
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

                jComboBox2 = new javax.swing.JComboBox();
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel7 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                txtNombre = new javax.swing.JTextField();
                txtDireccion = new javax.swing.JTextField();
                txtTelefono = new javax.swing.JTextField();
                txtCorreo = new javax.swing.JTextField();
                txtPass = new javax.swing.JTextField();
                btnActualizar = new javax.swing.JButton();
                btnCancelar = new javax.swing.JButton();
                cmbTipo = new javax.swing.JComboBox();
                jLabel10 = new javax.swing.JLabel();

                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Actualizar Usuario"));

                jLabel1.setText("Nombre");

                jLabel2.setText("Direcciòn:");

                jLabel3.setText("Correo");

                jLabel7.setText("Teléfono");

                jLabel8.setText("Contraseña");

                txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyTyped(java.awt.event.KeyEvent evt) {
                                txtNombreKeyTyped(evt);
                        }
                });

                txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyTyped(java.awt.event.KeyEvent evt) {
                                txtDireccionKeyTyped(evt);
                        }
                });

                txtTelefono.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtTelefonoActionPerformed(evt);
                        }
                });
                txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyTyped(java.awt.event.KeyEvent evt) {
                                txtTelefonoKeyTyped(evt);
                        }
                });

                btnActualizar.setText("Guardar");
                btnActualizar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnActualizarActionPerformed(evt);
                        }
                });
                btnActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                btnActualizarKeyPressed(evt);
                        }
                });

                btnCancelar.setText("Cancelar");
                btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelarActionPerformed(evt);
                        }
                });

                cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "User" }));

                jLabel10.setText("Tipo");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(11, 11, 11)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                                                                .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(txtDireccion)))))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnActualizar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancelar)))
                                .addGap(0, 10, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(42, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel10)
                                                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(70, 70, 70))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnCancelar)
                                                        .addComponent(btnActualizar))
                                                .addContainerGap())))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnActualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_btnActualizarKeyPressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        DaoUsuario daoUsuario = new DaoUsuario(conexion);

        boolean admi = false;
        if (txtNombre.getText().length() == 0 || txtDireccion.getText().length() == 0 || txtCorreo.getText().length() == 0
                || txtTelefono.getText().length() == 0 || txtPass.getText().length() == 0) {
            String mensaje = "Error, campos vacios:";

            if (comprobarTexto(txtCorreo.getText()) == false) {
                mensaje += "\n -correo ";
            }
            if (comprobarTexto(txtNombre.getText()) == false) {
                mensaje += "\n -Nombre";
            }
            if (comprobarTexto(txtDireccion.getText()) == false) {
                mensaje += "\n -Num Direccion";
            }
            if (comprobarTexto(txtPass.getText()) == false) {
                mensaje += "\n -Pass";
            }

            JOptionPane.showMessageDialog(rootPane, mensaje);
        } else {
            Comprobacion comprobacion = new Comprobacion();
            consultaBean.setCorreo(txtCorreo.getText());
            consultaBean.setNombre(txtNombre.getText());
            consultaBean.setPasswd(txtPass.getText());
            consultaBean.setDireccion(txtDireccion.getText());
            consultaBean.setTelefono(txtTelefono.getText());

            if (cmbTipo.getSelectedIndex() <= 0) {
                consultaBean.setEs_admi(true);
            } else if (cmbTipo.getSelectedIndex() == 1) {
                consultaBean.setEs_admi(false);
            }
            boolean validado = comprobacion.correo(txtCorreo.getText());
            if (validado) {
                boolean ex = daoUsuario.update(consultaBean);
                if (ex) {
			    JOptionPane.showMessageDialog(rootPane, "Se han realizado los cambios Correctamente");
			    JFrame jf
				    = new resultadoUsuario();
			    jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			    jf.setVisible(true);
			    this.dispose();
		    } else {
                    JOptionPane.showMessageDialog(rootPane, "No se han realizado los cambios Correctamente");
                }
            } else {
                txtCorreo.setText("");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
	JFrame jf =
        new resultadoUsuario();
	jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	jf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas            
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas            
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

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
            java.util.logging.Logger.getLogger(UDUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UDUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UDUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UDUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UDUser().setVisible(true);
            }
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnActualizar;
        private javax.swing.JButton btnCancelar;
        private javax.swing.JComboBox cmbTipo;
        private javax.swing.JComboBox jComboBox2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField txtCorreo;
        private javax.swing.JTextField txtDireccion;
        private javax.swing.JTextField txtNombre;
        private javax.swing.JTextField txtPass;
        private javax.swing.JTextField txtTelefono;
        // End of variables declaration//GEN-END:variables
}
