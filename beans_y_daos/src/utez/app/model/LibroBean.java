/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ricardo
 */
public class LibroBean implements Serializable{
	int libro_id;
	long isbn;
	String nombre;
	int paginas;
	
	AreaBean area;
	EditorialBean editorial;
	
	List<AutorBean> autores;
	int ejemplares;
	
//	int area_id;
//	int editorial_id;
	
	boolean alta;
	
	public LibroBean() {
	}

	public LibroBean(int libro_id, long ISBN, String nombre, int paginas, AreaBean area, EditorialBean editorial, boolean alta) {
		this.libro_id = libro_id;
		this.isbn = ISBN;
		this.nombre = nombre;
//		this.area_id = area_id;
//		this.editorial_id = editorial_id;
		this.alta = alta;
			
		this.editorial = editorial;
		this.area = area;
		this.paginas = paginas;
	}

	public int getLibro_id() {
		return libro_id;
	}

	public void setLibro_id(int libro_id) {
		this.libro_id = libro_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	public int getArea_id() {
//		return area_id;
//	}
//
//	public void setArea_id(int area_id) {
//		this.area_id = area_id;
//	}
//
//	public int getEditorial_id() {
//		return editorial_id;
//	}
//
//	public void setEditorial_id(int editorial_id) {
//		this.editorial_id = editorial_id;
//	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}
	
	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public AreaBean getArea() {
		return area;
	}

	public void setArea(AreaBean area) {
		this.area = area;
	}

	public EditorialBean getEditorial() {
		return editorial;
	}

	public void setEditorial(EditorialBean editorial) {
		this.editorial = editorial;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public List<AutorBean> getAutores() {
		return autores;
	}

	public void setAutores(List<AutorBean> autores) {
		this.autores = autores;
	}

	public int getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	
	
	
	@Override
	public String toString() {
		return libro_id+", "
			+ isbn +", "
			+ nombre + ", " 
			+ paginas + ", " ;
	}
	
	
	
}
