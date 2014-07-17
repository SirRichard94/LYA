/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author ricardo
 */
public class PrestamoBean implements Serializable{
	
	int prestamo_id;
	UsuarioBean usuario;
	EjemplarBean ejemplar;
	Date fecha_salida;
	Date fecha_entrega;

	public PrestamoBean() {
	}

	public PrestamoBean(int prestamo_id, UsuarioBean usuario, EjemplarBean ejemplar, Date fecha_salida, Date fecha_entrega) {
		this.prestamo_id = prestamo_id;
		this.usuario = usuario;
		this.ejemplar = ejemplar;
		this.fecha_salida = fecha_salida;
		this.fecha_entrega = fecha_entrega;

	}

	

	public int getPrestamo_id() {
		return prestamo_id;
	}

	public void setPrestamo_id(int prestamo_id) {
		this.prestamo_id = prestamo_id;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public EjemplarBean getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(EjemplarBean ejemplar) {
		this.ejemplar = ejemplar;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	
	@Override
	public String toString() {
		return prestamo_id
			+", "+ usuario.getUsuario_id()
			+", "+ ejemplar.getEjemplar_id()
			+", "+ fecha_salida
			+", "+ fecha_entrega
			;
	}
	
}
