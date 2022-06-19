package com.softtek.accimarketcoach.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Alias("BancoDTO")
public class BancoDTO {
	@JsonProperty("id_banco")
	private long id;
	private String nombre;
	private String email;	
	private int prioridad;
	
	public long getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPrioridad() {
		return prioridad;
	}
	public void setEmail(Integer prioridad) {
		this.prioridad = prioridad;
	}
	
}
