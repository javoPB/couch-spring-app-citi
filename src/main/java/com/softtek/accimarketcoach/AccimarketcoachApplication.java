package com.softtek.accimarketcoach;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.softtek.accimarketcoach.model.BancoDTO;

/**
 * @SpringBootApplication: Engloba @Configuration, @EnableAutoConfiguration, @ComponentScan 
 * 
 * @MapperScan: Registrar las interfaces del mapeador MyBatis. (Le indicamos la ruta donde se encuentran los DTO que debe mapear 
 * 				con las entidades de la base de datos)
 * 
 * @author javier.perezb
 *
 */
@MappedTypes(BancoDTO.class)
@MapperScan("com.softtek.accimarketcoach.mapper")
@SpringBootApplication
public class AccimarketcoachApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccimarketcoachApplication.class, args);
	}

}
