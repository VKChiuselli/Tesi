package it.clever.opengest.business.domain;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static javax.persistence.GenerationType.IDENTITY;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@Entity
@Table(name = "ordini", catalog = "opengest")
@NamedQuery(  name="GetAllOrdersBatchMode", 
			 query="select o from Order o")
public class Order {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_ordine", unique = true, nullable = false)
	private Integer idOrdine;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", nullable = true)
	private Customer cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prodotto", nullable = true)
	private Product product;
	
	@Column(name = "ammontare", nullable = false, precision = 10)
	private BigDecimal ammontare;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_ordine", nullable = false, length = 19)
	private Date dataOrdine;
	
	@Column(name = "quantita", nullable = false)
	private int quantita;

	public Order() {
	}

	public Order(Customer clienti, Product product, BigDecimal ammontare,
			Date dataOrdine, int quantita) {
		this.cliente = clienti;
		this.product = product;
		this.ammontare = ammontare;
		this.dataOrdine = dataOrdine;
		this.quantita = quantita;
	}


	public Integer getIdOrdine() {
		return this.idOrdine;
	}

	public void setIdOrdine(Integer idOrdine) {
		this.idOrdine = idOrdine;
	}


	public Customer getCliente() {
		return this.cliente;
	}

	public void setCliente(Customer clienti) {
		this.cliente = clienti;
	}

	public Product getProdotti() {
		return this.product;
	}

	public void setProdotti(Product product) {
		this.product = product;
	}

	public BigDecimal getAmmontare() {
		return this.ammontare;
	}

	public void setAmmontare(BigDecimal ammontare) {
		this.ammontare = ammontare;
	}

	public Date getDataOrdine() {
		return this.dataOrdine;
	}

	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public int getQuantita() {
		return this.quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idOrdine == null) ? 0 : idOrdine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (idOrdine == null) {
			if (other.idOrdine != null)
				return false;
		} else if (!idOrdine.equals(other.idOrdine))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [idOrdine=" + idOrdine + ", ammontare=" + ammontare
				+ ", dataOrdine=" + dataOrdine + ", quantita=" + quantita + "]";
	}

	
}