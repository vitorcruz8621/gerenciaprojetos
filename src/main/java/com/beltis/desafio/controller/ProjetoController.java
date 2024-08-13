package com.beltis.desafio.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public ResponseEntity<Void> deleteProjeto(@PathVariable Integer id) {
		projetoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	// Novo método para salvar um novo projeto
	@PostMapping
	public String salvarProjeto(@ModelAttribute @Valid ProjetoModel projeto, BindingResult result) {
	    if (projeto.getDataInicio().isBefore(LocalDate.now())) {
	        result.rejectValue("dataInicio", "error.projeto", "A data de início do projeto não pode ser antes da data atual!");
	        return "formulario_projeto";
	    }
		projetoService.save(projeto);
		return "redirect:/web/projetos";
	}
}