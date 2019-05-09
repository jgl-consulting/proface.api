package com.proface.api.exceptions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
		return handleExceptionInternal(ex,
				profaceEntity(ex, ProfaceExceptionCode.ENTITY_VALIDATION_ERROR, "La entidad tiene campos no válidos."),
				headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { ProfaceDuplicatedIdException.class })
	public ResponseEntity<?> handleProfaceException(ProfaceDuplicatedIdException ex, WebRequest request) {
		return handleExceptionInternal(ex,
				profaceEntity(ex, ProfaceExceptionCode.DUPLICATED_ID_ERROR,
						"El identificador de la entidad ya ha sido registrado."),
				new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { ProfaceNotExistingException.class })
	public ResponseEntity<?> handleProfaceException(ProfaceNotExistingException ex, WebRequest request) {
		return handleExceptionInternal(ex,
				profaceEntity(ex, ProfaceExceptionCode.NOT_EXISTING_ERROR,
						"La entidad no ha sido registrada anteriormente."),
				new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(value = { SQLException.class })
	public ResponseEntity<?> handleSQLException(SQLException ex, WebRequest request) {
		return handleExceptionInternal(ex,
				profaceEntity(ex, ProfaceExceptionCode.SQL_ERROR, "Ha ocurrido un error en la base de datos."),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	@ExceptionHandler(value = { DataAccessException.class })
	public ResponseEntity<?> handleDAOException(DataAccessException ex, WebRequest request) {
		return handleExceptionInternal(ex,
				profaceEntity(ex, ProfaceExceptionCode.DATA_ACCESS_ERROR, "Ha ocurrido un error de acceso a datos."),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	@ExceptionHandler(value = { ValidationException.class })
	public ResponseEntity<?> handleValidationException(ValidationException ex, WebRequest request) {
		return handleExceptionInternal(ex,
				profaceEntity(ex, ProfaceExceptionCode.SQL_VALIDATION_ERROR,
						"Ha ocurrido un error en la validación de base de datos."),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request) {
		return handleExceptionInternal(ex,
				profaceEntity(ex, ProfaceExceptionCode.GENERAL_ERROR, "Ha ocurrido un error no controlado."),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	private Object profaceEntity(Exception ex, ProfaceExceptionCode code, String message) {
		return buildProfaceException(code, message, new ProfaceSingleException(ex.getMessage(), ex.toString()));
	}

	private Object profaceEntity(SQLException ex, ProfaceExceptionCode code, String message) {
		return buildProfaceException(code, message,
				new ProfaceSingleException(String.format("Code: %d - State: %s - Message: %s.", ex.getErrorCode(),
						ex.getSQLState(), ex.getMessage()), ex.toString()));
	}

	private Object profaceEntity(RuntimeException ex, ProfaceExceptionCode code, String message) {
		return buildProfaceException(code, message, new ProfaceSingleException(ex.getMessage(), ex.toString()));
	}

	private Object profaceEntity(MethodArgumentNotValidException ex, ProfaceExceptionCode code, String message) {
		List<ProfaceSingleException> errors = new ArrayList<>();
		BindingResult binding = ex.getBindingResult();
		for (int i = 0; i < binding.getErrorCount(); i++) {
			ObjectError e = binding.getAllErrors().get(i);
			FieldError f = binding.getFieldErrors().get(i);
			errors.add(new ProfaceSingleException(String.format(e.getDefaultMessage(), f.getField(), f.getObjectName()),
					e.toString()));
		}
		return new ProfaceExceptionEntity(code, message, errors);
	}

	private ProfaceExceptionEntity buildProfaceException(ProfaceExceptionCode code, String message,
			ProfaceSingleException ex) {
		return new ProfaceExceptionEntity(code, message, ex);
	}
}