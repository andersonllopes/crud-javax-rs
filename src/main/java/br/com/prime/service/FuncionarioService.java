package br.com.prime.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.prime.dao.BancoEmpresa;
import br.com.prime.exception.EnderecoException;
import br.com.prime.exception.FuncionarioException;
import br.com.prime.exception.ValidateException;
import br.com.prime.model.Endereco;
import br.com.prime.model.Funcionario;
import br.com.prime.model.Profissoes;
import br.com.prime.model.enums.EnumProfissoes;
import br.com.prime.model.request.FuncionarioRequest;
import br.com.prime.utils.Util;

@ApplicationScoped
public class FuncionarioService {

	private static int sequence = 1;

	@Inject
	private BancoEmpresa bancoEmpresa;

	@Inject
	private Validator validator;

	public List<Funcionario> ListFuncionario() throws FuncionarioException {
		return bancoEmpresa.getlistaFuncionario();
	}

	public void cadastrarFuncionario(FuncionarioRequest request)
			throws FuncionarioException, EnderecoException, ValidateException {
		this.validator.validate(request);
		if (EnumProfissoes.retornaDescricao(request.getCodigoProfissao()).isEmpty()) {
			throw new FuncionarioException("Codigo Profissao Invalido.");
		}
		if (validaCPF(request)) throw new FuncionarioException("CPF Invalido.");  {
		}
		this.validaCep(request.getCep());
		Endereco endereco = conexao(request);
		bancoEmpresa.adicionar(new Funcionario(sequence += 1, request.getNome(), request.getSobrenome(),
				request.getIdade(), request.getCpf(),
				new Profissoes(request.getCodigoProfissao(),
						EnumProfissoes.retornaDescricao(request.getCodigoProfissao()), request.getSalario()),
				endereco));
	}

	public void alterarFuncionario(FuncionarioRequest funcionario, int id) throws Exception {

		for (int i = 0; i < bancoEmpresa.getlistaFuncionario().size(); i++) {
			Funcionario altera = bancoEmpresa.getlistaFuncionario().get(i);
			if (altera.getCodigoPessoa() == id) {
				altera.setNome(funcionario.getNome()).setSobrenome(funcionario.getSobrenome())
						.setIdade(funcionario.getIdade())
						.setProfissoes(new Profissoes(funcionario.getCodigoProfissao(),
								EnumProfissoes.retornaDescricao(funcionario.getCodigoProfissao()),
								funcionario.getSalario()));
			}
		}
	}

	public void deletarFuncionario(int id) throws Exception {

		for (int i = 0; i < bancoEmpresa.getlistaFuncionario().size(); i++) {
			Funcionario deleta = bancoEmpresa.getlistaFuncionario().get(i);
			if (deleta.getCodigoPessoa() == id) {
				bancoEmpresa.remover(deleta);
			}
		}
	}

	public List<Funcionario> buscarFuncionario(String nome, int idade, int codProfissao) throws Exception {

		List<Funcionario> lista = new ArrayList<>();

		for (int i = 0; i < bancoEmpresa.getlistaFuncionario().size(); i++) {
			Funcionario funcionario = bancoEmpresa.getlistaFuncionario().get(i);
			if (funcionario.getNome().equals(nome)) {
				lista.add(funcionario);
			}
			if (funcionario.getIdade() == idade) {
				lista.add(funcionario);
			}
			if (funcionario.getProfissoes().getCodigoProfissao() == codProfissao) {
				lista.add(funcionario);
			}
		}
		return lista;
	}

	private Endereco conexao(FuncionarioRequest request) throws EnderecoException {

		String webService = "http://viacep.com.br/ws/";
		int codigoSucesso = 200;
		String urlParaChamada = webService + request.getCep() + "/json";

		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != codigoSucesso)
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

			BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream(), "utf-8"));
			String jsonEmString = Util.converteJsonEmString(resposta);

			ObjectMapper mapper = new ObjectMapper();
			Endereco endereco = mapper.readValue(jsonEmString, Endereco.class);
			endereco.setNumero(request.getNumero());
			return endereco;

		} catch (Exception e) {
			throw new EnderecoException("ERRO: " + e);
		}
	}

	public boolean validate(Object obj) throws ValidateException {
		Set<ConstraintViolation<Object>> violations = new HashSet<>();
		violations.addAll(this.validator.validate(obj));
		if (!violations.isEmpty()) {
			throw new ValidateException(violations);
		}
		return true;
	}

	public boolean validaCep(String cep) throws ValidateException {
		if (cep.equals("99999999") || cep.equals("99999-999")) {
			throw new ValidateException("CEP invalido");
		}
		return true;
	}

	private static boolean validaCPF(FuncionarioRequest request) throws ValidateException {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (request.getCpf().equals("00000000000") || request.getCpf().equals("11111111111")
				|| request.getCpf().equals("22222222222") || request.getCpf().equals("33333333333")
				|| request.getCpf().equals("44444444444") || request.getCpf().equals("55555555555")
				|| request.getCpf().equals("66666666666") || request.getCpf().equals("77777777777")
				|| request.getCpf().equals("88888888888") || request.getCpf().equals("99999999999")
				|| (request.getCpf().length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (request.getCpf().charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (request.getCpf().charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == request.getCpf().charAt(9)) && (dig11 == request.getCpf().charAt(10)))
				return (true);
			else
				return (false);
		} catch (Exception erro) {
			return false;
		}
	}
}
