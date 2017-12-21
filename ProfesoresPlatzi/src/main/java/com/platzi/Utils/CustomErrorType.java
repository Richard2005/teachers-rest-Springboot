package com.platzi.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomErrorType {
	
	private String errorMessage;
	private HttpStatus status;
	
	public CustomErrorType(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
