/**
 * <b> UserVO.java
 * 
 * <br>
 * 
 *  Classe vo per il trasporto dei dati degli utenti.
 * 
 */
package it.clever.patterns.business.model;

import java.io.Serializable;

/**
 * 
 * @author 2Clever.IT
 *
 */
public class UserVO extends BaseVO implements Serializable {
	
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String email;
	private String codfisc;
	

	public UserVO() {
	}
	
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#getNome()
	 */
	public String getNome() {
		return nome;
	}

	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#setNome(java.lang.String)
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#getCognome()
	 */
	public String getCognome() {
		return cognome;
	}

	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#setCognome(java.lang.String)
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#getCodfisc()
	 */
	public String getCodfisc() {
		return codfisc;
	}

	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#setCodfisc(java.lang.String)
	 */
	public void setCodfisc(String codfisc) {
		this.codfisc = codfisc;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public void setEmail(String email) {
	this.email = email;
		
	}

	@Override
	public String toString() {
		return "UserVO [nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", codfisc=" + codfisc + "]";
	}

	
}
