/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utez.app.desktop;

import static com.utez.app.desktop.Constants.MYSQL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utez.app.daos.DaoEjemplar;
import utez.app.daos.DaoLibro;
import utez.app.model.EjemplarBean;
import utez.app.model.LibroBean;
import utez.app.utilidades.Biblioteca;

/**
 *
 * @author ricardo
 */
public class Ejemplares extends javax.swing.JFrame {

	/**
	 * Creates new form Ejemplares
	 */
	private Connection conexion;
	private List<LibroBean> listaLibros;
	private List<EjemplarBean> listaEjemplares;
	private DaoEjemplar daoEjemplar;
	
	
	public Ejemplares() {
		conexion = new Biblioteca(MYSQL).getConection();
		daoEjemplar= new DaoEjemplar(conexion);
		
       DaoLibro daoLibro=new DaoLibro(conexion);
        listaLibros=daoLibro.getActive();
        for (LibroBean beanLib : listaLibros) {
            modeloLibro.addElement(beanLib.getNombre());
        }
        
        initComponents();
	actualizarTabla();
                this.setLocationRelativeTo(null);
	}
	
	private void actualizarTabla(){
	LibroBean libro = listaLibros.get(cmbLibros.getSelectedIndex());
	listaEjemplares =daoEjemplar.findByLibro(libro);
        actualizarTabla(listaEjemplares);
    }
	
    private void actualizarTabla(List<EjemplarBean> lista){
        modeloTabla = new DefaultTableModel (new String[]{"id ejemplar","Localizacion","prestado"},0){
            Class[] types = {Integer.class, String.class, Object.class};
            
            @Override
            public Class getColumnClass(int index){
                return this.types[index];
            }
            public boolean isCellEditable(int index){
                return false;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
             for (EjemplarBean bean : lista) {
                 
                    
                    Object[] arreglo                           
                            = {bean.getEjemplar_id(), bean.getLocalizacion(), 
				    daoEjemplar.prestado(bean.getEjemplar_id()) ? "si": "no"};
                 
                 modeloTabla.addRow(arreglo);
        }
        try{tblEjemplares.setModel(modeloTabla);}catch(NullPointerException e){}
	}
	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                cmbLibros = new javax.swing.JComboBox();
                jScrollPane1 = new javax.swing.JScrollPane();
                tblEjemplares = new javax.swing.JTable();
                btnEliminar = new javax.swing.JButton();
                jButton2 = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
                jLabel1.setText("Inventario");

                cmbLibros.setModel(modeloLibro
                );
                cmbLibros.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cmbLibrosActionPerformed(evt);
                        }
                });

                tblEjemplares.setModel(modeloTabla);
                jScrollPane1.setViewportView(tblEjemplares);

                btnEliminar.setText("Eliminar");
                btnEliminar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEliminarActionPerformed(evt);
                        }
                });

                jButton2.setText("Nuevo");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cmbLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 136, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnEliminar)))
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmbLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar))
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

        private void cmbLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLibrosActionPerformed
             actualizarTabla();
        }//GEN-LAST:event_cmbLibrosActionPerformed

        private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
                // TODO add your handling code here:
		int id = (Integer) tblEjemplares.getValueAt(tblEjemplares.getSelectedRow(), 0);
		
		if (JOptionPane.showConfirmDialog(this, "Desea eliminar el ejemplar? ") == JOptionPane.OK_OPTION){
		
		if(!daoEjemplar.delete(daoEjemplar.get(id))){
			JOptionPane.showMessageDialog(this, "Problema al eliminar");
		}
		}
		actualizarTabla();
        }//GEN-LAST:event_btnEliminarActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                // TODO add your handling code here:
		LibroBean libro = listaLibros.get(cmbLibros.getSelectedIndex());
		JFrame jf = new CEjemplar(libro);
		jf.setVisible(true);
        }//GEN-LAST:event_jButton2ActionPerformed

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
			java.util.logging.Logger.getLogger(Ejemplares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Ejemplares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Ejemplares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Ejemplares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Ejemplares().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnEliminar;
        private javax.swing.JComboBox cmbLibros;
        DefaultComboBoxModel<Object> modeloLibro= new DefaultComboBoxModel<Object>();
        private javax.swing.JButton jButton2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable tblEjemplares;
        DefaultTableModel modeloTabla = new DefaultTableModel();
        // End of variables declaration//GEN-END:variables
}
