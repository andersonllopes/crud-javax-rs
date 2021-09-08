package br.com.prime.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.prime.controller.FuncionarioController;
import br.com.prime.dao.BancoEmpresa;
import br.com.prime.exception.FuncionarioException;
import br.com.prime.model.Endereco;
import br.com.prime.model.Funcionario;
import br.com.prime.model.Profissoes;

public class FuncionarioServiceTest {
	
	@InjectMocks
	private FuncionarioController funcionarioController;
	
	@Mock
	private FuncionarioService funcionarioService;
	
	@Mock
	private BancoEmpresa bancoEmpresa;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testListFuncionario() throws FuncionarioException {
		
		Mockito.when(bancoEmpresa.listaFuncionarioBanco()).thenReturn(mockRetorno());
		
		List<Funcionario> listaTeste = funcionarioService.ListFuncionario();
		
		equals(listaTeste.get(1).getCodigoPessoa());
		
	}

	private List<Funcionario> mockRetorno() {
		
		List<Funcionario> listaFuncionario = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			Funcionario lista = new Funcionario();

			lista.setCodigoPessoa(1);
			lista.setCpf("018.664.132-56");
			lista.setEndereco(new Endereco());
			lista.setIdade(20);
			lista.setNome("Anderson");
			lista.setProfissoes(new Profissoes());
			lista.setSobrenome("Lopes");

			listaFuncionario.add(lista);
		}

		return listaFuncionario;
	}

}
