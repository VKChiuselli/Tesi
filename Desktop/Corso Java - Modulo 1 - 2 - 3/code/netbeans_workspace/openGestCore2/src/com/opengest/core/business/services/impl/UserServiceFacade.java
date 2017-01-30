/**
 * <b> UserServiceFacade.java
 * 
 * <br/>
 * 
 * Classe facade per la gestione delle operazioni del modulo utente.
 * 
 */
package com.opengest.core.business.services.impl;

import java.util.List;

import com.opengest.core.business.bo.UserBO;
import com.opengest.core.business.dto.UserDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.services.IUserSevice;
import com.opengest.core.business.vo.IUser;
import com.opengest.core.business.vo.UserVO;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class UserServiceFacade implements IUserSevice {

	
	public boolean authorization(String username, String password)
			throws BusinessException {
		
		return new UserBO().authorization(username, password);
	}

	public UserDTO findUserById(Long id) throws BusinessException {
		IUser user = new UserBO().findById(id); 
		return new UserDTO(user);
	}
	
	public void deleteUser(Long id) throws BusinessException {
		new UserBO().delete(id); 
	}

	public void saveUser(UserDTO user) throws BusinessException {
		new UserBO().save(user.getUserBean());
	}
	
	public void updateUser(UserDTO user) throws BusinessException {
		new UserBO().update(user.getUserBean());
	}

	public List<UserVO> listUsers() throws BusinessException {
		return new UserBO().findAll();
	}

	public boolean existUsername(String username) throws BusinessException {
		return new UserBO().existUsername(username);
	}


}
