/**
 * <b> IProductSevice.java
 * 
 * <br/>
 * 
/**
 * <b> ProductServiceFacade.java
 * 
 * <br/>
 * 
 * Interfaccia facade per la gestione delle operazioni del modulo prodotti.
 * 
 */
package com.opengest.core.business.services;

import java.util.List;

import com.opengest.core.business.dto.ProductDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.IProduct;


/**
 * @author Roberto Giontella
 * 
 */
public interface IProductSevice {
	
	
	ProductDTO findProductById(Long id) throws BusinessException;
	
	void saveProduct(ProductDTO product) throws BusinessException;
	
	void updateProduct(ProductDTO product) throws BusinessException;
	
	List<IProduct> listProducts() throws BusinessException;
	
	void deleteProduct(Long id) throws BusinessException;
	
	boolean existCode(String code) throws BusinessException;;
}
