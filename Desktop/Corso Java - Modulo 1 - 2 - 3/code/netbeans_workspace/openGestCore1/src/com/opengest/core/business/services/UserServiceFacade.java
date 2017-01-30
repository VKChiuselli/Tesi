/**
 * <b> UserServiceFacade.java
 * 
 * <br/>
 * 
 * Classe facade per la gestione delle operazioni del modulo utente.
 * 
 */
package com.opengest.core.business.services;

import java.util.List;

import com.opengest.core.business.bo.UserBO;
import com.opengest.core.business.dto.UserDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.IUser;
import com.opengest.core.business.vo.UserVO;

/**
 * 
 * @author 2Clever.IT
 *
 */
public class UserServiceFacade implements IUserSevice {

	
	/**
	 * Metodo per l'autorizzaizone dell'utente nella sessione di login.
	 */
	public boolean authorization(String username, String password) throws BusinessException {
		try {
			return new UserBO().authorization(username, password);
		} catch (Exception e) {
			throw new BusinessException("[UserServiceFacade.authorization]", e);
		}
	}
	
	/**
	 * Metodo finder per la ricerca dell'utente tramite il suo id (primary key).
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserDTO findUserById(Long id) throws BusinessException {
		try {
			UserDTO dto = new UserDTO( new UserBO().findById(id)); 
			return dto;
		} catch (Exception e) {
			throw new BusinessException("[UserServiceFacade.findById]", e);
		}
	}
	
	/**
	 * Metodo finder per la ricerca dell'utente tramite il suo id (primary key).
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deleteUser(Long id) throws BusinessException {
		try {
			  new UserBO().delete(id);
		} catch (Exception e) {
			throw new BusinessException("[UserServiceFacade.delete]", e);
		}
	}
	
	/**
	 * Metodo per la registrazione dell'utente nella base dati.
	 *  
	 * @param user
	 * void
	 *
	 */
	public void saveUser(UserDTO user) throws BusinessException {
		try {
			
			new UserBO().save(user.getUserBean());
			
		} catch (Exception e) {
			throw new BusinessException("[UserServiceFacade.save]", e);
		}
	}
	
	/**
	 * Metodo per la modifica dell'utente nella base dati.
	 *  
	 * @param user
	 * void
	 *
	 */
	public void updateUser(UserDTO user) throws BusinessException {
		try {
			new UserBO().update(user.getUserBean());
		} catch (Exception e) {
			throw new BusinessException("[UserServiceFacade.update]", e);
		}
	}
	
	/**
	 * Metodo per la registrazione dell'utente nella base dati.
	 *  
	 * @param user
	 * void
	 *
	 */
	public List<UserVO> listUsers() throws BusinessException {
		try {
			return new UserBO().findAll();
		} catch (Exception e) {
			throw new BusinessException("[UserServiceFacade.findAll]", e);
		}
	}


	/**
	 * Metodo per il controllo sull'esistenza di uno username.
	 * @param username
	 * @return
	 * @throws BusinessException
	 */
    public boolean existUsername(String username) throws BusinessException {
        try {
			return new UserBO().exist(username);
		} catch (Exception e) {
			throw new BusinessException("[UserServiceFacade.existUsername]", e);
		}
    }
	
    /**
     * Metodo per la ricerca dello user in base allo username.
     * @param username
     * @return
     * @throws BusinessException
     */
    public UserDTO findByUsername(String username) throws BusinessException {
        try {
        	UserDTO dto = new UserDTO(new UserBO().findByUsername(username));
			return dto;
		} catch (Exception e) {
			throw new BusinessException("[UserServiceFacade.findByUsername]", e);
		}    	
    }

}
