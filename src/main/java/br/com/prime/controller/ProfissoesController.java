package br.com.prime.controller;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.prime.model.TipoProfissao;
import br.com.prime.service.ProfissaoService;

@Path("/profissoes")
public class ProfissoesController {

	
	@Inject
	private ProfissaoService profissaoService;
	
	
	@GET
	@Path("/listaProfissoes")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<TipoProfissao> profissoes() {
		return profissaoService.listProfissoes();
	}
}
