package com.proface.api.exceptions.customs;

public class ProfaceInvalidStatusException extends RuntimeException {

	private static final long serialVersionUID = -9067386072326554334L;
	
	public ProfaceInvalidStatusException(String message) {
		super(message);
	}

}
