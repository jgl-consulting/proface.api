package com.proface.api.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return handleExceptionInternal(ex, methodArgumentNotValidExceptionEntity(ex), headers, HttpStatus.BAD_REQUEST,
				request);
	}

	private Object methodArgumentNotValidExceptionEntity(MethodArgumentNotValidException ex) {
		ProfaceError error = new ProfaceError();
		error.setCode(ProfaceErrorCode.ARGUMENT_NOT_VALID);
		error.setMessage("Argumentos no válidos.");
		List<ProfaceError.ProfaceSingleError> errors = new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach(e -> {
			String errorMessage = e.getDefaultMessage();
			String stackTrace = e.toString();
			errors.add(error.new ProfaceSingleError(errorMessage, stackTrace));
		});
		error.setErrors(errors);
		return error;
	}

}
