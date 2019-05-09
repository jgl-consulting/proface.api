package com.proface.api.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProfaceExceptionEntity {

	@NonNull
	private ProfaceExceptionCode code;

	private String timeStamp;

	@NonNull
	private String message;

	@NonNull
	private List<ProfaceSingleException> errors;

	public ProfaceExceptionEntity() {
		this.timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss"));
	}

	public ProfaceExceptionEntity(ProfaceExceptionCode code, String message, ProfaceSingleException error) {
		this.code = code;
		this.message = message;
		this.timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss"));
		setError(error);
	}

	public void setError(ProfaceSingleException ex) {
		if (this.errors != null)
			this.errors.add(ex);
		else {
			this.errors = new ArrayList<>();
			this.errors.add(ex);
		}
	}

}