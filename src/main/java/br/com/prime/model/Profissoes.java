package br.com.prime.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Profissoes implements Serializable {

	private static final long serialVersionUID = 7110282349819338447L;
	
	@JsonProperty
	private Integer codigoProfissao;
	@JsonProperty
	private String descriProfissao;
	@JsonProperty
	private Double salario;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoProfissao == null) ? 0 : codigoProfissao.hashCode());
		result = prime * result + ((descriProfissao == null) ? 0 : descriProfissao.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissoes other = (Profissoes) obj;
		if (codigoProfissao == null) {
			if (other.codigoProfissao != null)
				return false;
		} else if (!codigoProfissao.equals(other.codigoProfissao))
			return false;
		if (descriProfissao == null) {
			if (other.descriProfissao != null)
				return false;
		} else if (!descriProfissao.equals(other.descriProfissao))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}
}
