package com.jason.ecommerce.exception;

public class UserError {
	private String errorMessage;

	public UserError(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
