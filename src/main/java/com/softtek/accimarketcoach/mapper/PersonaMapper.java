package com.softtek.accimarketcoach.mapper;


import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.softtek.accimarketcoach.model.PersonaDTO;

@Mapper
public interface PersonaMapper {
	
	@Select("select * from personas")
	
	@Results(value = {
			@Result(property = "id", column = "id_persona")
	})
	List<PersonaDTO> findAll();

	@Select("select * from persona where id = #{id}")
	@Results(value = {
			@Result(property = "id", column = "id_persona")
	})
	PersonaDTO findOne(@PathParam("id") final int id);

	
	@Insert("insert into personas(id_persona, nombre, email) values(#{id}, #{nombre}, #{email}) ")
	@SelectKey(statement = "select max(id_persona) from personas", keyProperty = "id", before = false, resultType = Integer.class)
	void insert(PersonaDTO persona);
	
	@Update("update personas set nombre = #{nombre} where id = #{id}" )
	void update(PersonaDTO persona);
	
	@Delete("delete from personas where id = #{id}")
	void delete(@PathParam("id") final int id);
}
