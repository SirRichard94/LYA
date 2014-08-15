/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.utilidades;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import utez.app.daos.*;
import utez.app.model.*;

/**
 *
 * Utilidades para la biblioteca lee y aprende
 * Abstrae algunos metodos que dependen del Gestor de BD
 * 
 * @author ricardo
 */
public class Biblioteca {
	private final boolean mysql;
	private Connection con;
	
	public Biblioteca(boolean mysql){
		this.mysql = mysql;
		con = DbConnection.getConnection(mysql);
	}
	
	/**
	 *  Actualiza las penalizacíones de Los usuarios
	 * @return 
	 */
	public void actualizarPenalizaciones(){
		for (UsuarioBean usuario : new DaoUsuario(con).getAll()) {
			actualizarPenalizaciones(usuario);
		}
		
	}
	public void actualizarPenalizaciones(UsuarioBean usuario) {
		DaoUsuario daoU = new DaoUsuario(con);
		DaoPrestamo daoP = new DaoPrestamo(con);

		usuario.setDeuda(0);
		for (PrestamoBean prestamo : daoP.findByUsuario(usuario)) {
			usuario.setDeuda(
				usuario.getDeuda()
				+ daoP.penalizacion(prestamo, mysql)
			);
		}

		daoU.update(usuario);

	}
	
	public List<LibroBean> busquedaLibroPorAutor(String busqueda) {
		List<LibroBean> lista = new ArrayList<>();
		DaoLibro daoL = new DaoLibro(con);

		List<AutorBean> autor = new DaoAutor(con).findByNombreYApellido(busqueda, mysql);

		for (AutorBean autorBean : autor) {
			for (LibroBean libro : daoL.findByAutor(autorBean)) {
				if (!lista.contains(libro)) {
					lista.add(libro);
				}
			}
		}
		return lista;
	}

	public List<LibroBean> busquedaLibroPorEditorial(String busqueda) {
		List<LibroBean> lista = new ArrayList<>();
		DaoLibro daoL = new DaoLibro(con);

		List<EditorialBean> editorial = new DaoEditorial(con).findByNombre(busqueda);

		for (EditorialBean bean : editorial) {
			for (LibroBean libro : daoL.findByEditorial(bean)) {
				if (!lista.contains(libro)) {
					lista.add(libro);
				}
			}
		}

		return lista;
	}

	public List<LibroBean> busquedaLibroPorArea(String busqueda) {
		List<LibroBean> lista = new ArrayList<>();
		DaoLibro daoL = new DaoLibro(con);
		List<AreaBean> area = new DaoArea(con).findByNombre(busqueda);

		for (AreaBean bean : area) {
			for (LibroBean libro : daoL.findByArea(bean)) {
				if (!lista.contains(libro)) {
					lista.add(libro);
				}
			}
		}
		return lista;
	}

	public Connection getConection() {
		return con;
	}
        
        
        public void enviarCorreos(){
            DaoUsuario dao = new DaoUsuario(con);
            DaoPrestamo daoPrestamo = new DaoPrestamo(con);
            for (UsuarioBean usuario : dao.getActive()){
                for(PrestamoBean prestamo : daoPrestamo.findByUsuario(usuario)){
                    
                    if (daoPrestamo.diasDeRetraso(prestamo, mysql) == -2){
                        new EnviarMail().enviar(usuario.getCorreo(), 
                                "Prestamo LYA", 
                                "El prestamo del Libro: <b>"+ prestamo.getEjemplar().getLibro().getNombre()+"</b> está proximo a vencerse"
                                        + "<br> Recuerde debera entregarse el día: <b>"+prestamo.getFecha_entrega()+"</b>"
                                        + "<br> Gracias por su atencion, Biblioteca Lee y Aprende.");
                    }
                    
                }
            }
        }
}
