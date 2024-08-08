package com.beltis.desafio.repository.dao;

import java.util.List;
import java.util.Optional;

import com.beltis.desafio.model.ProjetoModel;

public interface ProjetoDAO {
	public List<ProjetoModel> findAll();
	public Optional<ProjetoModel> findById(Integer id);
	public void save(ProjetoModel projeto);
	public void update(ProjetoModel projeto);
	public void delete(Integer id);
}