package com.proface.api.exceptions.customs;

public class ProfaceNotExistingException extends RuntimeException {

	private static final long serialVersionUID = -1814768112484809166L;

	public ProfaceNotExistingException(String message) {
		super(message);
	}
}
