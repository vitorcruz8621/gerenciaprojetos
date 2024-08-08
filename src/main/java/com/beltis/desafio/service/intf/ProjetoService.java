package com.beltis.desafio.service.intf;

import java.util.List;
import java.util.Optional;

import com.beltis.desafio.model.ProjetoModel;

import jakarta.persistence.EntityNotFoundException;

public interface ProjetoService {
	public List<ProjetoModel> findAll() throws EntityNotFoundException, Exception ;
	public Optional<ProjetoModel> findById(Integer id);
	public void save(ProjetoModel projeto);
	public void update(ProjetoModel projeto);
	public void delete(Integer id);
}