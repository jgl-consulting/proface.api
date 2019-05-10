package com.proface.api.exceptions;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProfaceSingleException {
	
	/**
	 * Single Error message
	 */
	@NonNull
	private String errorMessage;

	/**
	 * Traceability of Error
	 */
	@NonNull
	private String stackTrace;
}
