package com.mv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mv.entities.CafeDaManha;
import com.mv.services.CafeDaManhaService;

@RestController
@RequestMapping(value = "/cafe-da-manha")
public class CafeDaManhaController {

	@Autowired
	private CafeDaManhaService service;

	@GetMapping(value = "/{nome}")
	public ResponseEntity<CafeDaManha> findByCpf(@PathVariable String nome) {
		CafeDaManha obj = service.findByNome(nome);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<CafeDaManha> insert(@RequestBody CafeDaManha obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{nome}")
	public ResponseEntity<Void> delete(@PathVariable String nome) {
		service.delete(nome);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{name}")
	public ResponseEntity<CafeDaManha> update(@RequestBody CafeDaManha entity, @PathVariable String name) {
		CafeDaManha obj = service.update(entity,name);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<CafeDaManha>> findAll() {
		List<CafeDaManha> list = service.findAll();
		return ResponseEntity.ok(list);
	}
}