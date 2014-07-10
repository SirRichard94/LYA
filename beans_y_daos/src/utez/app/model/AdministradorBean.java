package utez.app.model;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricardo
 */
public class AdministradorBean implements Serializable{
	private int administrador_id;
	private String nombre ;
	private String correo ;
	private String passwd ;
	private boolean alta ;

	public AdministradorBean() {
	}

	public AdministradorBean(int administrador_id, String nombre, String correo, String passwd, boolean alta) {
		this.administrador_id = administrador_id;
		this.nombre = nombre;
		this.correo = correo;
		this.passwd = passwd;
		this.alta = alta;
	}

	public int getAdministrador_id() {
		return administrador_id;
	}

	public void setAdministrador_id(int administrador_id) {
		this.administrador_id = administrador_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	@Override
	public String toString() {
		return administrador_id
			+", "+ nombre
			+", "+ correo
			+", "+ passwd
			+", "+ alta
			;
	}
}
