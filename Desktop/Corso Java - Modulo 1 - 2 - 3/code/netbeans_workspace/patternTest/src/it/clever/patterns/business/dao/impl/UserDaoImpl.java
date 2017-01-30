/**
 * UserDaoImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.patterns.business.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import it.clever.patterns.business.dao.JdbcManager;
import it.clever.patterns.business.dao.UserDao;
import it.clever.patterns.business.model.UserVO;
import it.clever.patterns.business.utils.IApplicationConstants;

/**
 * @author robgion
 *
 */
public class UserDaoImpl implements UserDao {

	private JdbcManager jdbcManager;
	
	
	/**
	 * @param jdbcManager
	 */
	public UserDaoImpl(JdbcManager jdbcManager) {
		super();
		this.jdbcManager = jdbcManager;
	}

	@Override
	public UserVO findById(Long id, boolean lock) {
		UserVO retuser = null;
		PreparedStatement pstmt;
		try {
			pstmt = jdbcManager.prepareStatement(IApplicationConstants.QUERY_FIND_USER_BY_PRIMARY_KEY);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs != null) {
				retuser = new UserVO();
				while(rs.next()){
					retuser.setUsername(rs.getString("username"));
					retuser.setPassword(rs.getString("password"));
					retuser.setEmail(rs.getString("email"));
					retuser.setNome(rs.getString("nome"));
					retuser.setCognome(rs.getString("cognome"));
					retuser.setId(rs.getLong("id_utente"));
				}				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return retuser;
	}

	@Override
	public List<UserVO> findAll() throws SQLException {
		List<UserVO> retuserList = null;
		Statement stmt = jdbcManager.createStatement();		
		ResultSet rs = stmt.executeQuery(IApplicationConstants.QUERY_FIND_All_USERS);
		if(rs != null) {
			retuserList = new ArrayList<UserVO>();
			while(rs.next()){
				UserVO retuser = new UserVO();
				retuser.setId(rs.getLong("id_utente"));
				retuser.setUsername(rs.getString("username"));
				retuser.setPassword(rs.getString("password"));
				retuser.setEmail(rs.getString("email"));
				retuser.setNome(rs.getString("nome"));
				retuser.setCognome(rs.getString("cognome"));
				retuserList.add(retuser);
			}				
		}
		return retuserList;
	}

	@Override
	public UserVO makePersistent(UserVO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findUserByUsername(String username) {
		return null;
	}
}
