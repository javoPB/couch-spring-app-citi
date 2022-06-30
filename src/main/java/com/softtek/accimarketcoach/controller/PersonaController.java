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

import com.softtek.accimarketcoach.model.PersonaDTO;
import com.softtek.accimarketcoach.service.PersonaService;
import com.softtek.accimarketcoach.business.PersonaBussines;


@RestController
@RequestMapping("/rest/Persona")
public class PersonaController {
	
		@Autowired
		private PersonaService personaService;
		
		@GetMapping("/all")
		public List<PersonaDTO> getAllTemporal(){
			List<PersonaDTO> lstpersona = this.personaService.getAllPersona();
			
			return lstpersona;
		}
		
		@GetMapping("/one/{id}")
		public PersonaDTO getOne(@PathVariable int id){
			PersonaDTO per = this.personaService.getOnePersona(id);
			
			return per;
		}
		
		@PostMapping("/create")
		public String insertar(@RequestBody PersonaDTO persona){
			
			System.out.println("********************************************************************************************************");
			System.out.println("***********************" + persona.getId());
			System.out.println("********************************************************************************************************");
			String msg = this.personaService.insertPersona(persona);
			
			return msg;
		}
		
		@PutMapping("/put/{id}")
		public String update(@RequestBody PersonaDTO persona, @PathVariable int id){
			String msg = "El registro no existe.";
					
			PersonaDTO Respuesta = this.personaService.getOnePersona(id);
			if( Respuesta != null ) {
				persona.setId(id);
				msg = this.personaService.updatePersona(persona);
			}
			
			return msg;
		}
		
		@DeleteMapping("/delete/{id}")
		public String delete(@PathVariable int id){
			String msg = "El registro no existe.";
			
			PersonaDTO Respuesta = this.personaService.getOnePersona(id);
			if( Respuesta != null ) {
				msg = this.personaService.deletePersona(id);
			}
			
			return msg;
		}	

}
