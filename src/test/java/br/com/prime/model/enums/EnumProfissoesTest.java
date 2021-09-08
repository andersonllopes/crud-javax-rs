package br.com.prime.model.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class EnumProfissoesTest {

	@Test
	public void testClassProfissoes() {

		assertEquals("Analista de Sistema", EnumProfissoes.retornaDescricao(1));
		assertEquals("Desenvolvedor", EnumProfissoes.retornaDescricao(2));
		assertEquals("Tester", EnumProfissoes.retornaDescricao(3));
		assertNull(EnumProfissoes.retornaDescricao(0));
	}
}
