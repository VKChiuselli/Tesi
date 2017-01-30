package it.clever.hibernate.tutorial.business.entity;

// Generated 13-giu-2015 14.59.14 by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "regioni", catalog = "opengest")
public class Department extends BaseEntity implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_regione", unique = true, nullable = false)
	private Integer idRegione;
	
	@Column(name = "codice", nullable = false, length = 45)
	private String codice;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address.department")
	private Set<User> utentis = new HashSet<User>(0);
	
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "department")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Set<District> districts = new HashSet<District>(0);

	public Department() {
	}

	public Department(String codice) {
		this.codice = codice;
	}

	public Department(String codice, Set<User> utentis, Set<District> districts) {
		this.codice = codice;
		this.utentis = utentis;
		this.districts = districts;
	}

	public Integer getIdRegione() {
		return this.idRegione;
	}

	public void setIdRegione(Integer idRegione) {
		this.idRegione = idRegione;
	}

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Set<User> getUtentis() {
		return this.utentis;
	}

	public void setUtentis(Set<User> utentis) {
		this.utentis = utentis;
	}

	public Set<District> getProvinces() {
		return this.districts;
	}

	public void setProvinces(Set<District> districts) {
		this.districts = districts;
	}

}
