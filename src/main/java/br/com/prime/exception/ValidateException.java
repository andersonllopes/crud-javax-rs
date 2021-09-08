package br.com.prime.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.ConstraintViolation;

@ApplicationScoped
public class ValidateException extends Exception {

	private static final long serialVersionUID = 2163653564356754185L;
	
	private final transient List<String> messages = new ArrayList<String>();
	
	public ValidateException() {
		super();
	}
	
	public ValidateException(String msg) {
		super(msg);
		messages.add(msg);
	}

	public ValidateException(Set<ConstraintViolation<Object>> violations) {
		super();
		for(ConstraintViolation<Object> constraint : violations) {
			this.messages.add(constraint.getMessage());
		}
	}
	
	public List<String > getMessages(){
		return messages;
	}
}
