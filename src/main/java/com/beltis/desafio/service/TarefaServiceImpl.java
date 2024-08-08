package com.beltis.desafio.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beltis.desafio.model.TarefaModel;
import com.beltis.desafio.repository.dao.TarefaDAO;
import com.beltis.desafio.service.intf.TarefaService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TarefaServiceImpl implements TarefaService {
	@Autowired
    private TarefaDAO tarefaDAO;

    public List<TarefaModel> findAll() throws EntityNotFoundException, Exception {
        return tarefaDAO.findAll();
    }
    
    public Optional<TarefaModel> findById(Integer id) {
        return tarefaDAO.findById(id);
    }

    public void save(TarefaModel tarefa) {
        tarefaDAO.save(tarefa);
    }

    public void update(TarefaModel tarefa) {
        tarefaDAO.update(tarefa);
    }

    public void delete(Integer id) {
        tarefaDAO.delete(id);
    }
}