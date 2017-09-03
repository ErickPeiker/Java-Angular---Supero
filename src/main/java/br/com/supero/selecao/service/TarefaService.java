package br.com.supero.selecao.service;

import java.util.Date;
import java.util.List;

import br.com.supero.selecao.dao.TarefaDAO;
import br.com.supero.selecao.exception.TarefaException;
import br.com.supero.selecao.model.Tarefa;
import br.com.supero.selecao.servlet.TarefaController;

public class TarefaService implements TarefaController {

	@Override
	public List<Tarefa> getAll() throws TarefaException {
		TarefaDAO dao = new TarefaDAO();
		return dao.getAll();
	}

	@Override
	public Tarefa salvar(Tarefa tarefa) throws TarefaException {
		/**
		 * Salva qualquer alteração nas tarefas
		 * Status, datas referentes a posicao no status, título e descrição
		 */
		if (tarefa.getId() == 0) {
			tarefa.setStatus("Aberto");
			tarefa.setCriacao(new Date());
			tarefa.setRemocao(null);
		} else if (tarefa.getStatus() == "Em Andamento") {
			tarefa.setAtualizacao(new Date());
			tarefa.setConclusao(null);
			tarefa.setRemocao(null);
		} else if (tarefa.getStatus() == "Encerrado") {
			tarefa.setConclusao(new Date());
			tarefa.setRemocao(null);
		} else if (tarefa.getStatus() == "Removido") {
			tarefa.setRemocao(new Date());
		}  else if (tarefa.getStatus() == "Aberto") {
			tarefa.setCriacao(new Date());
			tarefa.setAtualizacao(null);
			tarefa.setConclusao(null);
			tarefa.setRemocao(null);
		}
		
		TarefaDAO dao = new TarefaDAO();
		return dao.salvar(tarefa);
	}

	@Override
	public Tarefa alterar(Tarefa tarefa) throws TarefaException {
		TarefaDAO dao = new TarefaDAO();
		return dao.salvar(tarefa);
	}

	@Override
	public Tarefa remover(Integer id) throws TarefaException {
		TarefaDAO dao = new TarefaDAO();
		return dao.remover(id);
	}

}
