/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.biblioteca;

import java.sql.Connection;
import java.util.List;
import utez.app.model.*;
import utez.app.daos.*;

/**
 *
 * @author ricardo
 */
public interface Biblioteca {
	
	//C
	public boolean agregarLibro(LibroBean libro);
	public boolean agregarEditorial(EditorialBean editorial);
	public boolean agregarAutor(AutorBean autor);
	public boolean agregarArea(AreaBean area);
	public boolean agregarUsuario(UsuarioBean usuario);
	//R
	public List<LibroBean> listarLibros();
	public List<EditorialBean> listarEditoriales();
	public List<AutorBean> listarAutores();
	public List<AreaBean> listarAreas();
	public List<UsuarioBean> listarUsuarios();
	
	public List<PrestamoBean> listarPrestamos(UsuarioBean usuario);
	public List<PrestamoBean> listarPrestamos();
	
	//U
	public boolean actualizarLibro(LibroBean libro);
	public boolean actualizarEditorial(EditorialBean editorial);
	public boolean actualizarAutor(AutorBean autor);
	public boolean actualizarArea(AreaBean area);
	public boolean actualizarUsuario(UsuarioBean usuario);
	
	//D
	public boolean bajaLibro(LibroBean libro);
	public boolean bajaEditorial(EditorialBean editorial);
	public boolean bajaAutor(AutorBean autor);
	public boolean bajaArea(AreaBean area);
	public boolean bajaUsuario(UsuarioBean usuario);
	
	//ejemplares
	public boolean insertarEjemplares(LibroBean libro);
	public boolean quitarEjemplares(LibroBean libro, int num);
	
	//prestamos
	public boolean hacerPrestamo(UsuarioBean usuario);
	public boolean quitarPrestamo(UsuarioBean usuario, EjemplarBean ejemplar);
	
	//usuario
	public boolean autenticar(String correo, String pass);
	public boolean pago(UsuarioBean usuario, double monto);
	
}
