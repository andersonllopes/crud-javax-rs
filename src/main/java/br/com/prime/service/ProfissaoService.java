package br.com.prime.service;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.prime.dao.BancoEmpresa;
import br.com.prime.model.TipoProfissao;

@ApplicationScoped
public class ProfissaoService {
	
	@Inject
	private BancoEmpresa bancoEmpresa;

	public Collection<TipoProfissao> listProfissoes() {
		return bancoEmpresa.getlistaProfissao();
	}
}
