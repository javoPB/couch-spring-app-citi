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
import com.softtek.accimarketcoach.model.BancoDTO;

/**
 * @Mapper: Indica a la clase que realice un map, es decir, un registro de la clase para que sea tomado por la biblioteca de MyBatis y 
 * 			la registre con un transaccionador para realizar operaciones SQL.
 * 
 * @Select: Señala que la operación que se realiza es un SELECT de SQL y dentro de la anotacion colocaremos el query 
 * 			que indica la consulta por realizar.
 * 
 * @Insert, @Delete y @Update: Denota que la transacción por realizar es un INSERT, DELETE o UPDATE de SQL respectivamente, 
 * 							   ambos reciben dentro de los paréntesis la transacción y regresan un número indicando las filas que fueron afectadas 
 * 							   por dicha operación.
 * 
 * MyBatis: Es un framework de persistencia que soporta SQL, procedimientos almacenados y mapeos avanzados. 
 * 			MyBatis elimina casi todo el código JDBC, el establecimiento manual de parámetros y la obtención de resultados. 
 * 			MyBatis puede configurarse con XML o anotaciones y permite mapear tipos de datos primitivos, 
 * 			objetos de tipo Map y POJOs (Plain Old Java Objects) a registros de base de datos.
 * 
 * 
 * @Param: indica el nombre del parámetro de la consulta que queremos inyectar y en donde.
 * @author javier.perezb
 *
 */
@Mapper
public interface BancoMapper {

	@Select("select * from bancos")
	//@Select("select id_banco as idBanco, nombre from bancos")
	@Results(value = {
			@Result(property = "idBanco", column = "id_banco")
	})
	List<BancoDTO> findAll();

	@Select("select * from bancos where id_banco = #{idBanco}")
	@Results(value = {
			@Result(property = "idBanco", column = "id_banco")
	})
	BancoDTO findOne(@PathParam("idBanco") final int idBanco);

	
	//@Insert("insert into bancos(id_banco, nombre) values(#{id}, #{nombre})")
	//@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	//@Insert("insert into bancos(id_banco, nombre) values(#{id_banco}, #{nombre})")
	//@SelectKey(statement = "select max(id_banco) from bancos", keyProperty = "id_banco", before = false, resultType = Integer.class)
	@Insert("insert into bancos(id_banco, nombre) values(#{idBanco}, #{nombre})")
	@SelectKey(statement = "select max(id_banco) from bancos", keyProperty = "idBanco", before = false, resultType = Integer.class)
	void insert(BancoDTO banco);
	
	@Update("update bancos set nombre = #{nombre} where id_banco = #{idBanco}" )
	void update(BancoDTO banco);
	
	@Delete("delete from bancos where id_banco = #{id}")
	void delete(@PathParam("idBanco") final int id);
}
