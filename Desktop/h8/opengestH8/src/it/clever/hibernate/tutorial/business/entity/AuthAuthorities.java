package it.clever.hibernate.tutorial.business.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "auth_authorities", catalog = "opengest")
public class AuthAuthorities implements java.io.Serializable {

	@Id
	@Column(name = "role_name", unique = true, nullable = false, length = 45)
	private String roleName;
	
	@Version
	@Column(name = "version")
	private Integer version;
	
	@Column(name = "role_desc", nullable = false, length = 45)
	private String roleDesc;
	
	@Column(name = "function_desc")
	private String functionDesc;
	
	@Column(name = "id")
	private Long id;
	
	/*
	 * Nel caso in cui si rende necessario gestire la navigazione della relazione
	 * in modalità bidirezionale:
	 * 
	 * 1. aggiungere la relazione @ManyToMany;
	 * 2. definire l'owner della relazione (in questo caso i gruppi:  mappedBy = "authAuthorities").
	 */
	@ManyToMany(
	        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
	        mappedBy = "authAuthorities",
	        targetEntity = AuthGroup.class
	)
	private List<AuthGroup> groups; 
	
	 
	public AuthAuthorities() {
	}

	public AuthAuthorities(String roleName, String roleDesc) {
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	public AuthAuthorities(String roleName, String roleDesc,
			String functionDesc, Long id) {
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.functionDesc = functionDesc;
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getFunctionDesc() {
		return this.functionDesc;
	}

	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<AuthGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<AuthGroup> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "AuthAuthorities [roleName=" + roleName + ", roleDesc="
				+ roleDesc + ", functionDesc=" + functionDesc + "]";
	}
}
