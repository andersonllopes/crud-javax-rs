package br.com.prime.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ProfissoesTest {

	@Test
	public void testClassProfissoes() {
		
		Profissoes profissao = mockRetorno();
		
		assertNotNull(profissao);
		assertNotNull(profissao.toString());
		assertNotNull(profissao.equals(new Profissoes()));
		assertNotEquals(profissao.hashCode(), new Profissoes().hashCode());
		assertNotNull(profissao.getCodigoProfissao());
		assertNotNull(profissao.getDescriProfissao());
		assertNotNull(profissao.getSalario());
		assertEquals(true, profissao.equals(mockRetorno()));
		
	}

	private Profissoes mockRetorno() {

		Profissoes teste = new Profissoes(1, "Analista", 4000.0);
		teste.setCodigoProfissao(1);
		teste.setDescriProfissao("Analista");
		teste.setSalario(4000.0);
		
		return teste;
	}
}
