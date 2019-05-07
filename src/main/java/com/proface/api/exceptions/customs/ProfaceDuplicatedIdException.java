package com.proface.api.exceptions.customs;

public class ProfaceDuplicatedIdException extends RuntimeException {

	private static final long serialVersionUID = -6831420744358941565L;
	
	public ProfaceDuplicatedIdException(String message) {
		super(message);
	}

}
