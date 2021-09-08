package br.com.prime.model.enums;

import lombok.Getter;

@Getter
public enum EnumProfissoes {

	ANALISTA_DE_SISTEMA(1, "Analista de Sistema"), DESENVOLVEDOR(2, "Desenvolvedor"), TESTER(3, "Tester");
	
	private int codigo;
	private String descricao;

	EnumProfissoes(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static String retornaDescricao(int codigo) {
		
		for (EnumProfissoes enumProfissoes : EnumProfissoes.values()) {
			if(enumProfissoes.getCodigo() == codigo) {
				return enumProfissoes.getDescricao();
			}
		}
		
		return null;
	}
	
}
