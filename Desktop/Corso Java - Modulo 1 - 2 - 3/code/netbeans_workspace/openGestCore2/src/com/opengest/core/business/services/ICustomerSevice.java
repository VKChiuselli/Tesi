/**
 * <b> ICustomerSevice.java
 * 
 * <br/>
 * 
 * Interfaccia facade per la gestione delle operazioni del modulo clienti.
 * 
 */
package com.opengest.core.business.services;

import java.util.List;

import com.opengest.core.business.dto.CustomerDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.ICustomer;


/**
 * @author Roberto Giontella
 * 
 */
public interface ICustomerSevice {
	
	
	CustomerDTO findCustomerById(Long id) throws BusinessException;
	
	void saveCustomer(CustomerDTO product) throws BusinessException;
	
	void updateCustomer(CustomerDTO product) throws BusinessException;
	
	List<ICustomer> listCustomers() throws BusinessException;
	
	void deleteCustomer(Long id) throws BusinessException;
	
	boolean existCode(String code) throws BusinessException;;
}
