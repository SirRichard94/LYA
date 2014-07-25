/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.biblioteca;

import java.util.ArrayList;
import java.util.List;
import utez.app.daos.DaoLibro;
import utez.app.model.*;

/**
 *
 * @author ricardo
 */
class Libros {
	private BaseDatos bd;
	private DaoLibro daoLibro;
	Libros (BaseDatos bd){
		this.bd = bd;
		daoLibro = bd.getLibroDao();
	}
	
	public List<LibroBean> encontrarTitulo(String titulo){
		return daoLibro.findByTitulo(titulo);
	}
	
	public List<LibroBean> encontrarPorAutor(AutorBean autor){
		return daoLibro.findByAutor(autor);
	}
	public List<LibroBean> encontrarPorAutor(String busqueda){
		return daoLibro.findByAutorNombre(busqueda);
	}
	
	public List<LibroBean> encontrarPorEditorial(EditorialBean editorial){
		return daoLibro.findByEditorial(editorial);
	}
	public List<LibroBean> encontrarPorEditorial(String editorial){
		return daoLibro.findByEditorialNombre(editorial);
	}
	
	public List<LibroBean> obtenerLista(){
		return daoLibro.getActive();
	}
	
	public boolean agregar(LibroBean libro){
		return daoLibro.add(libro);
	}
	
	public boolean actualizar(LibroBean libro){
		return daoLibro.update(libro);
	}
	
	public boolean baja(LibroBean libroBean){
		libroBean.setAlta(false);
		return daoLibro.update(libroBean);
	}
	public LibroBean obtenerPorISBN(Long isbn){
		return daoLibro.getByIsbn(isbn);
	}
	public LibroBean obtenerPorID(int id){
		return daoLibro.get(id);
	}
}
