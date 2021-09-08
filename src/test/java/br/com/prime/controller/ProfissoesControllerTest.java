package br.com.prime.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.prime.model.TipoProfissao;
import br.com.prime.service.ProfissaoService;



public class ProfissoesControllerTest {
	
	@InjectMocks
	private ProfissoesController controller;

	@Mock
	private ProfissaoService service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	public void testProfissoes() {
		
		Mockito.when(service.listProfissoes()).thenReturn(mockRetorno());

		Collection<TipoProfissao> profissoes = controller.profissoes();
		assertNotNull(profissoes);
	}


	private Collection<TipoProfissao> mockRetorno() {
		
		Collection<TipoProfissao> lista = new ArrayList<>();
		TipoProfissao tipoProfissao = new TipoProfissao();
		for (int i = 0; i < 5; i++) {
			tipoProfissao.setCodigo(1);
			tipoProfissao.setDescricao("Analista");
		}
		return lista;
	}

}
