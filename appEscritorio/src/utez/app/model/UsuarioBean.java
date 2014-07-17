/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.model;

/**
 *
 * @author ricardo
 */
public class UsuarioBean {
	
	private int usuario_id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	private double deuda;
	private String passwd;
	private boolean alta;
	private boolean es_admi;

	public UsuarioBean() {
	}

	public UsuarioBean(int usuario_id, String nombre, String direccion, String telefono, String correo, double deuda, String passwd, boolean alta, boolean es_admi) {
		this.usuario_id = usuario_id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.deuda = deuda;
		this.passwd = passwd;
		this.alta = alta;
		
		this.es_admi = es_admi;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
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

	public boolean isEs_admi() {
		return es_admi;
	}

	public void setEs_admi(boolean es_admin) {
		this.es_admi = es_admin;
	}

	
	
	@Override
	public String toString() {
		return usuario_id
			+", "+ nombre
			+", "+ correo
			+", "+ passwd
			+", "+ telefono
			+", "+ direccion
			+", "+ alta
			+", "+ es_admi
			;
	}
	
}
