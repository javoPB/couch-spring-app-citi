package com.softtek.accimarketcoach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.accimarketcoach.business.BancoBusiness;
import com.softtek.accimarketcoach.model.BancoDTO;
import com.softtek.accimarketcoach.service.BancoService;

/**
 * @RestController: Marcan la clase como un controlador de solicitudes para permitir que Spring 
 * 					lo reconozca como un servicio RESTful durante el tiempo de ejecución
 * 
 * @RequestMapping: Mapea la ruta de nuestro servicio rest. Este Mapping se concatena con el mapping a nivel método
 * 
 * @Autowired: Funciona como una mega factoria de objetos para instanciar objetos con alguna de las anotaciones 
 * 			   @Controller ,@Service ,@repository o @RestController. (Es decir, spring / spring boot se encarga de gestionar la instancia de los objetos)
 * 
 * Verbos de los servicios Rest:
 * 		Get		-- Obtener información
 *      Post	-- Insertar información
 *      Delete	-- Eliminar información
 *      Put		-- Actualizar información
 * 
 * @author javier.perezb
 *
 */
@RestController
@RequestMapping("/rest/bancos")
public class BancoController {
	
	@Autowired
	private BancoService bancoService;
	
	@GetMapping("/all")
	public List<BancoDTO> getAllTemporal(){
		List<BancoDTO> lstBancos = this.bancoService.getAllBancos();
		
		return lstBancos;
	}
	
	@GetMapping("/one/{id}")
	public BancoDTO getOne(@PathVariable int id){
		BancoDTO bancos = this.bancoService.getOneBanco(id);
		
		return bancos;
	}
	
	@PostMapping("/create")
	public String insertar(@RequestBody BancoDTO banco){
		
		System.out.println("********************************************************************************************************");
		System.out.println("***********************" + banco.getDetallesBancoDTO().toString());
		System.out.println("********************************************************************************************************");
		String msg = this.bancoService.insertBanco(banco);
		
		return msg;
	}
	
	@PutMapping("/put/{id}")
	public String update(@RequestBody BancoDTO banco, @PathVariable int id){
		String msg = "El registro no existe.";
				
		BancoDTO bancosRespuesta = this.bancoService.getOneBanco(id);
		if( bancosRespuesta != null ) {
			banco.setIdBanco(id);
			msg = this.bancoService.updateBanco(banco);
		}
		
		return msg;
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		String msg = "El registro no existe.";
		
		BancoDTO bancosRespuesta = this.bancoService.getOneBanco(id);
		if( bancosRespuesta != null ) {
			msg = this.bancoService.deleteBanco(id);
		}
		
		System.out.println("para ver los conflictos del merge - desde el repositorio");
		return msg;
	}	
}
