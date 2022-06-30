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
 * version 1.0
 * EmpleadoController
 * @author Lillo Ariadna
 * 
 *
 */

package com.softtek.accimarketcoach.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.accimarketcoach.business.Empleado2Business;
import com.softtek.accimarketcoach.model.EmpleadoDTO;
import com.softtek.accimarketcoach.service.EmpleadoService;



@RestController
@RequestMapping("/rest/empleados")
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;
	
	
	@GetMapping("/all")
	public List<EmpleadoDTO> getAllTemporal(){
		List<EmpleadoDTO> lstEmpleados = this.empleadoService.getAllEmpleados();
		
		return lstEmpleados;
	}
	
	@GetMapping("/one/{idEmpleado}")
	public EmpleadoDTO getOne(@PathVariable int idEmpleado){
		EmpleadoDTO empleados = this.empleadoService.getOneEmpleado(idEmpleado);
		
		return empleados;
	}
	
	@PostMapping("/create")
	public String insertar(@RequestBody EmpleadoDTO empleado){
		
		System.out.println("********************************************************************************************************");
		System.out.println("***********************" + empleado.toString());
		System.out.println("********************************************************************************************************");
		String msg = this.empleadoService.insertEmpleado(empleado);
		
		return msg;
	}
	
	@PutMapping("/put/{idEmpleado}")
	public String update(@RequestBody EmpleadoDTO empleado, @PathVariable int idEmpleado){
		String msg = "El registro no existe.";
				
		EmpleadoDTO empleadosRespuesta = this.empleadoService.getOneEmpleado(idEmpleado);
		if( empleadosRespuesta != null ) {
			empleado.setIdEmpleado(idEmpleado);
			msg = this.empleadoService.updateEmpleado(empleado);
		}
		
		return msg;
	}
	
	@DeleteMapping("/delete/{idEmpleado}")
	public String delete(@PathVariable int idEmpleado){
		String msg = "El registro no existe.";
		
		EmpleadoDTO empleadosRespuesta = this.empleadoService.getOneEmpleado(idEmpleado);
		if( empleadosRespuesta != null ) {
			msg = this.empleadoService.deleteEmpleado(idEmpleado);
		}
		
		System.out.println("para ver los conflictos del merge - desde el repositorio");
		return msg;
	}	

}
