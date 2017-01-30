/**
 * <b> OrderDTO.java
 * 
 * <br/>
 * 
 * DTO le utility� riguardanti il modulo di amministrazione ordini.
 * 
 */
package com.opengest.core.business.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.opengest.core.business.vo.ICustomer;
import com.opengest.core.business.vo.IOrder;
import com.opengest.core.business.vo.IProduct;
import com.opengest.core.business.vo.OrderVO;

/**
 * @author Roberto Giontella
 * 
 */
public class OrderDTO {

	private IOrder orderBean;

	private Long id;
	private BigDecimal amount;
	private Date date;
	private Integer quantity;
	private ICustomer customer;
	private IProduct product;
	
	public OrderDTO() {
		this.orderBean = new OrderVO();
	}
	
	public OrderDTO(IOrder pbean) {
		this.orderBean = pbean;
		this.id = this.orderBean.getId();
		this.amount = this.orderBean.getAmount();
		this.date = this.orderBean.getDate();
		this.customer = this.orderBean.getCustomer();
		this.product = this.orderBean.getProduct();
		this.quantity = this.orderBean.getQuantity();
	}
	

	public IOrder populateVO() {
		this.orderBean.setAmount(amount);
		this.orderBean.setDate(date);
		this.orderBean.setCustomer(customer);
		this.orderBean.setQuantity(quantity);
		return this.orderBean;
	}

	public IOrder getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(IOrder orderBean) {
		this.orderBean = orderBean;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public BigDecimal calculateAmount() {
		return new BigDecimal(this.quantity * this.getProduct().getPrice().doubleValue());
	}
}
