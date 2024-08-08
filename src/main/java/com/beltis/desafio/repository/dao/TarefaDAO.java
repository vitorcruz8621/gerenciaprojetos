package com.beltis.desafio.repository.dao;

import java.util.List;
import java.util.Optional;

import com.beltis.desafio.model.TarefaModel;

import jakarta.persistence.EntityNotFoundException;

public interface TarefaDAO {
	public List<TarefaModel> findAll() throws EntityNotFoundException, Exception;
	public Optional<TarefaModel> findById(Integer id);
	public void save(TarefaModel tarefa);
	public void update(TarefaModel tarefa);
	public void delete(Integer id);
}