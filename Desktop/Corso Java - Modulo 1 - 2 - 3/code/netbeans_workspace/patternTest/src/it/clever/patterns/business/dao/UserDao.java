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

import it.clever.patterns.business.model.UserVO;

/**
 * @author robgion
 *
 */
public interface UserDao extends GenericDAO<UserVO, Long> {

    public UserVO findUserByUsername(String username);
}
