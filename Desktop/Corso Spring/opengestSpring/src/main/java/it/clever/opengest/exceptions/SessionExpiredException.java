package it.clever.opengest.exceptions;

public class SessionExpiredException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SessionExpiredException(String message) {
		super(message);
	}

	public SessionExpiredException(Throwable cause) {
		super(cause);
	}

	public SessionExpiredException(String message, Throwable cause) {
		super(message, cause);
	}

}
