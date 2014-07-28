/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.biblioteca;

import java.sql.Connection;
import utez.app.daos.DaoArea;
import utez.app.daos.DaoAutor;
import utez.app.daos.DaoEditorial;
import utez.app.daos.DaoEjemplar;
import utez.app.daos.DaoLibro;
import utez.app.daos.DaoPrestamo;
import utez.app.daos.DaoUsuario;

/**
 *
 * @author ricardo
 */
class BaseDatos {
	private Connection conexion;
	
	private final boolean mysql;
	private final DaoArea areaDao;
	private final DaoAutor autorDao;
	private final DaoEditorial editorialDao;
	private final DaoEjemplar ejemplarDao;
	private final DaoLibro libroDao;
	private final DaoPrestamo prestamoDao;
	private final DaoUsuario usuarioDao;
	
	public BaseDatos(boolean mysql) {
		this.mysql = mysql;
		conexion = DbConnection.getConnection(mysql);
	
		areaDao = new DaoArea(conexion);
		autorDao = new DaoAutor(conexion);
		editorialDao = new DaoEditorial(conexion);
		ejemplarDao = new DaoEjemplar(conexion);
		libroDao = new DaoLibro(conexion);
		prestamoDao = new DaoPrestamo(conexion);
		usuarioDao = new DaoUsuario(conexion);
	}
	
	public boolean isMysql(){
		return mysql;
	}

	public Connection getConexion() {
		return conexion;
	}
	
	public DaoArea getAreaDao() {
		return areaDao;
	}

	public DaoAutor getAutorDao() {
		return autorDao;
	}

	public DaoEditorial getEditorialDao() {
		return editorialDao;
	}

	public DaoEjemplar getEjemplarDao() {
		return ejemplarDao;
	}

	public DaoLibro getLibroDao() {
		return libroDao;
	}

	public DaoPrestamo getPrestamoDao() {
		return prestamoDao;
	}

	public DaoUsuario getUsuarioDao() {
		return usuarioDao;
	}
	
	protected void setConexion(Connection conexion){
		this.conexion = conexion;
	}
}
