package com.softtek.accimarketcoach.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.accimarketcoach.mapper.EmpleadoMapper;
import com.softtek.accimarketcoach.model.EmpleadoDTO;
import com.softtek.accimarketcoach.service.EmpleadoService;

@Service
public class EmpleadoBusiness implements EmpleadoService {
	@Autowired
	private EmpleadoMapper empleadoMapper;
	

	@Override
	public List<EmpleadoDTO> getAllEmpleados() {		
		return this.empleadoMapper.findAll();
	}

	@Override
	public EmpleadoDTO getOneEmpleado(int idEmpleado) {
		return this.empleadoMapper.findOne(idEmpleado);
	}

	@Override
	public String insertEmpleado(EmpleadoDTO empleado) {
		this.empleadoMapper.insert(empleado);
		
		return "El empleado se inserto exitosamente.";
	}

	@Override
	public String updateEmpleado(EmpleadoDTO empleado) {
		this.empleadoMapper.update(empleado);
		
		return "El empleado se actualizo exitosamente.";
	}

	@Override
	public String deleteEmpleado(int idEmpleado) {
		this.empleadoMapper.delete(idEmpleado);
		
		return "El empleado se elimino exitosamente.";
	}

}
