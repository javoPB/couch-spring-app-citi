package com.softtek.accimarketcoach.service;

import java.util.List;
import java.util.Optional;

import com.softtek.accimarketcoach.model.BancoDTO;

/**
 * El objetivo de una interfaz es declarar una serie de métodos sin su implementación.
 * Mediante una interfaz indicamos que debe hacerse pero no como se debe implementar.
 * Para el control de seguridad, encapsulamiento, herencia, polimorfismo 
 * 
 * @author javier.perezb
 *
 */
public interface BancoService {
	List<BancoDTO> getAllBancos();
	BancoDTO getOneBanco(int id);
	String insertBanco(BancoDTO banco);
	String updateBanco(BancoDTO banco);
	String deleteBanco(int id);
	
	double suma(double valor1, double valor2);
}
