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

import com.beltis.desafio.model.TarefaModel;
import com.beltis.desafio.service.intf.TarefaService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/tarefas")
@Validated
public class TarefaApiController {
	@Autowired
    private TarefaService tarefaService;
	
	@GetMapping
    public ResponseEntity<List<TarefaModel>> getAllTarefas() throws EntityNotFoundException, Exception {
        List<TarefaModel> listaTarefas = tarefaService.findAll();
        
		if (!listaTarefas.isEmpty()) {
			return ResponseEntity.ok(listaTarefas);
		}

		// TODO: criar uma exceção para caso de registro não encontrado.
		return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> getTarefaById(@PathVariable Integer id) {
        Optional<TarefaModel> opTarefa = tarefaService.findById(id);
        
		if (opTarefa.isPresent()) {
			return ResponseEntity.ok(opTarefa.get());
		}

		// TODO: criar uma exceção para caso de registro não encontrado.
		return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TarefaModel> createTarefa(@RequestBody TarefaModel tarefa) {
        tarefaService.save(tarefa);
        return ResponseEntity.ok(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> updateTarefa(@PathVariable Integer id, @RequestBody TarefaModel tarefa) {
        tarefa.setIdTarefa(id);
        tarefaService.update(tarefa);
        return ResponseEntity.ok(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarefa(@PathVariable Integer id) {
        tarefaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}