package br.com.supero.selecao.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHttpStatus implements ExceptionMapper<TarefaException> {

	public Response toResponse(TarefaException ex) {
		Response.Status httpStatus = Response.Status.INTERNAL_SERVER_ERROR;
		
		if (ex instanceof TarefaException) {
            httpStatus = Response.Status.BAD_REQUEST;
		}
 
        return Response.status(httpStatus).entity(ex.getMessage()).build();
	}

}
