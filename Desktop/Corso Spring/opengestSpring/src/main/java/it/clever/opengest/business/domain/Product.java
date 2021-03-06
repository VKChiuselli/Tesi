package it.clever.opengest.business.domain;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@Entity
@Table(name = "prodotti", catalog = "opengest")
public class Product {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_prodotto", unique = true, nullable = false)
	private Integer idProdotto;
	
	@Column(name = "codice", nullable = false, length = 45)
	private String codice;
	
	@Column(name = "descrizione", nullable = false, length = 100)
	private String descrizione;
	
	@Column(name = "prezzo", nullable = false, precision = 10)
	private BigDecimal prezzo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private Set<Order> ordinis = new HashSet<Order>(0);

	public Product() {
	}

	public Product(String codice, String descrizione, BigDecimal prezzo) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

	public Product(String codice, String descrizione, BigDecimal prezzo,
			Set<Order> ordinis) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.ordinis = ordinis;
	}


	public Integer getIdProdotto() {
		return this.idProdotto;
	}

	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public BigDecimal getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	
	public Set<Order> getOrdinis() {
		return this.ordinis;
	}

	public void setOrdinis(Set<Order> ordinis) {
		this.ordinis = ordinis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		result = prime * result
				+ ((idProdotto == null) ? 0 : idProdotto.hashCode());
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
		Product other = (Product) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		if (idProdotto == null) {
			if (other.idProdotto != null)
				return false;
		} else if (!idProdotto.equals(other.idProdotto))
			return false;
		return true;
	}

}