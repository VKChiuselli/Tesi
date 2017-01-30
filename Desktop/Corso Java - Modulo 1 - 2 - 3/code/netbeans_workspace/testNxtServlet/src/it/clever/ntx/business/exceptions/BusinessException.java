/**
 * <b> BusinessException.java
 * 
 * <br>
 *  *
 * robgion
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 * 
 * Classe per la gestione delle eccezioni dei metodi di business.
 * 
 */
package it.clever.ntx.business.exceptions;

/**
 * @author robgion
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
