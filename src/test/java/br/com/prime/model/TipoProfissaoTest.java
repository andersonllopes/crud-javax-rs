package br.com.prime.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TipoProfissaoTest {

	@Test
	public void testClassTipoProfissao() {
		
		TipoProfissao tipo = mockRetorno();
		
		assertNotNull(tipo.getCodigo());
		assertNotNull(tipo.getDescricao());
		
	}

	private TipoProfissao mockRetorno() {

		TipoProfissao teste = new TipoProfissao(1, "Profissao");
		teste.setCodigo(1);
		teste.setDescricao("Profissao");
		return teste;
	}

}
