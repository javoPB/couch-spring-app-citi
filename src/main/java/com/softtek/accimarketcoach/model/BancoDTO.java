package com.softtek.accimarketcoach.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Alias("BancoDTO")
public class BancoDTO {
	@JsonProperty("id_banco")
	private Integer idBanco;
	
	private String nombre;	
	private DetallesBancoDTO detallesBancoDTO;
		
	public Integer getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(Integer idBanco) {
		this.idBanco = idBanco;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public DetallesBancoDTO getDetallesBancoDTO() {
		return detallesBancoDTO;
	}
	public void setDetallesBancoDTO(DetallesBancoDTO detallesBancoDTO) {
		this.detallesBancoDTO = detallesBancoDTO;
	}
	
}
