package it.clever.spring.tutorial.business.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "utenti")
public class User extends BaseEntity implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_utente", unique = true, nullable = false)
	private Long idUtente;

	@Column(name = "username", nullable = false, length = 45)
	private String username;

	@Column(name = "password", nullable = false, length = 45)
	private String password;

	@Column(name = "nome", nullable = false, length = 45)
	private String nome;

	@Column(name = "cognome", nullable = false, length = 45)
	private String cognome;

	@Column(name = "email", nullable = false, length = 45)
	private String email;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToMany()
    @JoinTable(name = "auth_group_members", 
    			joinColumns = @JoinColumn(name = "id_utente", 
    										referencedColumnName = "id_utente"), 
    		    inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    private List<AuthGroup> groups = new ArrayList<AuthGroup>();
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "district", column = @Column(name = "id_provincia")),
			@AttributeOverride(name = "department", column = @Column(name = "id_regione")),
			@AttributeOverride(name = "citta", column = @Column(name = "citta")),
			@AttributeOverride(name = "via", column = @Column(name = "via")),
			@AttributeOverride(name = "numero", column = @Column(name = "numero")),
			@AttributeOverride(name = "nazione", column = @Column(name = "nazione")),
			@AttributeOverride(name = "codice_postale", column = @Column(name = "codice_postale"))
	})
	private Address address;
	

	@Column(name = "role", length = 1)
	private Character role;

	@Version
	@Column(name="version")
	private int version;
	
	public User() {
	}

	public User(String username, String password, String nome, String cognome,
			String email) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}

	public User(String username, String password, String nome, String cognome,
			String email, Character role, Address address) {

		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.role = role;
	}

	public Long getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getRole() {
		return this.role;
	}

	public void setRole(Character role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [idUtente=" + idUtente + ", username=" + username
				+ ", nome=" + nome + ", cognome=" + cognome + ", email="
				+ email + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idUtente == null) ? 0 : idUtente.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	public List<AuthGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<AuthGroup> groups) {
		this.groups = groups;
	}
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (idUtente == null) {
			if (other.idUtente != null)
				return false;
		} else if (!idUtente.equals(other.idUtente))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
