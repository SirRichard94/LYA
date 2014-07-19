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
public class PenalizacionBean implements Serializable{
	private int penalizacion_id;
	private int limite_inferior;
	private int limite_superior;
	private double costo;
	
	public PenalizacionBean() {
	}

	public PenalizacionBean(int penalizacion_id, int limite_inferior, int limite_superior, double costo) {
		this.penalizacion_id = penalizacion_id;
		this.limite_inferior = limite_inferior;
		this.limite_superior = limite_superior;
		this.costo = costo;
	}

	public int getPenalizacion_id() {
		return penalizacion_id;
	}

	public void setPenalizacion_id(int penalizacion_id) {
		this.penalizacion_id = penalizacion_id;
	}

	public int getLimite_inferior() {
		return limite_inferior;
	}

	public void setLimite_inferior(int limite_inferior) {
		this.limite_inferior = limite_inferior;
	}

	public int getLimite_superior() {
		return limite_superior;
	}

	public void setLimite_superior(int limite_superior) {
		this.limite_superior = limite_superior;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	@Override
	public String toString() {
		return penalizacion_id
			+", "+ limite_inferior
			+", "+ limite_superior
			+", "+ costo
			;
	}
}
