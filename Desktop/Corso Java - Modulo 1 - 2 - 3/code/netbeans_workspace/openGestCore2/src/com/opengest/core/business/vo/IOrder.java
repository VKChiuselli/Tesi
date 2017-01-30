/**
 * <b> IOrderVO.java
 * 
 * <br>
 * 
 *  Interfaccia per il trasporto dei dati degli ordini.
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
public interface IOrder {

	Long getId();
	
	void setId(Long id);
	
	BigDecimal getAmount();
	
	void setAmount(BigDecimal amount);
	
	Date getDate();
	
	void setDate(Date date);
	
	ICustomer getCustomer();
	
	void setCustomer(ICustomer customer);
	
	IProduct getProduct();
	
	void setProduct(IProduct product);
	
	Integer getQuantity();
	
	void setQuantity(Integer quantity);

}