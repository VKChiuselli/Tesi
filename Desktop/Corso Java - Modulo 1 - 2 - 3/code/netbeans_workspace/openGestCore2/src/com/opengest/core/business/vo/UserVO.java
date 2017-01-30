/**
 * <b> UserVO.java
 * 
 * <br>
 * 
 *  Classe vo per il trasporto dei dati degli utenti.
 * 
 */
package com.opengest.core.business.vo;

import java.io.Serializable;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class UserVO implements Serializable, IUser {
	
	private Long id;
	private AccountVO account;
	private IndirizzoVO residenza;
	private IndirizzoVO domicilio;
	private String nome;
	private String cognome;
	private String codfisc;
	

	public UserVO() {
		this.account = new AccountVO();
		this.residenza = new IndirizzoVO();
		this.domicilio = new IndirizzoVO();
	}
	
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#getId()
	 */
	public Long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#getAccount()
	 */
	public AccountVO getAccount() {
		return account;
	}

	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#setAccount(com.opengest.core.business.vo.AccountVO)
	 */
	public void setAccount(AccountVO account) {
		this.account = account;
	}

	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#getResidenza()
	 */
	public IndirizzoVO getResidenza() {
		return residenza;
	}

	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#setResidenza(com.opengest.core.business.vo.IndirizzoVO)
	 */
	public void setResidenza(IndirizzoVO residenza) {
		this.residenza = residenza;
	}

	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#getDomicilio()
	 */
	public IndirizzoVO getDomicilio() {
		return domicilio;
	}

	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IUser#setDomicilio(com.opengest.core.business.vo.IndirizzoVO)
	 */
	public void setDomicilio(IndirizzoVO domicilio) {
		this.domicilio = domicilio;
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
