/**
 * UserBo.java
 *
 * robgion
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.patterns.business.bo;

import java.sql.SQLException;
import java.util.List;

import it.clever.patterns.business.dao.DAOFactory;
import it.clever.patterns.business.dao.UserDao;
import it.clever.patterns.business.model.UserVO;

/**
 * @author robgion
 *
 */
public class UserBo {

	public List<UserVO> retrieveAllUsersFromLocal() throws SQLException {
		List<UserVO> retList = null;
		
		DAOFactory jdbcFactory = DAOFactory.instance(DAOFactory.JDBC);
		UserDao userDao = jdbcFactory.getUserDao();
		retList = userDao.findAll();
		
		return retList;
	}
}
