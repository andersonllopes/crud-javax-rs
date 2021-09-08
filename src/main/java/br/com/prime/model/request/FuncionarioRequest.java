package br.com.prime.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class FuncionarioRequest implements Serializable{

	private static final long serialVersionUID = 2630932567750910885L;
	
	@NotEmpty(message = "Preencha o campo nome.")
	@JsonProperty
	String nome;
	
	@NotEmpty(message = "Preencha o campo sobrenome.")
	@JsonProperty
	String sobrenome;
	
	@NotNull(message = "Preencha o campo idade.")
	@JsonProperty
	Integer idade;
	
	@NotNull(message = "Preencha o campo salario.")
	@JsonProperty
	Double salario;
	
	@NotEmpty(message = "Preencha o campo cpf.")
	String cpf;
	
	@NotNull(message = "Preencha o campo codigoProfissao.")
	@JsonProperty
	Integer codigoProfissao;
	
	@NotEmpty(message = "Preencha o campo cep.")
	@JsonProperty
	String cep;
	
	@NotNull(message = "Preencha o campo cep.")
	@JsonProperty
	Integer numero;
}
