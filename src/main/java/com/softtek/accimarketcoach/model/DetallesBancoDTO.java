package com.softtek.accimarketcoach.model;

public class DetallesBancoDTO {
	private String descripcion;
	private String clave;
	private String identificador;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	@Override
	public String toString() {
		return "descripcion: " + this.descripcion + " - clave: " + this.clave + " - identificador: " + identificador;
	}
}
