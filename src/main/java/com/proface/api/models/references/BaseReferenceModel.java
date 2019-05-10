package com.proface.api.models.references;

import javax.validation.constraints.Positive;

import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author josec
 * This class abstracts the Model only used from Reference
 * Validates only the existence of ID
 * @param <ID>	Primary Key of Entity
 */
@Data
@NoArgsConstructor
public class BaseReferenceModel {

	/**
	 * Must be a number > 0
	 */
	@Positive(message = ProfaceValidationMessage.POSITIVE)
	private int id;
	
}
