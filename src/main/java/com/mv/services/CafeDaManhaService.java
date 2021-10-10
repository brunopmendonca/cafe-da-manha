package com.mv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mv.entities.CafeDaManha;
import com.mv.entities.Colaborador;
import com.mv.repositories.CafeDaManhaRepository;
import com.mv.repositories.ColaboradorRepository;

@Service
public class CafeDaManhaService {

	@Autowired
	CafeDaManhaRepository cafeDaManhaRepository;

	@Autowired
	ColaboradorRepository colaboradorRepository;

	public CafeDaManha insert(CafeDaManha obj) {
		Colaborador colaborador = colaboradorRepository.findByCpf(obj.getColaboradorCpf());
		CafeDaManha cafeDaManha = cafeDaManhaRepository.findByNome(obj.getNome());
		if (colaborador != null && cafeDaManha == null) {
			return cafeDaManhaRepository.save(obj);
		}
		return null;
	}

	public CafeDaManha update(CafeDaManha obj, String name) {
		CafeDaManha entity = cafeDaManhaRepository.findByNome(name);
		if (entity != null) {
			updateData(entity, obj);
			return cafeDaManhaRepository.save(entity);
		}
		return null;
	}

	private void updateData(CafeDaManha entity, CafeDaManha obj) {
		entity.setColaboradorCpf(obj.getColaboradorCpf());
		entity.setNome(obj.getNome());
	}

	public void delete(String nome) {
		cafeDaManhaRepository.deleteByNome(nome);
	}

	public CafeDaManha findByNome(String nome) {
		return cafeDaManhaRepository.findByNome(nome);
	}

	public List<CafeDaManha> findAll() {
		return cafeDaManhaRepository.findAll();
	}
}
