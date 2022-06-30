package com.softtek.accimarketcoach.mapper;

import java.util.List;
import javax.websocket.server.PathParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.softtek.accimarketcoach.model.EmpleadoDTO;

@Mapper
public interface EmpleadoMapper {

	@Select("select * from empleados")
		@Results(value = {
		@Result(property = "idEmpleado", column = "id_empleado")
	})
	List<EmpleadoDTO> findAll();

	@Select("select * from empleados where id_empleado = #{idEmpleado}")
	@Results(value = {
			@Result(property = "idEmpleado", column = "id_empleado")
	})
	EmpleadoDTO findOne(@PathParam("idEmpleado") final int idEmpleado);

	
	@Insert("insert into empleados(id_empleado, nombre, area) values(#{idEmpleado}, #{nombre},#{area})")
	@SelectKey(statement = "select max(id_empleado) from empleados", keyProperty = "idEmpleado", before = false, resultType = Integer.class)
	void insert(EmpleadoDTO empleado);
	
	@Update("update empleados set nombre = #{nombre}, area = #{area} where id_empleado = #{idEmpleado}" )
	void update(EmpleadoDTO empleado);
	
	@Delete("delete from empleados where id_empleado = #{idEmpleado}")
	void delete(@PathParam("idEmpleado") final int idEmpleado);
}
