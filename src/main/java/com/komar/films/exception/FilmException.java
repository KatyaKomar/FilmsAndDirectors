package com.komar.films.exception;

public class FilmException extends Exception{
	public FilmException(String message) {
		super(message);
	}

	public FilmException(ExceptionType exceptionType) {
		super(exceptionType.getMessage());
	}
}
