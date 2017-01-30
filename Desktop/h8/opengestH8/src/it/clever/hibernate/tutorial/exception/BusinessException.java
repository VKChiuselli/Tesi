/**
 * <b> BusinessException.java
 * 
 * <br>
 * 
 *  Classe per la gestione delle eccezioni dei metodi di business.
 * 
 */
package it.clever.hibernate.tutorial.exception;

/**
 * @author 2Clever.IT
 *
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String businessName;

	public BusinessException(String businessName) {
		this.businessName = businessName;
	}

	public BusinessException(String businessName, String message) {
		super(message);
		this.businessName = businessName;
	}

	public BusinessException(String businessName, Throwable cause) {
		super(cause);
		this.businessName = businessName;
	}

	public BusinessException(String businessName, String message, Throwable cause) {
		super(message, cause);
		this.businessName = businessName;
	}

	public String getBusinessName() {
		return businessName;
	}

}
