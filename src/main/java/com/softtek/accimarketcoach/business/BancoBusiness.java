package com.softtek.accimarketcoach.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.accimarketcoach.mapper.BancoMapper;
import com.softtek.accimarketcoach.model.BancoDTO;
import com.softtek.accimarketcoach.service.BancoService;

/**
 * @Service: Se usa para construir una clase de Servicio que habitualmente se conecta a varios repositorios y agrupa su funcionalidad.
 * 
 * @author javier.perezb
 *
 */
@Service
public class BancoBusiness implements BancoService {
	@Autowired
	private BancoMapper bancoMapper;
	
//	public BancoBusiness(BancoMapper bancoMapper) {
//		this.bancoMapper = bancoMapper;
//	}
	
	@Override
	public List<BancoDTO> getAllBancos() {
		// TODO Auto-generated method stub
		return this.bancoMapper.findAll();
	}

	@Override
	public BancoDTO getOneBanco(int id) {
		// TODO Auto-generated method stub
		return this.bancoMapper.findOne(id);
	}

	@Override
	public String insertBanco(BancoDTO banco) {
		// TODO Auto-generated method stub
		this.bancoMapper.insert(banco);
		
		return "El banco se inserto exitosamente.";
	}

	@Override
	public String updateBanco(BancoDTO banco) {
		// TODO Auto-generated method stub
		this.bancoMapper.update(banco);
		
		return "El banco se actualizo exitosamente.";
	}

	@Override
	public String deleteBanco(int id) {
		// TODO Auto-generated method stub
		this.bancoMapper.delete(id);
		
		return "El banco se elimino exitosamente.";
	}

	@Override
	public double suma(double valor1, double valor2) {
		// TODO Auto-generated method stub
		return valor1 + valor2;
	}

}
