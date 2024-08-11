package com.beltis.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beltis.desafio.model.ProjetoModel;
import com.beltis.desafio.service.intf.ProjetoService;

import jakarta.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/web/projetos")
@Validated
public class HelloController {
	@Autowired
	private ProjetoService projetoService;

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello World");
        return "olamundo"; // Nome do arquivo template sem a extensão .html
    }
    
    @GetMapping
    public String listarProjetos(Model model) throws EntityNotFoundException, Exception {
        List<ProjetoModel> projetos = projetoService.findAll();

        if (projetos.isEmpty()) {
            model.addAttribute("mensagem", "Nenhum projeto encontrado.");
        }

        model.addAttribute("projetos", projetos);
        return "listar-projetos"; // Nome do arquivo template sem a extensão .html
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProjeto(@PathVariable Integer id) {
		projetoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}