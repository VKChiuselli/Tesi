package it.clever.hibernate.tutorial.business.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "customer_contract", catalog = "opengest")
public class CustomerContract extends BaseEntity implements java.io.Serializable {

	@GenericGenerator(name = "generator", strategy = "foreign", 
			parameters = @Parameter(name = "property", value = "customer"))
	
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id_contract", nullable = false)
	private Integer idContract;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_start", nullable = false, length = 19)
	private Date dateStart;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_end", nullable = false, length = 19)
	private Date dateEnd;
	
	@Column(name = "protocol", nullable = false, length = 45)
	private String protocol;
	
	@Column(name = "notes", nullable = false, length = 250)
	private String notes;

	@OneToOne  
	@PrimaryKeyJoinColumn  
	private Customer customer;
	
	public Integer getIdContract() {
		return idContract;
	}

	public void setIdContract(Integer idContract) {
		this.idContract = idContract;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
