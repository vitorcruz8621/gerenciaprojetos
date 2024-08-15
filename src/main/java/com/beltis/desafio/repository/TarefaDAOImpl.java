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
		Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "UPDATE TarefaModel t SET t.titulo = :titulo, t.descricao = :descricao, t.prioridade = :prioridade, t.estimativaHoras = :estimativaHoras WHERE t.idTarefa = :idTarefa";
        Query<?> query = session.createQuery(hql);
        query.setParameter("idTarefa", tarefa.getIdTarefa());
        query.setParameter("titulo", tarefa.getTitulo());
        query.setParameter("descricao", tarefa.getDescricao());
        query.setParameter("prioridade", tarefa.getPrioridade());
        query.setParameter("estimativaHoras", tarefa.getEstimativaHoras());
        
        int result = query.executeUpdate();
        transaction.commit();
        session.close();
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