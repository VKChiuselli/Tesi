/**
 * <b> ProductVO.java
 * 
 * <br>
 * 
 *  Classe vo per il trasporto dei dati dei prodotti.
 * 
 */
package com.opengest.core.business.vo;

import java.math.BigDecimal;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class ProductVO implements IProduct {
	
	private Long id;
	private String code;
	private String description;
	private BigDecimal price;
	
	
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IProduct#getId()
	 */
	public Long getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IProduct#setId(java.lang.Long)
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IProduct#getCode()
	 */
	public String getCode() {
		return code;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IProduct#setCode(java.lang.String)
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IProduct#getDescription()
	 */
	public String getDescription() {
		return description;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IProduct#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IProduct#getPrice()
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.IProduct#setPrice(java.math.BigDecimal)
	 */
	public void setPrice(BigDecimal pice) {
		this.price = pice;
	}
	
	
	
}
