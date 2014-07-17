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
public class AutorBean implements Serializable{
	private int autor_id;
	private String nombre;
	private String apellido;
         boolean alta;

	public AutorBean() {
	}

	public AutorBean(int id, String nombre, String apellido, boolean alta) {
		this.autor_id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.alta = alta;
	}

	public int getAutor_id() {
		return autor_id;
	}

	public void setAutor_id(int id) {
		this.autor_id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	@Override
	public String toString() {
		return autor_id+", "
			+ nombre + " "
			+ apellido + ", "
			+ alta;
	}
	
	
	
}
