/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.app.desktop;

import Utilerias.ConexionSQLServer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utez.app.daos.DaoLibro;
import utez.app.daos.DaoPrestamo;
import utez.app.daos.DaoUsuario;
import utez.app.model.LibroBean;
import utez.app.model.PrestamoBean;
import utez.app.model.UsuarioBean;
import static com.utez.app.desktop.Constants.*;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import utez.app.utilidades.Biblioteca;

/**
 *
 * @author Koffo
 */
public class Prestamo extends javax.swing.JFrame {

    private List<LibroBean> libroBeans;
    private List<UsuarioBean> usuarioBeans;
    private List<PrestamoBean> prestamoBeans;
    private Connection conexion;
    private DefaultTableModel tablaPrestamo;

    public Prestamo() {
        conexion = new Biblioteca(MYSQL).getConection();

        DaoPrestamo daoPrestamo = new DaoPrestamo(conexion);
        DaoLibro daoLibro = new DaoLibro(conexion);
        DaoUsuario daoUsuario = new DaoUsuario(conexion);

        libroBeans = daoLibro.getActive();
        for (LibroBean beanLib : libroBeans) {
            modeloLibro.addElement(beanLib.getNombre());
        }
        usuarioBeans = daoUsuario.getActive();
        for (UsuarioBean beanUser : usuarioBeans) {
            modeloUsuario.addElement(beanUser.getNombre());
        }

        actualizarTabla();
        initComponents();

    }

    private void actualizarTabla() {
        tablaPrestamo = new DefaultTableModel(new String[]{"Usuario", "Ejemplar_id", "Libro", "Fecha Salida", "Fecha Entrega"}, 0);
        prestamoBeans = new DaoPrestamo(conexion).getAll();
        for (PrestamoBean bean : prestamoBeans) {
            Object arre[]
                    = {bean.getUsuario().getNombre(), bean.getEjemplar().getEjemplar_id(), bean.getEjemplar().getLibro().getNombre(), bean.getFecha_salida(), bean.getFecha_entrega()};
            tablaPrestamo.addRow(arre);
        }
        try {
            tblPrestmos.setModel(tablaPrestamo);

        } catch (NullPointerException e) {
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbUsuario = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbLibro = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrestmos = new javax.swing.JTable();
        btnCrear = new javax.swing.JButton();
        btnEntregado = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario");

        cmbUsuario.setModel(modeloUsuario);

        jLabel2.setText("Libro");

        cmbLibro.setModel(modeloLibro);
        cmbLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLibroActionPerformed(evt);
            }
        });

        tblPrestmos.setModel(tablaPrestamo);
        jScrollPane1.setViewportView(tblPrestmos);

        btnCrear.setText("Nuevo Prestamo");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnEntregado.setText("Entregado");
        btnEntregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbUsuario, 0, 197, Short.MAX_VALUE)
                            .addComponent(cmbLibro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrear)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEntregado)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEntregado)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLibroActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        //nuevo prestamo
        LibroBean libro = libroBeans.get(modeloLibro.getIndexOf( modeloLibro.getSelectedItem()));
        UsuarioBean usuario = usuarioBeans.get(modeloUsuario.getIndexOf(modeloUsuario.getSelectedItem()));

        if (usuario.getDeuda() > 0) {
            JOptionPane.showMessageDialog(rootPane, "No se pudo crear prestamo"
                    + "\n El Usuario Tiene Penalizacion");
            return;
        }
        if (new DaoUsuario(conexion).countPrestamos(usuario) >= 3) {
            JOptionPane.showMessageDialog(rootPane, "No se pudo crear prestamo"
                    + "\n El usuario ya tiene 3 prestamos");
            return;
        }
        if (new DaoLibro(conexion).countEjemplaresDisponibles(libro) <= 3) {
            JOptionPane.showMessageDialog(rootPane, "No se pudo crear prestamo"
                    + "\n No hay suficientes ejemplares disponibles");
            return;
        }

        if (new DaoPrestamo(conexion).nuevoPrestamo(usuario, libro, 3, MYSQL)) {
            //creado

            JOptionPane.showMessageDialog(rootPane, "Prestamo Agregado");

        } else {
            //no creado
            JOptionPane.showMessageDialog(rootPane, "Error al Agregar prestamo");
        }

        actualizarTabla();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEntregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregadoActionPerformed
        // TODO add your handling code here:
        PrestamoBean prestamo = prestamoBeans.get(
                tblPrestmos.getSelectedRow());
        DaoPrestamo daoPrestamo = new DaoPrestamo(conexion);

        if (daoPrestamo.penalizacion(prestamo, MYSQL) > 0) {

            JFrame jf = new Entrega(prestamo);
            jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jf.setVisible(true);
            this.dispose();

        } else {
            daoPrestamo.delete(prestamo);
        }
        actualizarTabla();
    }//GEN-LAST:event_btnEntregadoActionPerformed

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
            java.util.logging.Logger.getLogger(Prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEntregado;
    private javax.swing.JComboBox cmbLibro;
    private DefaultComboBoxModel modeloLibro =new DefaultComboBoxModel();
    private javax.swing.JComboBox cmbUsuario;
    private DefaultComboBoxModel modeloUsuario=new DefaultComboBoxModel();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrestmos;
    // End of variables declaration//GEN-END:variables
}
