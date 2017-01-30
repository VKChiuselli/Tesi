package com.opengest.core.business.dto;

import java.io.Serializable;

import com.opengest.core.business.vo.IUser;
import com.opengest.core.business.vo.UserVO;

public class UserDTO  implements Serializable {

	private IUser userBean;

	private Long id;
	private String nome;
	private String cognome;
	private String codfisc;
	private String username;
	private String password;
	private String email;
	
	private int page;
	
	public UserDTO() {
		this.userBean = new UserVO();
	}
	
	
	public UserDTO(IUser userBean) {
		this.userBean = userBean;
		this.id = this.userBean.getId();
		this.email = this.userBean.getAccount().getEmail();
		this.password = this.userBean.getAccount().getPassword();
		this.username = this.userBean.getAccount().getUsername();
		this.codfisc = this.userBean.getCodfisc();
		this.cognome = this.userBean.getCognome();
		this.nome = this.userBean.getNome();		
	}
	
	
	public IUser getUserBean() {
		return populateVO();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodfisc() {
		return codfisc;
	}

	public void setCodfisc(String codfisc) {
		this.codfisc = codfisc;
	}

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
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}


	public IUser populateVO() {
		this.userBean.getAccount().setPassword(password);
		this.userBean.getAccount().setEmail(email);
		this.userBean.getAccount().setPassword(password);
		this.userBean.getAccount().setUsername(username);
		this.userBean.setCodfisc(codfisc);
		this.userBean.setCognome(cognome);
		this.userBean.setNome(nome);
		return this.userBean;
	}
}
