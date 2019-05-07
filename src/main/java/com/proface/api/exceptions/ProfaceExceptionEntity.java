package com.proface.api.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
public class ProfaceExceptionEntity {
	
	private ProfaceExceptionCode code;
	
	private String timeStamp;
	
	private String message;	
	
	private List<ProfaceSingleException> errors;
	
	@Data
	@RequiredArgsConstructor
	class ProfaceSingleException {
		
		@NonNull
		private String errorMessage;

		@NonNull
		private String stackTrace;
	
	}
	
	public ProfaceExceptionEntity() {
		this.timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss"));
	}
	
}
