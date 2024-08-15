package com.beltis.desafio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beltis.desafio.model.ProjetoModel;
import com.beltis.desafio.service.intf.ProjetoService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/web/projetos")
@Validated
public class ProjetoController {
	@Autowired
	private ProjetoService projetoService;

	@GetMapping
	public String listarProjetos(Model model) throws EntityNotFoundException, Exception {
		List<ProjetoModel> projetos = projetoService.findAll();

		if (projetos.isEmpty()) {
			model.addAttribute("mensagem", "Nenhum projeto encontrado.");
		}

		model.addAttribute("projetos", projetos);
		model.addAttribute("projeto", new ProjetoModel());
		return "projetos/listar-projetos";
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProjeto(@PathVariable Integer id, @RequestBody @Valid ProjetoModel projetoModel) {
		projetoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	// Novo método para salvar um novo projeto
	@PostMapping
	public String salvarProjeto(@ModelAttribute @Valid ProjetoModel projeto) {
		//validação dos elementos do formulário no Frontend 
		projetoService.save(projeto);
		return "redirect:/web/projetos";
	}
	
	@PutMapping("/{idProjeto}")
	@ResponseBody
	public ResponseEntity<Void> atualizarProjeto(
			@PathVariable(name = "idProjeto", required = true) Integer idProjeto,
			@RequestBody(required = true) ProjetoModel projetoModel)
			throws EntityNotFoundException {
		//validação dos elementos do formulário no Frontend
		Optional<ProjetoModel> opProjetoModel = projetoService.findById(idProjeto);
		
		if ( opProjetoModel.isPresent() ) {
			projetoModel.setIdProjeto(idProjeto);
			projetoService.update(projetoModel);
			
			return ResponseEntity.ok().build();
		} else {
			throw new EntityNotFoundException("Não foi possivel encontrar o registro na tabela PROJETOS.");
		}
	}
}