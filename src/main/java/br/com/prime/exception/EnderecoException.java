package br.com.prime.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

public class EnderecoException extends Exception{

	private static final long serialVersionUID = 7095366859780209381L;
	
	private final transient List<String> messages = new ArrayList<String>();

	public EnderecoException() {
		super();
	}

	public EnderecoException(String msg) {
		super(msg);
		messages.add(msg);
	}

	public EnderecoException(Set<ConstraintViolation<Object>> violations) {
		super();
		for (ConstraintViolation<Object> constraint : violations) {
			this.messages.add(constraint.getMessage());
		}
	}

	public List<String> getMessages() {
		return messages;
	}
}
