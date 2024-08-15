package com.beltis.desafio.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beltis.desafio.model.ProjetoModel;
import com.beltis.desafio.repository.dao.ProjetoDAO;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProjetoDAOImpl implements ProjetoDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
    @Override
    public List<ProjetoModel> findAll() {
        Session session = sessionFactory.openSession();
        Query<ProjetoModel> query = session.createQuery("from ProjetoModel", ProjetoModel.class);
        List<ProjetoModel> projetos = query.list();
        session.close();
        return projetos;
    }
    
	@Override
    public Optional<ProjetoModel> findById(Integer id) {
        Session session = sessionFactory.openSession();
        Optional<ProjetoModel> projeto = Optional.ofNullable(session.get(ProjetoModel.class, id));
        session.close();
        return projeto;
    }
	
	@Override
    public void save(ProjetoModel projeto) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(projeto);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(ProjetoModel projeto) {
    	Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "UPDATE ProjetoModel p SET p.titulo = :titulo, p.descricao = :descricao, p.dataInicio = :dataInicio WHERE p.idProjeto = :idProjeto";
        Query<?> query = session.createQuery(hql);
        query.setParameter("idProjeto", projeto.getIdProjeto());
        query.setParameter("titulo", projeto.getTitulo());
        query.setParameter("descricao", projeto.getDescricao());
        query.setParameter("dataInicio", projeto.getDataInicio());
        
        int result = query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        ProjetoModel projeto = session.get(ProjetoModel.class, id);
        if (projeto != null) {
            session.delete(projeto);
        }
        transaction.commit();
        session.close();
    }

}