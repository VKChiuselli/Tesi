package it.clever.opengest.business.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@Table(name = "clienti", catalog = "opengest")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente", unique = true, nullable = false)
	private Integer idCliente;
	
	@Column(name = "codice", nullable = false, length = 45)
	private String codice;

	@Column(name = "rag_soc", nullable = false, length = 45)
	private String ragSoc;
	
	@Column(name = "piva", nullable = false, length = 16277215)
	private String piva;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<Order> orders = new HashSet<Order>(0);

	public Customer() {
	}

	public Customer(String codice, String ragSoc, String piva) {
		this.codice = codice;
		this.ragSoc = ragSoc;
		this.piva = piva;
	}

	public Customer(String codice, String ragSoc, String piva,
			Set<Order> ordinis) {
		this.codice = codice;
		this.ragSoc = ragSoc;
		this.piva = piva;
		this.orders = ordinis;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	public String getRagSoc() {
		return this.ragSoc;
	}

	public void setRagSoc(String ragSoc) {
		this.ragSoc = ragSoc;
	}

	public String getPiva() {
		return this.piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> ordinis) {
		this.orders = ordinis;
	}

}