/**
 * <b> ProductDTO.java
 * 
 * <br/>
 * 
 * DTO le utility� riguardanti il modulo di amministrazione prodotti.
 * 
 */
package com.opengest.core.business.dto;

import java.math.BigDecimal;

import com.opengest.core.business.vo.IProduct;
import com.opengest.core.business.vo.ProductVO;

/**
 * @author Roberto Giontella
 * 
 */
public class ProductDTO {

	private IProduct productBean;

	private Long id;
	private String code;
	private String description;
	private BigDecimal price;
	
	public ProductDTO() {
		this.productBean = new ProductVO();
	}
	
	public ProductDTO(IProduct pbean) {
		this.productBean = pbean;
		this.id = this.productBean.getId();
		this.code = this.productBean.getCode();
		this.description = this.productBean.getDescription();
		this.price = this.productBean.getPrice();
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public IProduct getProductBean() {
		return populateVO();
	}

	public Long getId() {
		return id;
	}

	public IProduct populateVO() {
		this.productBean.setCode(code);
		this.productBean.setDescription(description);
		this.productBean.setPrice(price);
		return this.productBean;
	}
}
