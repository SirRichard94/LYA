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
public class AreaBean implements Serializable{
	private int area_id;
	private String nombre;
	private boolean alta;
	
	public AreaBean() {
	}

	public AreaBean(int area_id, String nombre, boolean alta) {
		this.area_id = area_id;
		this.nombre = nombre;
		this.alta = alta;
	}

	public int getArea_id() {
		return area_id;
	}

	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	@Override
	public String toString() {
		return area_id+", "+nombre+", "+alta;
	}
	
	
}
