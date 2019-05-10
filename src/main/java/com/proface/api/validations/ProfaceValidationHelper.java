package com.proface.api.validations;

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
	 * Can be implemented if Children wants to validate new Entity an saved Entity
	 * @param entity
	 * @param repositoryEntity
	 */
	protected void compareEntity(E entity, E repositoryEntity) {
		
	}
	
	/**
	 * Returns Entity name
	 * Usage: In validation messages
	 * @return
	 */
	protected String getEntityName() {
		return "Proface";
	}
	
}
