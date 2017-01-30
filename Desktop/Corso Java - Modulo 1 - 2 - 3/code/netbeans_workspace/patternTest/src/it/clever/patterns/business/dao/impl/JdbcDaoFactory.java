/**
 * JdbcDaoFactory.java
 *
 * robgion
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.patterns.business.dao.impl;

import it.clever.patterns.business.dao.CustomerDao;
import it.clever.patterns.business.dao.DAOFactory;
import it.clever.patterns.business.dao.JdbcManager;
import it.clever.patterns.business.dao.OrdineDao;
import it.clever.patterns.business.dao.UserDao;

/**
 * @author robgion
 *
 */
public class JdbcDaoFactory extends DAOFactory {

	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		try {
			return new UserDaoImpl(JdbcManager.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CustomerDao getCustomerDao() {
		try {
			return new CustomerDaoImpl(JdbcManager.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public OrdineDao getOrdineDao() {
    	try {
			return new OrdineDaoImpl(JdbcManager.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;    
    }

	
}
