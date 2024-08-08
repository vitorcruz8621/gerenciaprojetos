package com.beltis.desafio.service.intf;

import java.util.List;
import java.util.Optional;

import com.beltis.desafio.model.TarefaModel;

import jakarta.persistence.EntityNotFoundException;

public interface TarefaService {
    public List<TarefaModel> findAll() throws EntityNotFoundException, Exception;
    public Optional<TarefaModel> findById(Integer id);
    public void save(TarefaModel tarefa);
    public void update(TarefaModel tarefa);
    public void delete(Integer id);
}