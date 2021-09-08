package br.com.prime.exception.handlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import br.com.prime.exception.ValidateException;

public class HandlerValidator implements ExceptionMapper<ValidateException> {

	@Override
	public Response toResponse(ValidateException exception) {
		return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessages()).build();
	}
}
