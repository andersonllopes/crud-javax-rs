package br.com.prime.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.prime.exception.EnderecoException;
import br.com.prime.exception.FuncionarioException;
import br.com.prime.exception.ValidateException;
import br.com.prime.model.Funcionario;
import br.com.prime.model.request.FuncionarioRequest;
import br.com.prime.service.FuncionarioService;

@Path("/funcionarios")
public class FuncionarioController {

	@Inject
	private FuncionarioService funcionarioService;

	@GET
	@Path("/listaFuncionario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response funcionario() throws FuncionarioException {
		List<Funcionario> listFuncionario = funcionarioService.ListFuncionario();
		return Response.status(Response.Status.OK).entity(listFuncionario).build();
	}

	@POST
	@Path("/cadastrarFuncionario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarFuncionario(FuncionarioRequest request)
			throws FuncionarioException, EnderecoException, ValidateException {
		funcionarioService.cadastrarFuncionario(request);
		return Response.status(Response.Status.CREATED).entity("Funcionário " + request.getNome() + " Cadastrado com Sucesso!").build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response alterarFuncionario(FuncionarioRequest funcionario, @PathParam("id") int id) throws Exception {
		try {
			funcionarioService.alterarFuncionario(funcionario, id);
			return Response.status(Response.Status.OK).entity("Funcionário " + id + " Alterado!").build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Erro ao alterar").build();
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response deletarFuncionario(@PathParam("id") int id) throws Exception {
		try {
			funcionarioService.deletarFuncionario(id);
			return Response.status(Response.Status.OK).entity("Funcionário " + id + " Deletado!").build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Erro ao excluir, tente novamente!").build();
		}
	}

	@GET
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Funcionario> buscarFuncionario(@QueryParam("nome") String nome, @QueryParam("idade") int idade,
			@QueryParam("codigoProfissao") int codigoProfissao) throws Exception {
		try {
			return funcionarioService.buscarFuncionario(nome, idade, codigoProfissao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
