/**
 * <b> CustomerServiceFacade.java
 * 
 * <br/>
 * 
 * Classe facade per la gestione delle operazioni del modulo clienti.
 * 
 */
package com.opengest.core.business.services.impl;

import java.util.List;

import com.opengest.core.business.bo.CustomerBO;
import com.opengest.core.business.dto.CustomerDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.services.ICustomerSevice;
import com.opengest.core.business.vo.ICustomer;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class CustomerServiceFacade implements ICustomerSevice {

	
	public CustomerDTO findCustomerById(Long id) throws BusinessException {
		ICustomer Product = new CustomerBO().findById(id); 
		return new CustomerDTO(Product);
	}
	
	public void deleteCustomer(Long id) throws BusinessException {
		new CustomerBO().delete(id); 
	}

	public void saveCustomer(CustomerDTO customer) throws BusinessException {
		new CustomerBO().save(customer.getCustomerBean());
	}
	
	public void updateCustomer(CustomerDTO customer) throws BusinessException {
		new CustomerBO().update(customer.getCustomerBean());
	}

	public List<ICustomer> listCustomers() throws BusinessException {
		return new CustomerBO().findAll();
	}

	public boolean existCode(String code) throws BusinessException {
		return new CustomerBO().existCode(code);
	}


}
