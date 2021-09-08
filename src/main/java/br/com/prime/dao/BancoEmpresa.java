package br.com.prime.dao;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.prime.exception.EnderecoException;
import br.com.prime.exception.FuncionarioException;
import br.com.prime.exception.ValidateException;
import br.com.prime.model.Funcionario;
import br.com.prime.model.TipoProfissao;
import br.com.prime.model.enums.EnumProfissoes;

@RequestScoped
public class BancoEmpresa {
	
	
	private static List<Funcionario> listaFuncionario = new ArrayList<>();

	public List<Funcionario> listaFuncionarioBanco() throws FuncionarioException {
		if(listaFuncionario.isEmpty()) {
			throw new FuncionarioException("Lista Vazia");
		}
		return listaFuncionario;
	}

	public List<Funcionario> getlistaFuncionario() throws FuncionarioException{
		return this.listaFuncionarioBanco();
	}

	public List<TipoProfissao> getlistaProfissao() {

		TipoProfissao tipo;
		List<TipoProfissao> lista = new ArrayList<>();

		for (EnumProfissoes tipoProfissao : EnumProfissoes.values()) {

			tipo = new TipoProfissao(tipoProfissao.getCodigo(), tipoProfissao.getDescricao());
			lista.add(tipo);
		}
		return lista;

	}

	public void adicionar(Funcionario funcionario) throws FuncionarioException, EnderecoException, ValidateException {
		if(listaFuncionario.contains(funcionario)) {
			throw new FuncionarioException("Já existe");
		}
		for (int i = 0; i < listaFuncionario.size(); i++) {
			Funcionario verificaCPF = listaFuncionario.get(i);
			if(verificaCPF.getCpf().equals(verificaCPF.getCpf())){
				throw new FuncionarioException("CPF já está cadastrado no banco de dados.");
			}
		}
		listaFuncionario.add(funcionario);
	}

	public void remover(Funcionario deleta) throws FuncionarioException {
		listaFuncionario.remove(deleta);
	}
}
