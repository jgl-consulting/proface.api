package com.proface.api.util;

/**
 * This Class has Messages used to export Errors to API Clients
 * @author josec
 *
 */
public abstract class ProfaceValidationMessage {

	public final static String DUPLICATED_ID = "La entidad %s con el campo único %s ya ha sido registrada anteriormente.";
	
	public final static String NOT_EXISTING = "La entidad %s no ha sido registrado anteriormente.";
	
	public final static String NOT_NULL_BLANK = "El campo %s de la entidad %s no debe ser vacío.";
	
	public final static String NOT_EMPTY = "El campo %s de la entidad %s debe tener al menos un elemento.";
	
	public final static String EMAIL = "El campo %s de la entidad %s debe tener formato de correo.";
	
	public final static String POSITIVE = "El campo %s de la entidad %s debe ser un número positivo.";	
	
	public final static String PAST_PRESENT = "El campo %s de la entidad %s debe ser una fecha menor o igual al día actual.";
	
}