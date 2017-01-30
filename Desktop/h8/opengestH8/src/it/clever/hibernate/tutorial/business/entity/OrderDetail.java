package it.clever.hibernate.tutorial.business.entity;

import java.util.Date;

public class OrderDetail {

	private Integer orderId;
	private Date orderDate;
	private Integer qta;
	private String customerName;
	private String productCode;
	
	
	
	public OrderDetail(Integer orderId, Date orderDate, Integer qta,
			String customerName, String productCode) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.qta = qta;
		this.customerName = customerName;
		this.productCode = productCode;
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getQta() {
		return qta;
	}
	public void setQta(Integer qta) {
		this.qta = qta;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", orderDate=" + orderDate
				+ ", qta=" + qta + ", customerName=" + customerName
				+ ", productCode=" + productCode + "]";
	}
	
	
}
