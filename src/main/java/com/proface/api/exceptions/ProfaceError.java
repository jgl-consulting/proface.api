package com.proface.api.exceptions;

import java.util.List;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
public class ProfaceError {

	private ProfaceErrorCode code;
	private String message;	
	private List<ProfaceSingleError> errors;
	
	@Data
	@RequiredArgsConstructor
	class ProfaceSingleError {
		
		@NonNull
		private String errorMessage;

		@NonNull
		private String stackTrace;
	
	}
	
}
