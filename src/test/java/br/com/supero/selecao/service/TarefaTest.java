package br.com.supero.selecao.service;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import br.com.supero.selecao.model.Tarefa;

public class TarefaTest extends TestCase {
	
	TarefaService tarefaService;

	@Before
	public void setUp() throws Exception {
		tarefaService = new TarefaService();
	}
	
	@Test
	public void verificaCriacao() {
		Tarefa tarefa = new Tarefa();
		tarefa.setId(0);
		tarefa.setTitulo("Titulo teste");
		tarefa.setDescricao("Descrição teste");
		
		assertEquals(expected, actual);
	}

}
