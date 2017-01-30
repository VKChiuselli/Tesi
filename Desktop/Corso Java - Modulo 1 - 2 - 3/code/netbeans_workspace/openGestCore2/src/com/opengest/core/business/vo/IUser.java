package com.opengest.core.business.vo;

public interface IUser {

	public abstract Long getId();

	public abstract AccountVO getAccount();

	public abstract void setAccount(AccountVO account);

	public abstract IndirizzoVO getResidenza();

	public abstract void setResidenza(IndirizzoVO residenza);

	public abstract IndirizzoVO getDomicilio();

	public abstract void setDomicilio(IndirizzoVO domicilio);

	public abstract void setId(Long id);

	public abstract String getNome();

	public abstract void setNome(String nome);

	public abstract String getCognome();

	public abstract void setCognome(String cognome);

	public abstract String getCodfisc();

	public abstract void setCodfisc(String codfisc);

}