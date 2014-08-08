package com.utez.app.desktop;

import Utilerias.ConexionSQLServer;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import utez.app.daos.DaoArea;
import utez.app.daos.DaoAutor;
import utez.app.daos.DaoEditorial;
import utez.app.daos.DaoLibro;
import utez.app.model.AreaBean;
import utez.app.model.AutorBean;
import utez.app.model.EditorialBean;
import utez.app.model.LibroBean;

/**
 *
 * @author Koffo
 */
public class UDLibro extends javax.swing.JFrame {

    //private List<UsuarioBean> lista;
    //private DaoUsuario daoUsuario;
    private Connection conexion;
    private LibroBean libroBean;
    private LibroBean consultaBean;
    private List<EditorialBean> listaEditorial;
    private List<AutorBean> listaAutor;
    private List<AreaBean> listaArea;
    private DaoLibro daoLibro;
    private DaoAutor daoAutor;
    private DaoEditorial daoEditorial;
    private DaoArea daoArea;

    public UDLibro() {
        try {
            conexion = ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UDLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
        daoLibro = new DaoLibro(conexion);
        daoAutor = new DaoAutor(conexion);
        daoArea = new DaoArea(conexion);
        daoEditorial = new DaoEditorial(conexion);
        listaArea = daoArea.getActive();
        for (AreaBean areaBean : listaArea) {
            modeloArea.addElement(areaBean.getNombre());
        }
        listaEditorial = daoEditorial.getActive();
        for (EditorialBean editorialBean : listaEditorial) {
            modelo.addElement(editorialBean.getNombre());
        }
        listaAutor = daoAutor.getActive();
        for (AutorBean autorBean : listaAutor) {
            modeloAutor.addElement(autorBean.getNombre());
        }

        initComponents();
        this.setLocationRelativeTo(null);

    }

    public UDLibro(LibroBean consultaBean) {
        this();
        this.consultaBean = consultaBean;
        llenarValores();
    }

    private void llenarValores() {
        modeloArea.setSelectedItem(consultaBean.getArea().getNombre());
        modelo.setSelectedItem(consultaBean.getEditorial().getNombre());
        modeloAutor.addElement(consultaBean.getAutores());
        txtNombre.setText(consultaBean.getNombre());
        txtIsbn.setText("" + consultaBean.getIsbn());
        txtPag.setText("" + consultaBean.getPaginas());

    }

    public boolean comprobarTexto(String dato) {
        boolean valido = false;
        if (dato.length() > 0) {
            valido = true;
        }

        return valido;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtIsbn = new javax.swing.JTextField();
        txtPag = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbArea = new javax.swing.JComboBox();
        cmbEditorial = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAutor = new javax.swing.JList();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Actualizar Libro"));

        jLabel1.setText("Titulo:");

        jLabel2.setText("ISBN");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        btnActualizar.setText("Actualizar");
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

        txtIsbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIsbnKeyTyped(evt);
            }
        });

        txtPag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagKeyTyped(evt);
            }
        });

        jLabel7.setText("Num. Pàginas:");

        cmbArea.setModel(modeloArea);
        cmbArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreaActionPerformed(evt);
            }
        });

        cmbEditorial.setModel(modelo);

        jLabel10.setText("Àrea:");

        jLabel8.setText("Editorial:");

        jLabel12.setText("Autor:");

        listAutor.setModel(modeloAutor);
        jScrollPane1.setViewportView(listAutor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPag, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_btnActualizarKeyPressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        DaoLibro daoLibro = new DaoLibro(conexion);
        List<AutorBean> autorBean = new ArrayList<>();
        for (int i : listAutor.getSelectedIndices()) {
            autorBean.add(listaAutor.get(i));
        }
        if (txtIsbn.getText().length() == 0 || txtNombre.getText().length() == 0
                || txtPag.getText().length() == 0) {
            String mensaje = "Error, campos vacios:";
            if (comprobarTexto(txtIsbn.getText()) == false) {
                mensaje += "\n -ISBN ";
            }
            if (comprobarTexto(txtNombre.getText()) == false) {
                mensaje += "\n -Nombre";
            }
            if (comprobarTexto(txtPag.getText()) == false) {
                mensaje += "\n -Num paginas";
            }
            JOptionPane.showMessageDialog(rootPane, mensaje);
        } else {

            EditorialBean editorialBean = listaEditorial.get(cmbEditorial.getSelectedIndex());
            AreaBean areaBean = listaArea.get(cmbArea.getSelectedIndex());
            consultaBean.setNombre(txtNombre.getText());
            consultaBean.setIsbn(Long.parseLong(txtIsbn.getText()));
            consultaBean.setPaginas(Integer.parseInt(txtPag.getText()));
            consultaBean.setArea(areaBean);
            consultaBean.setEditorial(editorialBean);
            consultaBean.setAutores(autorBean);
            
            if (consultaBean.getPaginas() < 0 || consultaBean.getPaginas() >= Integer.MAX_VALUE) {
                JOptionPane.showMessageDialog(rootPane, "Num. Paginas fuera del rango");
                return;
            }
            if ((txtIsbn.getText().length() < 10 || txtIsbn.getText().length() > 13)) {
                JOptionPane.showMessageDialog(rootPane, "ISBN incorrecto :10-13 digitos");
                return;
            }
            boolean agregado = daoLibro.update(consultaBean);
            if (agregado) {
                JOptionPane.showMessageDialog(rootPane, "Actualizacion Libro Exitosa");
                new resultadoLibro().setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(rootPane, "No se puedo Actualizar el Libro");
            }

        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        new resultadoLibro().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAreaActionPerformed

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

    private void txtIsbnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIsbnKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIsbnKeyTyped

    private void txtPagKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPagKeyTyped

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
            java.util.logging.Logger.getLogger(UDLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UDLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UDLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UDLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UDLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbArea;
    private DefaultComboBoxModel modeloArea= new DefaultComboBoxModel();
    private javax.swing.JComboBox cmbEditorial;
    private DefaultComboBoxModel modelo= new DefaultComboBoxModel();
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listAutor;
    private DefaultListModel modeloAutor = new DefaultListModel();
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPag;
    // End of variables declaration//GEN-END:variables
}
