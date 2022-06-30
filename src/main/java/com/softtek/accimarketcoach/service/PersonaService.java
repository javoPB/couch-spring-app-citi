package com.softtek.accimarketcoach.service;

import java.util.List;

import com.softtek.accimarketcoach.model.BancoDTO;
import com.softtek.accimarketcoach.model.PersonaDTO;

public interface PersonaService {
	
	List<PersonaDTO> getAllPersona();
	PersonaDTO getOnePersona(int id);
	String insertPersona(PersonaDTO persona);
	String updatePersona(PersonaDTO persona);
	String deletePersona(int id);

}
