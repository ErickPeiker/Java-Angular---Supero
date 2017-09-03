package br.com.supero.selecao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.supero.selecao.exception.TarefaException;
import br.com.supero.selecao.model.Tarefa;

public class TarefaDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public TarefaDAO() {
		emf = Persistence.createEntityManagerFactory("tarefaDS");
		this.em = emf.createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> getAll() throws TarefaException {
		Query consulta = this.em.createQuery("SELECT tarefa FROM Tarefa tarefa");
		List<Tarefa> tarefas = consulta.getResultList();
		this.emf.close();
		return tarefas;
	}

	public Tarefa salvar(Tarefa tarefa) throws TarefaException {
		this.em.getTransaction().begin();
		Tarefa tarefaSalva = this.em.merge(tarefa);
		this.em.getTransaction().commit();
		this.emf.close();
		return tarefaSalva;
	}

	public Tarefa remover(Integer id) throws TarefaException {
		this.em.getTransaction().begin();
		Tarefa tarefa = getTarefa(id);
		this.em.remove(tarefa);
		this.em.getTransaction().commit();
		this.emf.close();
		return tarefa;
	}
	
	public Tarefa getTarefa(Integer id) throws TarefaException {
		Query consulta = this.em.createQuery("SELECT tarefa FROM Tarefa tarefa WHERE tarefa.id = :id");
		consulta.setParameter("id", id);
		Tarefa tarefa = (Tarefa) consulta.getSingleResult();
		return tarefa;
	}

}
