/**
 * @author 2Clever.IT
 *
 */
package it.clever.hibernate.tutorial.business.dao;

import it.clever.hibernate.tutorial.business.entity.Customer;
import it.clever.hibernate.tutorial.business.entity.CustomerContract;

/**
 * @author 2Clever.IT
 *
 */
public interface CustomerDao extends BaseDaoInterface<Customer, Integer> {

	public Integer saveContract(Customer customer, CustomerContract contract) throws Exception;
	
}