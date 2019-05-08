package com.proface.api.exceptions;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProfaceSingleException {
	
	@NonNull
	private String errorMessage;

	@NonNull
	private String stackTrace;
}
