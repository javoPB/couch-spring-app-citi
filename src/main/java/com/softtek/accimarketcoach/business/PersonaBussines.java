package com.softtek.accimarketcoach.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.softtek.accimarketcoach.mapper.PersonaMapper;
import com.softtek.accimarketcoach.model.PersonaDTO;
import com.softtek.accimarketcoach.service.PersonaService;

@Service
public class PersonaBussines implements PersonaService{
	
	@Autowired
	private PersonaMapper personaMapper;
	
	
	@Override
	public List<PersonaDTO> getAllPersona() {
		// TODO Auto-generated method stub
		return this.personaMapper.findAll();
	}

	@Override
	public PersonaDTO getOnePersona(int id) {
		// TODO Auto-generated method stub
		return this.personaMapper.findOne(id);
	}

	@Override
	public String insertPersona(PersonaDTO persona) {
		// TODO Auto-generated method stub
		this.personaMapper.insert(persona);
		
		return "El banco se inserto exitosamente.";
	}

	@Override
	public String updatePersona(PersonaDTO persona) {
		// TODO Auto-generated method stub
		this.personaMapper.update(persona);
		
		return "El banco se actualizo exitosamente.";
	}

	@Override
	public String deletePersona(int id) {
		// TODO Auto-generated method stub
		this.personaMapper.delete(id);
		
		return "El banco se elimino exitosamente.";
	}

	

}
