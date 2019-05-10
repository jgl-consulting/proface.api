package com.proface.api.exceptions;

public enum ProfaceExceptionCode {

	/**
	 * Exception Code for Errors in Validation of an Entity
	 */
	ENTITY_VALIDATION_ERROR, 
	/**
	 * Exception Code for an Entity which already exists
	 */
	DUPLICATED_ID_ERROR, 
	/**
	 * Exception Code for an Entity which doesn't exists
	 */
	NOT_EXISTING_ERROR, 
	/**
	 * Exception Code for Errors in SQL Database
	 */
	SQL_ERROR, 
	/**
	 * Exception Code for Errors in JPA
	 */
	DATA_ACCESS_ERROR, 
	/**
	 * Exception Code for Errors in SQL Constraints
	 */
	SQL_VALIDATION_ERROR, 
	/**
	 * Exception Code for Errors uncontrolled
	 */
	GENERAL_ERROR

}