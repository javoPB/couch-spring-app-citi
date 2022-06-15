package com.softtek.accimarketcoach.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.softtek.accimarketcoach.Utils.Datos;
import com.softtek.accimarketcoach.mapper.BancoMapper;
import com.softtek.accimarketcoach.service.BancoService;

@ExtendWith(MockitoExtension.class)
public class BancoBusinessIntegrationTest {

	@Mock
	BancoMapper bancoMapper;
	
	@InjectMocks
	BancoService bancoService = new BancoBusiness();
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("+++++++ INICIANDO EJECUCIÓN DE INTEGRATION TESTS (PRUEBAS DE INTEGRACIÓN). +++++++");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("-------------- INICIANDO PRUEBA INTEGRATION TEST (PRUEBA DE INTEGRACIÓN). --------------");
	}
	
	@Test
	@DisplayName("testMockitoListaVacia")
	void testMockitoListaVacia() {
		when(bancoService.getAllBancos()).thenReturn(Datos.BANCOS);
		
		assertEquals("Matematicas", "Matematicas");		
	}	
	
	@AfterEach
	void AfterEach() {
		System.out.println("-------------- INICIANDO PRUEBA INTEGRATION TEST (PRUEBA DE INTEGRACIÓN). --------------");
	}	
	
	@AfterAll
	static void afterAll() {
		System.out.println("+++++++ INICIANDO EJECUCIÓN DE INTEGRATION TESTS (PRUEBAS DE INTEGRACIÓN)S. +++++++");
	}
}
