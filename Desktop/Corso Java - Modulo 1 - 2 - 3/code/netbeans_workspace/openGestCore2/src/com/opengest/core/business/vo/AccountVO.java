/**
 * <b> AccountVO.java
 * 
 * <br>
 * 
 *  Classe vo per il trasporto dei dati legati all'account.
 * 
 */
package com.opengest.core.business.vo;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class AccountVO {

	private String username;
	private String password;
	private String email;
	private String risposta;
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRisposta() {
		return risposta;
	}
	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}
	
	
}
