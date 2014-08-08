/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utez.app.desktop;

import Utilerias.ConexionSQLServer;
import com.utez.app.desktop.controlador.ControlSesion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import utez.app.daos.DaoUsuario;
import utez.app.model.UsuarioBean;

/**
 *
 * @author Koffo
 */
public class AdminData extends javax.swing.JFrame {
 private Connection connection;
 private DaoUsuario daoUsuario;
 private ControlSesion sesion;
 
    /**
     * Creates new form AdminData
     */
    public AdminData() {
     try {
         connection=ConexionSQLServer.getConnection();
         initComponents();
         this.setLocationRelativeTo(null);
     } catch (SQLException ex) {
         Logger.getLogger(AdminData.class.getName()).log(Level.SEVERE, null, ex);
     }
      this.setLocationRelativeTo(null);
     sesion = ControlSesion.getInstance();
     if(!sesion.isAdmin()){
         //cerrar ventana
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

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        btnAgregarUsuario = new javax.swing.JMenuItem();
        btnCosultarUsuario = new javax.swing.JMenuItem();
        btnModificarUsuario = new javax.swing.JMenuItem();
        btnDeleteUsuario = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        btnAgregarAutor = new javax.swing.JMenuItem();
        btnConsultarAutor = new javax.swing.JMenuItem();
        btnModificarAutor = new javax.swing.JMenuItem();
        btnBorrarAutor = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        btnAgregarLibro = new javax.swing.JMenuItem();
        btnConsultarLibro = new javax.swing.JMenuItem();
        btnModificarLibro = new javax.swing.JMenuItem();
        btnEliminarLibro = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        btnAgregarEditorial = new javax.swing.JMenuItem();
        btnConsultarrEditorial = new javax.swing.JMenuItem();
        btnModificarEditorial = new javax.swing.JMenuItem();
        btnEliminarEditorial = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        btnAgregarArea = new javax.swing.JMenuItem();
        btnConsultarArea = new javax.swing.JMenuItem();
        btnModificarArea = new javax.swing.JMenuItem();
        btnEliminarArea = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        btnPrestamo = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenu4.setText("File");
        jMenuBar3.add(jMenu4);

        jMenu10.setText("Edit");
        jMenuBar3.add(jMenu10);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LyA");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jLabel4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel4KeyPressed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cerrar Sesiòn");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jLabel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel5KeyPressed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jLabel6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel6KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(481, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel1.setText("Administraciòn De");

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel2.setText("Datos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jMenuItem9.setText("Agregar");
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Consultar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setText("Actualizar");
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Eliminar");
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Usuario");

        btnAgregarUsuario.setText("Agregar");
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });
        jMenu5.add(btnAgregarUsuario);

        btnCosultarUsuario.setText("Consultar");
        btnCosultarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCosultarUsuarioActionPerformed(evt);
            }
        });
        jMenu5.add(btnCosultarUsuario);

        btnModificarUsuario.setText("Modificar");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });
        jMenu5.add(btnModificarUsuario);

        btnDeleteUsuario.setText("Eliminar");
        btnDeleteUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUsuarioActionPerformed(evt);
            }
        });
        jMenu5.add(btnDeleteUsuario);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Autor");

        btnAgregarAutor.setText("Agregar");
        btnAgregarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAutorActionPerformed(evt);
            }
        });
        jMenu6.add(btnAgregarAutor);

        btnConsultarAutor.setText("Consultar");
        btnConsultarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarAutorActionPerformed(evt);
            }
        });
        jMenu6.add(btnConsultarAutor);

        btnModificarAutor.setText("Modificar");
        btnModificarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAutorActionPerformed(evt);
            }
        });
        jMenu6.add(btnModificarAutor);

        btnBorrarAutor.setText("Eliminar");
        btnBorrarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarAutorActionPerformed(evt);
            }
        });
        jMenu6.add(btnBorrarAutor);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Libro");

        btnAgregarLibro.setText("Agregar");
        btnAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLibroActionPerformed(evt);
            }
        });
        jMenu7.add(btnAgregarLibro);

        btnConsultarLibro.setText("Consultar");
        btnConsultarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarLibroActionPerformed(evt);
            }
        });
        jMenu7.add(btnConsultarLibro);

        btnModificarLibro.setText("Modificar");
        btnModificarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarLibroActionPerformed(evt);
            }
        });
        jMenu7.add(btnModificarLibro);

        btnEliminarLibro.setText("Eliminar");
        btnEliminarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLibroActionPerformed(evt);
            }
        });
        jMenu7.add(btnEliminarLibro);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Editorial");

        btnAgregarEditorial.setText("Agregar");
        btnAgregarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEditorialActionPerformed(evt);
            }
        });
        jMenu8.add(btnAgregarEditorial);

        btnConsultarrEditorial.setText("Consultar");
        btnConsultarrEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarrEditorialActionPerformed(evt);
            }
        });
        jMenu8.add(btnConsultarrEditorial);

        btnModificarEditorial.setText("Modificar");
        btnModificarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEditorialActionPerformed(evt);
            }
        });
        jMenu8.add(btnModificarEditorial);

        btnEliminarEditorial.setText("Eliminar");
        btnEliminarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEditorialActionPerformed(evt);
            }
        });
        jMenu8.add(btnEliminarEditorial);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("Área");

        btnAgregarArea.setText("Agregar");
        btnAgregarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAreaActionPerformed(evt);
            }
        });
        jMenu9.add(btnAgregarArea);

        btnConsultarArea.setText("Consultar");
        btnConsultarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarAreaActionPerformed(evt);
            }
        });
        jMenu9.add(btnConsultarArea);

        btnModificarArea.setText("Modificar");
        btnModificarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAreaActionPerformed(evt);
            }
        });
        jMenu9.add(btnModificarArea);

        btnEliminarArea.setText("Eliminar");
        btnEliminarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAreaActionPerformed(evt);
            }
        });
        jMenu9.add(btnEliminarArea);

        jMenuBar1.add(jMenu9);

        jMenu11.setText("Prestamo");

        btnPrestamo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Koffo\\Documents\\GitHub\\LYA\\appEscritorio\\circular icons\\cog.png")); // NOI18N
        btnPrestamo.setText("Prestamo Libro");
        btnPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamoActionPerformed(evt);
            }
        });
        jMenu11.add(btnPrestamo);

        jMenuBar1.add(jMenu11);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(309, 309, 309))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        new Bienvenida().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel5KeyPressed
        // TODO add your handling code here:
        new Bienvenida().setVisible(true);
    }//GEN-LAST:event_jLabel5KeyPressed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        // TODO add your handling code here:
        new CUser().setVisible(true);
        
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    private void btnAgregarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAutorActionPerformed
        // TODO add your handling code here:
        new CAutor().setVisible(true);
        
    }//GEN-LAST:event_btnAgregarAutorActionPerformed

    private void btnAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLibroActionPerformed
        // TODO add your handling code here:
        new CLibro().setVisible(true);
       
    }//GEN-LAST:event_btnAgregarLibroActionPerformed

    private void btnAgregarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEditorialActionPerformed
        // TODO add your handling code here:
        new CEditorial().setVisible(true);
        
    }//GEN-LAST:event_btnAgregarEditorialActionPerformed

    private void btnAgregarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAreaActionPerformed
        // TODO add your handling code here:
        new CArea().setVisible(true);
       
    }//GEN-LAST:event_btnAgregarAreaActionPerformed

    private void btnCosultarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCosultarUsuarioActionPerformed
        // TODO add your handling code here:
        new resultadoUsuario().setVisible(true);
        
    }//GEN-LAST:event_btnCosultarUsuarioActionPerformed

    private void btnConsultarrEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarrEditorialActionPerformed
        // TODO add your handling code here:
        new resultadoEditorial().setVisible(true);
        
    }//GEN-LAST:event_btnConsultarrEditorialActionPerformed

    private void btnConsultarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarAreaActionPerformed
        // TODO add your handling code here:
        new resultadoArea().setVisible(true);
        
    }//GEN-LAST:event_btnConsultarAreaActionPerformed

    private void btnConsultarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarLibroActionPerformed
        // TODO add your handling code here:
        new resultadoLibro().setVisible(true);
       
    }//GEN-LAST:event_btnConsultarLibroActionPerformed

    private void btnModificarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEditorialActionPerformed
        // TODO add your handling code here:
        new resultadoEditorial().setVisible(true);
        
    }//GEN-LAST:event_btnModificarEditorialActionPerformed

    private void btnConsultarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarAutorActionPerformed
        // TODO add your handling code here:
        new resultadoAutor().setVisible(true);
        
    }//GEN-LAST:event_btnConsultarAutorActionPerformed

    private void btnModificarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAreaActionPerformed
        // TODO add your handling code here:
        new resultadoArea().setVisible(true);
        
    }//GEN-LAST:event_btnModificarAreaActionPerformed

    private void btnEliminarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAreaActionPerformed
        // TODO add your handling code here:
        new resultadoArea().setVisible(true);
        
    }//GEN-LAST:event_btnEliminarAreaActionPerformed

    private void btnEliminarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEditorialActionPerformed
        // TODO add your handling code here:
        new resultadoEditorial().setVisible(true);
        
    }//GEN-LAST:event_btnEliminarEditorialActionPerformed

    private void btnModificarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarLibroActionPerformed
        // TODO add your handling code here:
        new resultadoLibro().setVisible(true);
        
    }//GEN-LAST:event_btnModificarLibroActionPerformed

    private void btnEliminarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLibroActionPerformed
        // TODO add your handling code here:
         new resultadoLibro().setVisible(true);
        
    }//GEN-LAST:event_btnEliminarLibroActionPerformed

    private void btnModificarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAutorActionPerformed
        // TODO add your handling code here:
        new resultadoAutor().setVisible(true);
       
    }//GEN-LAST:event_btnModificarAutorActionPerformed

    private void btnBorrarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAutorActionPerformed
        // TODO add your handling code here:
        new resultadoAutor().setVisible(true);
        
    }//GEN-LAST:event_btnBorrarAutorActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        // TODO add your handling code here:
        new resultadoUsuario().setVisible(true);
        
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void btnDeleteUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUsuarioActionPerformed
        // TODO add your handling code here:
        new resultadoUsuario().setVisible(true);
        
    }//GEN-LAST:event_btnDeleteUsuarioActionPerformed

    private void jLabel4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel4KeyPressed
        // TODO add your handling code here:
        new Bienvenida().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4KeyPressed

    private void btnPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamoActionPerformed
        // TODO add your handling code here:
        new Prestamo().setVisible(true);
        
    }//GEN-LAST:event_btnPrestamoActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6KeyPressed

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
            java.util.logging.Logger.getLogger(AdminData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAgregarArea;
    private javax.swing.JMenuItem btnAgregarAutor;
    private javax.swing.JMenuItem btnAgregarEditorial;
    private javax.swing.JMenuItem btnAgregarLibro;
    private javax.swing.JMenuItem btnAgregarUsuario;
    private javax.swing.JMenuItem btnBorrarAutor;
    private javax.swing.JMenuItem btnConsultarArea;
    private javax.swing.JMenuItem btnConsultarAutor;
    private javax.swing.JMenuItem btnConsultarLibro;
    private javax.swing.JMenuItem btnConsultarrEditorial;
    private javax.swing.JMenuItem btnCosultarUsuario;
    private javax.swing.JMenuItem btnDeleteUsuario;
    private javax.swing.JMenuItem btnEliminarArea;
    private javax.swing.JMenuItem btnEliminarEditorial;
    private javax.swing.JMenuItem btnEliminarLibro;
    private javax.swing.JMenuItem btnModificarArea;
    private javax.swing.JMenuItem btnModificarAutor;
    private javax.swing.JMenuItem btnModificarEditorial;
    private javax.swing.JMenuItem btnModificarLibro;
    private javax.swing.JMenuItem btnModificarUsuario;
    private javax.swing.JMenuItem btnPrestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
