/**
 * <b> UserVO.java
 * 
 * <br>
 * 
 *  Classe vo per il trasporto dei dati degli utenti.
 * 
 */
package it.clever.testapp.tomcat.business.model;

import java.io.Serializable;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class UserVO implements Serializable {
	
	private Long id;
	private String nome;
	private String cognome;
	private String codfisc;
	

	public UserVO() {
	}
	
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#getId()
	 */
	public Long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#setId(java.lang.Long)
	 */
	public void setId(Long id) {
		this.id = id;
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

}
