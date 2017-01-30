/**
 * <b> IUserSevice.java
 * 
 * <br/>
 * 
 * Interfaccia di servizio per le utility� riguardanti il modulo di amministrazione utenti.
 * 
 */
package com.opengest.core.business.services;

import java.util.List;

import com.opengest.core.business.dto.UserDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.UserVO;


/**
 * @author Roberto Giontella
 * 
 */
public interface IUserSevice {
	
	boolean authorization(String username, String password) throws Exception ;
	
	UserDTO findUserById(Long id) throws BusinessException;
	
	void saveUser(UserDTO user) throws BusinessException;
	
	void updateUser(UserDTO user) throws BusinessException;
	
	List<UserVO> listUsers() throws BusinessException;
	
	void deleteUser(Long id) throws BusinessException;

	boolean existUsername(String username) throws BusinessException;;
}
