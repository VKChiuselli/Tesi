package com.opengest.core.business.vo;

import java.math.BigDecimal;

public interface IProduct {

	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract String getCode();

	public abstract void setCode(String code);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract BigDecimal getPrice();

	public abstract void setPrice(BigDecimal pice);

}