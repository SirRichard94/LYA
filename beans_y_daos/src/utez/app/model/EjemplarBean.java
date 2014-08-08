/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.model;

import java.io.Serializable;

/**
 *
 * @author ricardo
 */
public class EjemplarBean implements Serializable{
	
	private int ejemplar_id;
	private String localizacion;
	private LibroBean libro;
	private boolean prestado;

	public EjemplarBean() {
	}

	public EjemplarBean(int ejemplar_id, String localizacion, LibroBean libro) {
		this.ejemplar_id = ejemplar_id;
		this.localizacion = localizacion;
		this.libro = libro;
	}

	public int getEjemplar_id() {
		return ejemplar_id;
	}

	public void setEjemplar_id(int ejemplar_id) {
		this.ejemplar_id = ejemplar_id;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public LibroBean getLibro() {
		return libro;
	}

	public void setLibro(LibroBean libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return ejemplar_id
			+", "+localizacion
			+", "+libro.getLibro_id()
			;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	
	
	
}
