/**
 * <b> ProductDao.java
 * 
 * <br>
 * 
 *  Classe dao per la gestione delle operazioni sul modulo prodotti.
 * 
 */
package com.opengest.core.business.bo;

import java.util.List;

import com.opengest.core.business.dao.ProductDao;
import com.opengest.core.business.dao.UserDao;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.IProduct;

/**
 * @author Roberto Giontella
 * 
 */
public class ProductBO {

	/**
	 * Metodo finder per la ricerca del prodotto tramite il suo id (primary key).
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IProduct findById(Long id) throws BusinessException {
		try {
			return new ProductBO().findById(id);
		} catch (Exception e) {
			throw new BusinessException("[ProductDao.findById]", e);
		}
	}
	
	/**
	 * Metodo finder per la ricerca del prodotto tramite il suo id (primary key).
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void delete(Long id) throws BusinessException {
		try {
			  new ProductBO().delete(id);
		} catch (Exception e) {
			throw new BusinessException("[ProductDao.delete]", e);
		}
	}
	
	/**
	 * Metodo per la registrazione del prodotto nella base dati.
	 *  
	 * @param product
	 * void
	 *
	 */
	public void save(IProduct product) throws BusinessException {
		try {
			new ProductBO().save(product);
		} catch (Exception e) {
			throw new BusinessException("[ProductDao.save]", e);
		}
	}
	
	/**
	 * Metodo per la modifica del prodotto nella base dati.
	 *  
	 * @param product
	 * void
	 *
	 */
	public void update(IProduct product) throws BusinessException {
		try {
			new ProductBO().update(product);
		} catch (Exception e) {
			throw new BusinessException("[ProductDao.update]", e);
		}
	}
	
	/**
	 * Metodo per la registrazione del prodotto nella base dati.
	 *  
	 * @param user
	 * void
	 *
	 */
	public List<IProduct> findAll() throws BusinessException {
		try {
			return new ProductBO().findAll();
		} catch (Exception e) {
			throw new BusinessException("[ProductDao.findAll]", e);
		}
	}
	

	/**
	 * Metodo per il controllo sull'esistenza di un codice prodotto.
	 * @param code
	 * @return
	 * @throws BusinessException
	 */
    public boolean existCode(String code) throws BusinessException {
        try {
			return new UserDao().exist(code);
		} catch (Exception e) {
			throw new BusinessException("[ProductDao.existCode]", e);
		}
    }	
}
