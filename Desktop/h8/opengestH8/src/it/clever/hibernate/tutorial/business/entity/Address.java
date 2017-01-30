package it.clever.hibernate.tutorial.business.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Parent;


@Embeddable
public class Address {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_provincia")
	private District district;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_regione")
	private Department department;
	
	@Column(name = "citta", length = 45)
	private String citta;

	@Column(name = "via", length = 100)
	private String via;

	@Column(name = "numero", length = 45)
	private String numero;

	@Column(name = "nazione", length = 45)
	private String nazione;

	@Column(name = "codice_postale")
	private Integer codicePostale;

	/**
	 * Hibernate permette di avere un riferimento all'Entity padre 
	 * e costruisce in esso l'oggetto avendo di fatto un riferimento circolare. 
	 * E' necessario provvedere ai rispettivi getter e setter.
	 */
	@Parent	private User user;
	
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public Integer getCodicePostale() {
		return codicePostale;
	}

	public void setCodicePostale(Integer codicePostale) {
		this.codicePostale = codicePostale;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
