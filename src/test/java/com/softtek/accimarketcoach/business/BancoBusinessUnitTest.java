package com.softtek.accimarketcoach.business;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.softtek.accimarketcoach.model.BancoDTO;
import com.softtek.accimarketcoach.model.DetallesBancoDTO;

public class BancoBusinessUnitTest {
/**/
	private BancoBusiness bancoBusiness = null;
	private BancoDTO bancoDTO = null; 
	
	@BeforeAll
	static void initForAll() {
		System.out.println("+++++++ INICIANDO EJECUCIÓN DE PRUEBAS UNITARIAS (UNIT TESTS). +++++++");
	}
	
	@BeforeEach
	@DisplayName("beforeEachTest")
	void beforeEachTest() {
		System.out.println("-------------- INICIANDO PRUEBA UNITARIA (UNIT TEST). --------------");
		
		this.bancoBusiness = new BancoBusiness();
		this.bancoDTO = new BancoDTO();
	}
	
	@Test
	@DisplayName("Pruebas Unitarias - Método Suma()")
	public void testSuma() {
		System.out.println("\t\t\t testSuma()");
		double suma = this.bancoBusiness.suma(1.0, 2.0);
		double resultadoEsperado = 3.0;
		
		//Valida si resultadoEsperado = resultado obtenido.
		Assertions.assertEquals(resultadoEsperado, suma);
		
		//Valida si resultadoEsperado != resultado obtenido
		//Assertions.assertNotEquals(resultadoEsperado, suma);
		
		//Valida si se genera una NumberFormatException.
		Assertions.assertThrows(NumberFormatException.class, () -> {Integer.parseInt("abc");});
		
	}
	
	@Test
	@DisplayName("Pruebas Unitarias - BancoDTO")
	void testBancoDTO() {
		System.out.println("\t\t\t testBancoDTO()");
		
		this.bancoDTO.setIdBanco(null);
		this.bancoDTO.setNombre(null);
		this.bancoDTO.setDetallesBancoDTO((new DetallesBancoDTO()));
		
		//Valida si la validación realizada es es verdadera.
		Assertions.assertTrue(this.bancoDTO.getNombre() == null);
		
		
		//Valida si se presenta un NullPointerException
		Assertions.assertThrows(NullPointerException.class, () -> {this.bancoDTO.getIdBanco().intValue();});
		
		//Valida si no se presenta un NullPointerException
		Assertions.assertDoesNotThrow(() -> {this.bancoDTO.getDetallesBancoDTO().getDescripcion();});
		
		//Assertions.assertFalse(true, "El boolean no es false");
		Assertions.assertTrue(true, "El boolean si es true");
		
		//Assertions.assertNull(this.bancoDTO, "El objeto no es nulo");
		Assertions.assertNull(null);
	}
	
	@AfterEach
	void afterEachTest() {
		System.out.println("-------------- FINALIZANDO PRUEBA UNITARIA (UNIT TEST). --------------");
	}
	
	@AfterAll
	static void finishForAll() {
		System.out.println("+++++++ FINALIZANDO EJECUCIÓN DE PRUEBAS UNITARIAS (UNIT TESTS). +++++++");
	}	
/**/
}
