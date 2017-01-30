/**
 * <b> IUserSevice.java
 * 
 * <br/>
 * 
 * Interfaccia di servizio per le utilit� riguardanti il modulo di amministrazione utenti.
 * 
 */
package it.clever.testapp.tomcat.business.services;

import java.util.List;

import it.clever.testapp.tomcat.business.exceptions.BusinessException;
import it.clever.testapp.tomcat.business.model.UserVO;


/**
 * @author Roberto Giontella
 * 
 */
public interface IUserSevice {
	
	boolean authorization(String username, String password) throws Exception ;
	
	UserVO findUserById(Long id) throws BusinessException;
	
	void saveUser(UserVO user) throws BusinessException;
	
	void updateUser(UserVO user) throws BusinessException;
	
	List<UserVO> listUsers() throws BusinessException;
	
	void deleteUser(Long id) throws BusinessException;

	boolean existUsername(String username) throws BusinessException;
}
