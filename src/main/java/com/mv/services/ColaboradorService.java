package com.mv.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mv.entities.Colaborador;
import com.mv.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	ColaboradorRepository colaboradorRepository;

	public Colaborador findByCpf(String cpf) {
		return colaboradorRepository.findByCpf(cpf);

	}

	public Colaborador insert(Colaborador obj) {
		Colaborador objColaborador = colaboradorRepository.findByCpf(obj.getCpf());
		if (objColaborador == null) {
			return colaboradorRepository.save(obj);
		}
		return objColaborador;
	}

	public void delete(String cpf)  {
			colaboradorRepository.deleteByCpf(cpf);
	}

	public Colaborador update(Colaborador obj) {
	
			Colaborador entity = colaboradorRepository.findByCpf(obj.getCpf());
			if(entity != null) {
			updateData(entity, obj);
			return colaboradorRepository.save(entity);
			}
			return null;
	
	}
	public List<Colaborador> findAll() {
		return colaboradorRepository.findAll();
	}

	private void updateData(Colaborador entity, Colaborador obj) {
		entity.setCpf(obj.getCpf());
		entity.setNome(obj.getNome());

	}


}
