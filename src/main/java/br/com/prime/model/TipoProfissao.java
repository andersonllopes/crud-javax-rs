package br.com.prime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoProfissao {
	
	@JsonProperty
	private Integer codigo;
	@JsonProperty
	private String descricao;
}
