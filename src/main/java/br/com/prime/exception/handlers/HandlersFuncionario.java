package br.com.prime.exception.handlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.prime.exception.FuncionarioException;

@Provider()
public class HandlersFuncionario implements ExceptionMapper<FuncionarioException> {

	@Override
	public Response toResponse(FuncionarioException exception) {
		return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessages()).build();
	}
}
