package com.proface.api.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.proface.api.exceptions.customs.ProfaceDuplicatedIdException;
import com.proface.api.exceptions.customs.ProfaceNotExistingException;

@ControllerAdvice
public class ProfaceExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ProfaceExceptionCode code = ProfaceExceptionCode.NOT_VALID;
		String message = "La entidad no es válida.";
		return handleExceptionInternal(ex, profaceEntity(ex, code, message), headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { ProfaceDuplicatedIdException.class })
	public ResponseEntity<?> handleProfaceException(ProfaceDuplicatedIdException ex, WebRequest request) {
		ProfaceExceptionCode code = ProfaceExceptionCode.DUPLICATED_ID;
		String message = "El identificador de la entidad ya ha sido registrado.";
		return handleExceptionInternal(ex, profaceEntity(ex, code, message), new HttpHeaders(), HttpStatus.BAD_REQUEST,
				request);
	}

	@ExceptionHandler(value = { ProfaceNotExistingException.class })
	public ResponseEntity<?> handleProfaceException(ProfaceNotExistingException ex, WebRequest request) {
		ProfaceExceptionCode code = ProfaceExceptionCode.NOT_EXISTING;
		String message = "La entidad ya ha sido registrada.";
		return handleExceptionInternal(ex, profaceEntity(ex, code, message), new HttpHeaders(), HttpStatus.NOT_FOUND,
				request);
	}

	private Object profaceEntity(RuntimeException ex, ProfaceExceptionCode code, String message) {
		ProfaceExceptionEntity error = new ProfaceExceptionEntity();
		error.setCode(code);
		error.setMessage(message);
		String errorMessage = ex.getMessage();
		String stackTrace = ex.toString();
		List<ProfaceExceptionEntity.ProfaceSingleException> errors = new ArrayList<>();
		errors.add(error.new ProfaceSingleException(errorMessage, stackTrace));
		error.setErrors(errors);
		return error;
	}

	private Object profaceEntity(MethodArgumentNotValidException ex, ProfaceExceptionCode code, String message) {
		ProfaceExceptionEntity error = new ProfaceExceptionEntity();
		error.setCode(code);
		error.setMessage(message);
		List<ProfaceExceptionEntity.ProfaceSingleException> errors = new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach(e -> {
			String errorMessage = e.getDefaultMessage();
			String stackTrace = e.toString();
			errors.add(error.new ProfaceSingleException(errorMessage, stackTrace));
		});
		error.setErrors(errors);
		return error;
	}
}