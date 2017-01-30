/**
 * <b> OrderVO.java
 * 
 * <br>
 * 
 *  Classe vo per il trasporto dei dati degli ordini.
 * 
 */
package com.opengest.core.business.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class OrderVO implements IOrder {

	private Long id;
	private BigDecimal amount;
	private Integer quantity;
	private Date date;
	private ICustomer customer;
	private IProduct product;
	
	public OrderVO() {
		this.product = new ProductVO();
		this.customer = new CustomerVO();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ICustomer getCustomer() {
		return customer;
	}
	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}
	public IProduct getProduct() {
		return product;
	}
	public void setProduct(IProduct product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
