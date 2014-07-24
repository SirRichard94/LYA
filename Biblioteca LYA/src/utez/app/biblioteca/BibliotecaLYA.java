/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.biblioteca;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import utez.app.daos.*;
import utez.app.model.*;


/**
 *
 * @author ricardo
 */
public class BibliotecaLYA implements Biblioteca{
	private Connection conexion;
	private final boolean mysql;
	
	private static final int MAX_PRESTAMOS = 3;
	private static final int MIN_EJEMPLARES_LIBRO = 4;
	
	private final DaoArea areaDao;
	private final DaoAutor autorDao;
	private final DaoEditorial editorialDao;
	private final DaoEjemplar ejemplarDao;
	private final DaoLibro libroDao;
	private final DaoPrestamo prestamoDao;
	private final DaoUsuario usuarioDao;
	
	public BibliotecaLYA(boolean mysql) {
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
	
	public Connection getConnection(){
		return conexion;
	}
	
	@Override
	public boolean agregarLibro(LibroBean libro) {
		return libroDao.add(libro);
	}

	@Override
	public boolean agregarEditorial(EditorialBean editorial) {
		return editorialDao.add(editorial);
	}

	@Override
	public boolean agregarAutor(AutorBean autor) {
		return autorDao.add(autor);
	}

	@Override
	public boolean agregarArea(AreaBean area) {
		return areaDao.add(area);
	}

	@Override
	public boolean agregarUsuario(UsuarioBean usuario) {
		return usuarioDao.add(usuario);
	}

	@Override
	public List<LibroBean> listarLibros() {
		return libroDao.getActive();
	}

	@Override
	public List<EditorialBean> listarEditoriales() {
		return libroDao.getActive();
	}

	@Override
	public List<AutorBean> listarAutores() {
		return autorDao.getActive();
	}

	@Override
	public List<AreaBean> listarAreas() {
		return areaDao.getActive();
	}

	@Override
	public List<UsuarioBean> listarUsuarios() {
		return usuarioDao.getActive();
	}

	@Override
	public List<PrestamoBean> listarPrestamos(UsuarioBean usuario) {
		return prestamoDao.findByUsuario(usuario);
	}

	@Override
	public List<PrestamoBean> listarPrestamos() {
		return prestamoDao.getAll();
	}

	@Override
	public boolean actualizarLibro(LibroBean libro) {
		return libroDao.update(libro);
	}

	@Override
	public boolean actualizarEditorial(EditorialBean editorial) {
		return editorialDao.update(editorial);
	}

	@Override
	public boolean actualizarAutor(AutorBean autor) {
		return autorDao.update(autor);
	}

	@Override
	public boolean actualizarArea(AreaBean area) {
		return areaDao.update(area);
	}

	@Override
	public boolean actualizarUsuario(UsuarioBean usuario) {
		return usuarioDao.update(usuario);
	}
	
	@Override
	public boolean bajaLibro(LibroBean libro) {
		libro.setAlta(false);
		return libroDao.update(libro);
	}

	@Override
	public boolean bajaEditorial(EditorialBean editorial) {
		editorial.setAlta(false);
		return editorialDao.update(editorial);
	}

	@Override
	public boolean bajaAutor(AutorBean autor) {
		autor.setAlta(false);
		return autorDao.update(autor);
	}

	@Override
	public boolean bajaArea(AreaBean area) {
		area.setAlta(false);
		return areaDao.update(area);
	}

	@Override
	public boolean bajaUsuario(UsuarioBean usuario) {
		usuario.setAlta(false);
		return usuarioDao.update(usuario);
	}

	@Override
	public boolean insertarEjemplar(EjemplarBean ejemplar) {
		return ejemplarDao.add(ejemplar);
	}


	@Override
	public boolean hacerPrestamo(UsuarioBean usuario, LibroBean libro) {
		if (usuarioDao.countPrestamos(usuario) >= MAX_PRESTAMOS
			|| usuario.getDeuda() > 0
			|| libroDao.countEjemplaresDisponibles(libro) <= MIN_EJEMPLARES_LIBRO){
			return false;
		}
		PrestamoBean prestamo = new PrestamoBean();
		prestamo.setEjemplar(ejemplarDao.getDisponibleByLibro(libro));
		prestamo.setUsuario(usuario);
		return prestamoDao.add(prestamo);
	}

	@Override
	public boolean quitarPrestamo(UsuarioBean usuario, PrestamoBean prestamo) {
		if (usuario.getDeuda() == 0){
			return prestamoDao.delete(prestamo);
		}
		else return false;
	}

	@Override
	public boolean autenticar(String correo, String pass) {
		return usuarioDao.autenticar(correo, pass);
	}

	@Override
	public boolean pago(UsuarioBean usuario, double monto) {
		double deuda = usuario.getDeuda() - monto;;
		deuda = deuda < 0? 0 : deuda;
		usuario.setDeuda(deuda);
		
		return usuarioDao.update(usuario);
	}

	@Override
	public boolean quitarEjemplar(LibroBean libro) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
