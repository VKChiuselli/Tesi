/**
 * UserService.java
 *
 * robgion
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.patterns.business.services;

import java.sql.SQLException;
import java.util.List;

import it.clever.patterns.business.bo.UserBo;
import it.clever.patterns.business.model.UserVO;

/**
 * @author robgion
 *
 */
public class UserService {

	public List<UserVO> retrieveAllUsersFromLocal() throws SQLException {
		return new UserBo().retrieveAllUsersFromLocal();
	}
}
