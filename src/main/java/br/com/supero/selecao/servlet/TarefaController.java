package br.com.supero.selecao.servlet;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.supero.selecao.exception.TarefaException;
import br.com.supero.selecao.model.Tarefa;

@Path("/tarefa")
public interface TarefaController {

	@GET
	@Produces("application/json")
	@Path("/")
	public List<Tarefa> getAll() throws TarefaException;
	
	@POST
	@Produces("application/json")
	@Path("/")
	Tarefa salvar(Tarefa tarefa) throws TarefaException;

	@PUT
	@Produces("application/json")
	@Path("/")
	Tarefa alterar(Tarefa tarefa) throws TarefaException;
	
	@DELETE
	@Produces("application/json")
	@Path("/{id}")
	public Tarefa remover(@PathParam("id")Integer id) throws TarefaException;
	
}
