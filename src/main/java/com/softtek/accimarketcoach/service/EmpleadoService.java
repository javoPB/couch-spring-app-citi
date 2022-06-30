package com.softtek.accimarketcoach.service;

import java.util.List;
import com.softtek.accimarketcoach.model.EmpleadoDTO;

public interface EmpleadoService {
	List<EmpleadoDTO> getAllEmpleados();
	EmpleadoDTO getOneEmpleado(int idEmpleado);
	String insertEmpleado(EmpleadoDTO empleado);
	String updateEmpleado(EmpleadoDTO empleado);
	String deleteEmpleado(int idEmpleado);
}
