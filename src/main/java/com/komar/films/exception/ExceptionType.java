package com.komar.films.exception;

public enum ExceptionType {
	DIRECTOR_NOT_FOUND(
			"Director is not found by id"
	),
	FILM_NOT_FOUND(
			"Film is not found by id"
	);

	private final String message;

	ExceptionType(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
