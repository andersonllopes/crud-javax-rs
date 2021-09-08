package br.com.prime.dao;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.prime.controller.FuncionarioController;
import br.com.prime.controller.ProfissoesController;
import br.com.prime.service.FuncionarioService;
import br.com.prime.service.ProfissaoService;

public class BancoEmpresaTest {

	@InjectMocks
	private FuncionarioController funcionarioController;

	@Mock
	private ProfissoesController profissaoController;
	
	@Mock
	private FuncionarioService funcionarioService;
	
	@Mock
	private ProfissaoService profissaoService;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
}
