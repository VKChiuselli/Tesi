/**
 * CustomerDaoImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.patterns.business.dao.impl;

import java.util.List;

import it.clever.patterns.business.dao.CustomerDao;
import it.clever.patterns.business.dao.JdbcManager;
import it.clever.patterns.business.model.CustomerVO;
import it.clever.patterns.business.model.UserVO;

/**
 * @author robgion
 *
 */
public class CustomerDaoImpl implements CustomerDao {
	private JdbcManager jdbcManager;
	
	
	/**
	 * @param jdbcManager
	 */
	public CustomerDaoImpl(JdbcManager jdbcManager) {
		super();
		this.jdbcManager = jdbcManager;
	}
	
	@Override
	public CustomerVO findById(Long id, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerVO makePersistent(CustomerVO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see it.clever.patterns.business.dao.CustomerDao#findCustomerByUsername(java.lang.String)
	 */
	@Override
	public UserVO findCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
