package com.opengest.core.business.vo;

public interface IUser {

	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract String getNome();

	public abstract void setNome(String nome);

	public abstract String getCognome();

	public abstract void setCognome(String cognome);

	public abstract String getCodfisc();

	public abstract void setCodfisc(String codfisc);
	
	public abstract String getUsername();

	public abstract void setUsername(String username);
	
	public abstract String getPassword();

	public abstract void setPassword(String password);
	
	public abstract String getEmail();

	public abstract void setEmail(String email);	

}