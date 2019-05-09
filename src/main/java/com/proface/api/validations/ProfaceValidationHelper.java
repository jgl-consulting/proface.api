package com.proface.api.validations;

import com.proface.api.exceptions.customs.ProfaceDuplicatedIdException;
import com.proface.api.exceptions.customs.ProfaceNotExistingException;

public class ProfaceValidationHelper<NID> {

	protected void duplicatedId(NID nativeId) {
		throw new ProfaceDuplicatedIdException(String.format(
				ProfaceValidationMessage.DUPLICATED_ID, getEntityName(), nativeId));
	}
	
	protected void notExisting() {
		throw new ProfaceNotExistingException(String.format(ProfaceValidationMessage.NOT_EXISTING, getEntityName()));
	}
	
	protected String getEntityName() {
		return "Proface";
	}
	
}
