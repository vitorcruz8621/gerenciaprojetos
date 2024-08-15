package com.beltis.desafio.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beltis.desafio.model.ProjetoModel;
import com.beltis.desafio.service.intf.ProjetoService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/projetos")
@Validated
public class ProjetoApiController {
	@Autowired
	private ProjetoService projetoService;

	@GetMapping
	public ResponseEntity<List<ProjetoModel>> getAllProjetos() throws EntityNotFoundException, Exception {

		List<ProjetoModel> projetos = projetoService.findAll();

		if (!projetos.isEmpty()) {
			return ResponseEntity.ok(projetos);
		}

		// TODO: criar uma exceção para caso de registro não encontrado.
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjetoModel> getProjetoById(@PathVariable Integer id) throws EntityNotFoundException {
		Optional<ProjetoModel> opProjeto = projetoService.findById(id);

		if (opProjeto.isPresent()) {
			return ResponseEntity.ok(opProjeto.get());
		}

		// TODO: criar uma exceção para caso de registro não encontrado.
		throw new EntityNotFoundException("O projeto não existe na tabela PROJETOS");
	}

	@PostMapping
	public ResponseEntity<ProjetoModel> createProjeto(@RequestBody ProjetoModel projeto) {
		projetoService.save(projeto);
		return ResponseEntity.ok(projeto);
	}

	@PutMapping("/{idProjeto}")
	public ResponseEntity<ProjetoModel> updateProjeto(
			@PathVariable(name = "idProjeto", required = true) Integer idProjeto, 
			@RequestBody(required = true) ProjetoModel projeto) {
		projeto.setIdProjeto(idProjeto);
		projetoService.update(projeto);
		return ResponseEntity.ok(projeto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProjeto(@PathVariable Integer id) {
		projetoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
