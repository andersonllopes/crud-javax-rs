package br.com.prime.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class FuncionarioTest {

	@Test
	public void testClassFuncionario() {
		
		Funcionario funcionario = mockRetorno();
		
		assertNotNull(funcionario);
		assertNotNull(funcionario.getCodigoPessoa());
		assertNotNull(funcionario.getNome());
		assertNotNull(funcionario.getSobrenome());
		assertNotNull(funcionario.getIdade());
		assertNotNull(funcionario.getEndereco());
		assertNotNull(funcionario.getProfissoes());
		assertEquals(true,funcionario.equals(new Funcionario(5, "Teo", "Silva", 20, "018.224.165-23", new Profissoes(), mockEndereco())));
		assertNotEquals(funcionario.hashCode(), new Funcionario().hashCode());
		assertNotNull(new Funcionario(1, "Nome", "sobrenome", 20, "018.224.165-23", new Profissoes(2, "Python", 5000.0), new Endereco()));
		
	}

	private Endereco mockEndereco() {
		Endereco endereco = new Endereco();
		endereco.setBairro("Sé");
		endereco.setCep("4352963");
		endereco.setComplemento("Rua");
		endereco.setDdd("12");
		endereco.setGia("A");
		endereco.setIbge("235415");
		endereco.setLocalidade("Local");
		endereco.setLogradouro("23");
		endereco.setNumero(24);
		endereco.setSiafi("B");
		endereco.setUf("SP");
		return endereco;
	}

	private Funcionario mockRetorno() {
		
		Funcionario teste = new Funcionario();
		Endereco endereco = new Endereco();
		
		endereco.setBairro("TI");
		endereco.setCep("432324");
		endereco.setComplemento("Rua a");
		endereco.setDdd("25");
		endereco.setGia("Z");
		endereco.setIbge("233535");
		endereco.setLocalidade("rua");
		endereco.setLogradouro("60");
		endereco.setNumero(30);
		endereco.setSiafi("D");
		endereco.setUf("RJ");
		
		teste.setCodigoPessoa(1);
		teste.setNome("Teo");
		teste.setSobrenome("Silva");
		teste.setIdade(20);
		teste.setCpf("018.224.165-23");
		teste.setEndereco(mockEndereco());
		teste.setProfissoes(new Profissoes());
		
		return teste;
	}

}
