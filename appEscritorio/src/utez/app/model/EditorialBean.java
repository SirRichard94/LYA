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
public class EditorialBean implements Serializable {
	private int editorial_id;
	private String nombre;
	private String direccion;
	private boolean alta;

	public EditorialBean() {
	}

	public EditorialBean(int id, String nombre, String direccion, boolean alta) {
		this.editorial_id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.alta = alta;
	}

	public int getEditorial_id() {
		return editorial_id;
	}

	public void setEditorial_id(int id) {
		this.editorial_id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	@Override
	public String toString() {
		return editorial_id +", "
			+nombre +", "
			+direccion +", "
			+alta;
	}
	
	
}
