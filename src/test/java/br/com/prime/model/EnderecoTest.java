package br.com.prime.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class EnderecoTest {

	@Test
	public void testClassEndereco() {

		Endereco endereco = mockRetorno();
		
		assertNotNull(endereco);
		assertNotNull(endereco.getCep());
		assertNotNull(endereco.getLogradouro());
		assertNotNull(endereco.getComplemento());
		assertNotNull(endereco.getBairro());
		assertNotNull(endereco.getLocalidade());
		assertNotNull(endereco.getUf());
		assertNotNull(endereco.getIbge());
		assertNotNull(endereco.getGia());
		assertNotNull(endereco.getDdd());
		assertNotNull(endereco.getSiafi());
		assertNotNull(endereco.getNumero());
		assertEquals(true, endereco.equals(mockRetorno()));
		assertNotEquals(endereco.hashCode(), new Endereco().hashCode());
		assertEquals(true, endereco.equals(endereco));
		assertEquals(false, endereco.equals(null));
		assertEquals(false, endereco.equals(endereco.getClass()));
		assertEquals(true, endereco.equals(endereco));
		endereco.setBairro(null);
		assertEquals(false, endereco.equals(mockRetorno()));
		
	}

	private Endereco mockRetorno() {
		
		Endereco endereco = new Endereco();
		
		endereco.setCep("01001-000");
		endereco.setLogradouro("Praça");
		endereco.setComplemento("lado");
		endereco.setBairro("Sé");
		endereco.setLocalidade("São Paulo");
		endereco.setUf("SP");
		endereco.setIbge("3550308");
		endereco.setGia("1004");
		endereco.setDdd("11");
		endereco.setSiafi("7107");
		endereco.setNumero(10);
		
		return endereco;
	}
}
