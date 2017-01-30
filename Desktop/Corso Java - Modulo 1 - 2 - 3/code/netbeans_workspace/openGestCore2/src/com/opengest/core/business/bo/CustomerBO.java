/**
 * <b> CustomerDao.java
 * 
 * <br>
 * 
 *  Classe dao per la gestione delle operazioni sul modulo clienti.
 * 
 */
package com.opengest.core.business.bo;

import java.util.List;

import com.opengest.core.business.dao.CustomerDao;
import com.opengest.core.business.dao.UserDao;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.ICustomer;

/**
 * @author Roberto Giontella
 * 
 */
public class CustomerBO {

	/**
	 * Metodo finder per la ricerca del cliente tramite il suo id (primary key).
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ICustomer findById(Long id) throws BusinessException {
		try {
			return new CustomerBO().findById(id);
		} catch (Exception e) {
			throw new BusinessException("[CustomerDao.findById]", e);
		}
	}
	
	/**
	 * Metodo finder per la ricerca del cliente tramite il suo id (primary key).
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void delete(Long id) throws BusinessException {
		try {
			  new CustomerBO().delete(id);
		} catch (Exception e) {
			throw new BusinessException("[CustomerDao.delete]", e);
		}
	}
	
	/**
	 * Metodo per la registrazione del cliente nella base dati.
	 *  
	 * @param product
	 * void
	 *
	 */
	public void save(ICustomer product) throws BusinessException {
		try {
			new CustomerBO().save(product);
		} catch (Exception e) {
			throw new BusinessException("[CustomerDao.save]", e);
		}
	}
	
	/**
	 * Metodo per la modifica del cliente nella base dati.
	 *  
	 * @param product
	 * void
	 *
	 */
	public void update(ICustomer product) throws BusinessException {
		try {
			new CustomerBO().update(product);
		} catch (Exception e) {
			throw new BusinessException("[CustomerDao.update]", e);
		}
	}
	
	/**
	 * Metodo per la registrazione del cliente nella base dati.
	 *  
	 * void
	 *
	 */
	public List<ICustomer> findAll() throws BusinessException {
		try {
			return new CustomerBO().findAll();
		} catch (Exception e) {
			throw new BusinessException("[CustomerDao.findAll]", e);
		}
	}
	

	/**
	 * Metodo per il controllo sull'esistenza di un codice cliente.
	 * @param code
	 * @return
	 * @throws BusinessException
	 */
    public boolean existCode(String code) throws BusinessException {
        try {
			return new UserDao().exist(code);
		} catch (Exception e) {
			throw new BusinessException("[CustomerDao.existCode]", e);
		}
    }	
}
