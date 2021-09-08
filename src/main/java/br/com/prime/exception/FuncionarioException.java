package br.com.prime.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FuncionarioException extends Exception{

	private static final long serialVersionUID = -4736663918596871691L;
	
	private final transient List<String> messages = new ArrayList<>();
	
	
	public FuncionarioException(String msg) {
		super(msg);
		this.messages.add(msg);
	}
	
	public FuncionarioException(Set<ConstraintViolation<Object>> violations) {
		super();
		for (ConstraintViolation<Object> constraint : violations) {
			this.messages.add(constraint.getMessage());
		}
	}
	
	public List<String> getMessages(){
		return messages;
	}
}
