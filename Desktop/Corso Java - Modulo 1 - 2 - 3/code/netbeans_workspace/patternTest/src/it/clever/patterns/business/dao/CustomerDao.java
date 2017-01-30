/**
 * UserDao.java
 *
 * robgion
 * www.2clever.it
 *
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.patterns.business.dao;

import it.clever.patterns.business.model.CustomerVO;
import it.clever.patterns.business.model.UserVO;

/**
 * @author robgion
 *
 */
public interface CustomerDao extends GenericDAO<CustomerVO, Long> {

    public UserVO findCustomerByName(String name);
}
