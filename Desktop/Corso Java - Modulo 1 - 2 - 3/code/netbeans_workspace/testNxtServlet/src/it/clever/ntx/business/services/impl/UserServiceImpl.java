/**
 * <b> UserServiceImpl.java
 * 
 * <br/>
 * 
 * JSONServlet
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 * 
 * Classe facade per la gestione delle operazioni del modulo utente.
 * 
 */
package it.clever.ntx.business.services.impl;

import java.util.List;

import it.clever.ntx.business.dao.UserDAO;
import it.clever.ntx.business.exceptions.BusinessException;
import it.clever.ntx.business.services.IUserSevice;
import it.clever.nxt.business.model.UserVO;


/**
 * 
 * @author 2clever.it
 *
 */
public class UserServiceImpl implements IUserSevice {

	
	public boolean authorization(String username, String password)
			throws BusinessException {
		
		return new UserDAO().authorization(username, password);
	}

	/* (non-Javadoc)
	 * @see it.clever.ntx.business.services.IUserSevice#findUserById(java.lang.Long)
	 */
	@Override
	public UserVO findUserById(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see it.clever.ntx.business.services.IUserSevice#saveUser(it.clever.testapp.tomcat.business.model.UserVO)
	 */
	@Override
	public void saveUser(UserVO user) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.clever.ntx.business.services.IUserSevice#updateUser(it.clever.testapp.tomcat.business.model.UserVO)
	 */
	@Override
	public void updateUser(UserVO user) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.clever.ntx.business.services.IUserSevice#listUsers()
	 */
	@Override
	public List<UserVO> listUsers() throws BusinessException {
		// TODO Auto-generated method stub
		return new UserDAO().findAll();
	}

	/* (non-Javadoc)
	 * @see it.clever.ntx.business.services.IUserSevice#deleteUser(java.lang.Long)
	 */
	@Override
	public void deleteUser(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.clever.ntx.business.services.IUserSevice#existUsername(java.lang.String)
	 */
	@Override
	public boolean existUsername(String username) throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}




}
