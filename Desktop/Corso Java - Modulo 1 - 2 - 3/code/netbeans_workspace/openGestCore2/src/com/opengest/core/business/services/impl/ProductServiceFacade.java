/**
 * <b> ProductServiceFacade.java
 * 
 * <br/>
 * 
 * Classe facade per la gestione delle operazioni del modulo prodotti.
 * 
 */
package com.opengest.core.business.services.impl;

import java.util.List;

import com.opengest.core.business.bo.ProductBO;
import com.opengest.core.business.dto.ProductDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.services.IProductSevice;
import com.opengest.core.business.vo.IProduct;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class ProductServiceFacade implements IProductSevice {

	
	public ProductDTO findProductById(Long id) throws BusinessException {
		IProduct Product = new ProductBO().findById(id); 
		return new ProductDTO(Product);
	}
	
	public void deleteProduct(Long id) throws BusinessException {
		new ProductBO().delete(id); 
	}

	public void saveProduct(ProductDTO product) throws BusinessException {
		new ProductBO().save(product.getProductBean());
	}
	
	public void updateProduct(ProductDTO product) throws BusinessException {
		new ProductBO().update(product.getProductBean());
	}

	public List<IProduct> listProducts() throws BusinessException {
		return new ProductBO().findAll();
	}

	public boolean existCode(String code) throws BusinessException {
		return new ProductBO().existCode(code);
	}


}
