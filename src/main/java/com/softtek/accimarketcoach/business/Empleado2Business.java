package com.softtek.accimarketcoach.business;

import java.util.ArrayList;
import java.util.List;

import com.softtek.accimarketcoach.model.EmpleadoDTO;
import com.softtek.accimarketcoach.service.EmpleadoService;

public class Empleado2Business implements EmpleadoService {

	@Override
	public List<EmpleadoDTO> getAllEmpleados() {
		// TODO Auto-generated method stub
		List<EmpleadoDTO> lstEmpleados2 = new ArrayList<EmpleadoDTO>();
		EmpleadoDTO empleado2 = new EmpleadoDTO();
		
		empleado2.setIdEmpleado(2);
		empleado2.setNombre("Empleado 2");
		empleado2.setArea("Area 2");
		lstEmpleados2.add(empleado2);
		
		
		return lstEmpleados2;
	}

	@Override
	public EmpleadoDTO getOneEmpleado(int idEmpleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertEmpleado(EmpleadoDTO empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmpleado(EmpleadoDTO empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmpleado(int idEmpleado) {
		// TODO Auto-generated method stub
		return null;
	}

}
