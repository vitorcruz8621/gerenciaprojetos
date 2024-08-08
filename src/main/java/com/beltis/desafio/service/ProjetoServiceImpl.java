package com.beltis.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beltis.desafio.model.ProjetoModel;
import com.beltis.desafio.repository.dao.ProjetoDAO;
import com.beltis.desafio.service.intf.ProjetoService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjetoServiceImpl implements ProjetoService {
	@Autowired
	private ProjetoDAO projetoDAO;

	public List<ProjetoModel> findAll() throws EntityNotFoundException, Exception {
		return projetoDAO.findAll();
	}

	public Optional<ProjetoModel> findById(Integer id) {
		return projetoDAO.findById(id);
	}

	public void save(ProjetoModel projeto) {
		projetoDAO.save(projeto);
	}

	public void update(ProjetoModel projeto) {
		projetoDAO.update(projeto);
	}

	public void delete(Integer id) {
		projetoDAO.delete(id);
		;
	}
}