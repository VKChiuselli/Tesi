package it.clever.spring.tutorial.business.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


	@Entity
	@Table(name = "province")
	@Cacheable
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public class District extends BaseEntity implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_provincia", unique = true, nullable = false)
	private Integer idProvincia;
	
	@ManyToOne(fetch = FetchType.LAZY  )
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "id_regione")
	private Department department;
	
	@Column(name = "codice", nullable = false, length = 45)
	private String codice;
	
	@Column(name = "nome_citta", nullable = false, length = 45)
	private String nomeCitta;

/*
 	// Rende bidierzionale la relazione Many-To-One.
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address.district")
	private Set<User> utentis = new HashSet<User>(0);
*/
	public District() {
	}

	public District(Department department, String codice, String nomeCitta) {
		this.department = department;
		this.codice = codice;
		this.nomeCitta = nomeCitta;
	}


	public Integer getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNomeCitta() {
		return this.nomeCitta;
	}

	public void setNomeCitta(String nomeCitta) {
		this.nomeCitta = nomeCitta;
	}

	@Override
	public String toString() {
		return "District [idProvincia=" + idProvincia + ", codice=" + codice
				+ ", nomeCitta=" + nomeCitta + "]";
	}

}
