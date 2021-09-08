package br.com.prime.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.prime.exception.EnderecoException;
import br.com.prime.exception.FuncionarioException;
import br.com.prime.exception.ValidateException;
import br.com.prime.model.Endereco;
import br.com.prime.model.Funcionario;
import br.com.prime.model.Profissoes;
import br.com.prime.model.request.FuncionarioRequest;
import br.com.prime.service.FuncionarioService;

public class FuncionarioControllerTest {

	@InjectMocks
	private FuncionarioController controller;

	@Mock
	private FuncionarioService service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLista() throws FuncionarioException {

		Mockito.when(service.ListFuncionario()).thenReturn(mockRetorno());

		Response funcionario = controller.funcionario();
		assertNotNull(funcionario);
	}

	@Test
	public void testCadastrar() throws FuncionarioException, EnderecoException, ValidateException {

		Response funcionario = controller.cadastrarFuncionario(new FuncionarioRequest());
		assertEquals(201, funcionario.getStatus());
	}

	@Test
	public void testAlterar() throws Exception {

		Response funcionario = controller.alterarFuncionario(new FuncionarioRequest(), 1);
		assertEquals(200, funcionario.getStatus());
	}

	@Test(expected = Exception.class)
	public void testAlterarException() throws Exception {
		
		Exception ex = new Exception();
		Mockito.doThrow(ex.getClass()).when(service).alterarFuncionario(null, 1);
		controller.alterarFuncionario(null, 1);
	}

	@Test
	public void testDeletar() throws Exception {

		Response funcionario = controller.deletarFuncionario(1);
		assertEquals(200, funcionario.getStatus());
	}

	@Test(expected = Exception.class)
	public void testDeletarException() throws Exception {
		
		Exception ex = new Exception();
		Mockito.doThrow(ex.getClass()).when(service).deletarFuncionario(1);
		controller.deletarFuncionario(1);
		
	}

	@Test
	public void testBuscar() throws Exception {

		List<Funcionario> funcionario = controller.buscarFuncionario("Anderson", 27, 1);
		assertNotNull(funcionario);
	}

	@Test(expected = Exception.class)
	public void testBuscarException() throws Exception {

		Exception ex = new Exception();
		Mockito.doThrow(ex.getClass()).when(service).buscarFuncionario("nome", 20, 1);
		controller.buscarFuncionario("nome", 20, 1);
	}

	private List<Funcionario> mockRetorno() {

		List<Funcionario> lista = new ArrayList<>();
		Funcionario funcionario;
		for (int i = 0; i < 5; i++) {
			funcionario = new Funcionario();
			funcionario.setCodigoPessoa(1 + i);
			funcionario.setCpf("3604782481" + i);
			funcionario.setEndereco(new Endereco());
			funcionario.setIdade(22 + i);
			funcionario.setNome("Victor" + i);
			funcionario.setProfissoes(new Profissoes(1, "Java", 1800.0));
			funcionario.setSobrenome("Teste" + i);
			lista.add(funcionario);
		}
		return lista;
	}

}
