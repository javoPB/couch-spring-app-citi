package com.softtek.accimarketcoach.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpleadoDTO {
	@JsonProperty("id_empleado")
	private Integer idEmpleado;
	private String nombre;
	private String area;
	
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "EmpleadoDTO [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", area=" + area + "]";
	}
	
}
