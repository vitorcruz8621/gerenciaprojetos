package com.beltis.desafio.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beltis.desafio.model.TarefaModel;
import com.beltis.desafio.repository.dao.TarefaDAO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TarefaDAOImpl implements TarefaDAO {
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public List<TarefaModel> findAll() throws EntityNotFoundException, Exception{
		Session session = sessionFactory.openSession();
        Query<TarefaModel> query = session.createQuery("from TarefaModel", TarefaModel.class);
        List<TarefaModel> tarefas = query.list();
        session.close();
        return tarefas;
	}

	@Override
	public Optional<TarefaModel> findById(Integer id) {
		Session session = sessionFactory.openSession();
        Optional<TarefaModel> opTarefa = Optional.ofNullable(session.get(TarefaModel.class, id));
        session.close();
        return opTarefa;
	}

	@Override
	public void save(TarefaModel tarefa) {
		Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(tarefa);
        transaction.commit();
        session.close();
		
	}

	@Override
	public void update(TarefaModel tarefa) {
		try {
			Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(tarefa);
	        transaction.commit();
	        session.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        TarefaModel tarefa = session.get(TarefaModel.class, id);
        if (tarefa != null) {
            session.delete(tarefa);
        }
        transaction.commit();
        session.close();
	}
}