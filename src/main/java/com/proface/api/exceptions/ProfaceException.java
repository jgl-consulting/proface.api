package com.proface.api.exceptions;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ProfaceException {

	@NonNull
	private ProfaceExceptionCode code;
	
	@NonNull
	private String message;	
	
	@NonNull
	private List<ProfaceSingleException> errors;
	
	@Data
	@RequiredArgsConstructor
	public class ProfaceSingleException {
		
		@NonNull
		private String errorMessage;

		@NonNull
		private String stackTrace;
	
	}
	
}
