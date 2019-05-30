package com.proface.api.util;

import com.proface.api.exceptions.customs.ProfaceDuplicatedIdException;
import com.proface.api.exceptions.customs.ProfaceNotExistingException;

/**
 * 
 * @author josec
 * This Class manages custom Validations
 * @param <NID>	Optional: Native ID of Entity
 */
public class ProfaceValidationHelper<E, NID> {

	/**
	 * Must be implemented by Children Classes
	 * All code must be above the call to super
	 * @param nativeId
	 */
	protected void duplicatedId(NID nativeId) {
		throw new ProfaceDuplicatedIdException(String.format(
				ProfaceValidationMessage.DUPLICATED_ID, getEntityName(), nativeId));
	}
	
	/**
	 * Must be implemented by Children Classes
	 * All code must be above the call to super
	 * @param nativeId
	 */
	protected void notExisting() {
		throw new ProfaceNotExistingException(String.format(ProfaceValidationMessage.NOT_EXISTING, getEntityName()));
	}
	
	/**
	 * Returns Entity name
	 * Usage: In validation messages
	 * @return
	 */
	protected String getEntityName() {
		return "Proface";
	}
	

	/**
	 * Filters the Entity before returning Usage: If Childrens of this calss needs
	 * it
	 */
	protected void filterEntity(E entity) {

	}

	/**
	 * Compares incoming entity with persisted entity
	 */
	protected void compareEntity(E entity, E repositoryEntity) {

	}

	/**
	 * Prepares the Entity before persisting
	 * 
	 * @param entity
	 */
	protected void prepareEntity(E entity) {

	}
	
	/**
	 * Sets an ID from Entity
	 * @param entity
	 * @return
	 */
	protected void setId(E entity) {
		
	}
	
}
