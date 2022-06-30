package com.softtek.accimarketcoach.model;

public class DetallesEmpleadoDTO {
	private String edad;
	private String genero;
	private String domicilio;
	
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	@Override
	public String toString() {
		return "DetallesEmpleadoDTO [edad=" + edad + ", genero=" + genero + ", domicilio=" + domicilio + "]";
	}
}
