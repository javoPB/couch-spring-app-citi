package com.softtek.accimarketcoach.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import static org.mockito.Mockito.*;


import com.softtek.accimarketcoach.mapper.BancoMapper;
import com.softtek.accimarketcoach.model.BancoDTO;
import com.softtek.accimarketcoach.service.BancoService;

//@ExtendWith(MockitoExtension.class)
public class BancoBusinessIntegrationTest {

	//Se realiza mock de nuestro repository (En este caso los Mapper por trabajar con MyBatis)
	@Mock
	BancoMapper bancoMapper;
	
	//Se solicita instancia de nuestro service
	@InjectMocks
	BancoBusiness bancoService;
	//BancoService bancoService;
	
	private List<BancoDTO> BANCOS = null;
	
	
	
	{
		BancoDTO bancoDTO1 = new BancoDTO();
		bancoDTO1.setIdBanco(1);
		bancoDTO1.setNombre("Banco 1");
		
		BancoDTO bancoDTO2 = new BancoDTO();
		bancoDTO2.setIdBanco(2);
		bancoDTO2.setNombre("Banco 2");

		BancoDTO bancoDTO3 = new BancoDTO();
		bancoDTO3.setIdBanco(3);
		bancoDTO3.setNombre("Banco 3");
		
		/**/
		this.BANCOS = new ArrayList<BancoDTO>();
		this.BANCOS.add(0, bancoDTO1);
		this.BANCOS.add(1, bancoDTO2);
		this.BANCOS.add(2, bancoDTO3);
		/**/		
	}
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("+++++++ INICIANDO EJECUCIÓN DE INTEGRATION TESTS (PRUEBAS DE INTEGRACIÓN). +++++++");		
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("-------------- INICIANDO PRUEBA INTEGRATION TEST (PRUEBA DE INTEGRACIÓN). --------------");
		
		//Se inicializa la instania de Mockito.
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("testMockitoListaNOVacia")
	void testMockitoListaNOVacia() {
		System.out.println("\t\t\t testMockitoListaNoVacia()");
		//Se hace el mock del servicio con los datos que esperamos se regresen.
		when(bancoMapper.findAll()).thenReturn(this.BANCOS);
		
		//Invocamos servicio que internamente manda llamar a bancoMapper.findAll()
		assertNotNull(bancoService.getAllBancos());	
		//assertEquals(3, bancoService.getAllBancos().size());
		//assertEquals(1, bancoService.getAllBancos().get(0).getIdBanco());
		
		//Verifica que se ejecute el método bancoMapper.findAll() - Para que se ejecute correctamente, se debe invocar una sola vez el método.
		verify(bancoMapper).findAll();
	}
	
	
	@Test
	@DisplayName("testMockitoListaVacia")
	void testMockitoListaVacia() {
		System.out.println("\t\t\t testMockitoListaVacia()");
		//Se hace el mock del servicio con los datos que esperamos se regresen.
		when(bancoMapper.findAll()).thenReturn(this.BANCOS);
		
		//Invocamos servicio que internamente manda llamar a bancoMapper.findAll()
		//assertNotNull(bancoService.getAllBancos(), "El objeto obtenido es nulo.");	
		//assertTrue(bancoService.getAllBancos()==null, "El valor devuleto es nulo.");
		assertThrows(NullPointerException.class, () -> {bancoService.getAllBancos().size();}, "<< No se genera NullPointerException >>");
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
