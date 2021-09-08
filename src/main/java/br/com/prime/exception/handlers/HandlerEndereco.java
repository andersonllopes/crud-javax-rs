package br.com.prime.exception.handlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import br.com.prime.exception.EnderecoException;

public class HandlerEndereco implements ExceptionMapper<EnderecoException> {

	@Override
	public Response toResponse(EnderecoException exception) {
		return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessages()).build();
	}

	
}
