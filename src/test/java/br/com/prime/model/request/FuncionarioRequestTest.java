package br.com.prime.model.request;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class FuncionarioRequestTest {

	@Test
	public void testClassFuncionarioRequest() {
		
		FuncionarioRequest request = mockRetorno();
		
		assertNotNull(request.getCep());
		assertNotNull(request.getCodigoProfissao());
		assertNotNull(request.getIdade());
		assertNotNull(request.getNome());
		assertNotNull(request.getNumero());
		assertNotNull(request.getSalario());
		assertNotNull(request.getSobrenome());
	}

	private FuncionarioRequest mockRetorno() {

		FuncionarioRequest request = new FuncionarioRequest();
		
		request.setNome("Teste");
		request.setSobrenome("Teste");
		request.setIdade(20);
		request.setCodigoProfissao(1);
		request.setCep("06420130");
		request.setNumero(30);
		request.setSalario(3000.0);
		request.setCpf("018.444.222-32");
		
		return request;
	}

}
