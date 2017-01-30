package it.clever.opengest.exceptions;

public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private final String username;

	public UserAlreadyExistsException(String username) {
		this.username = username;
	}

	public UserAlreadyExistsException(String username, String message) {
		super(message);
		this.username = username;
	}

	public UserAlreadyExistsException(String username, Throwable cause) {
		super(cause);
		this.username = username;
	}

	public UserAlreadyExistsException(String username, String message, Throwable cause) {
		super(message, cause);
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}
