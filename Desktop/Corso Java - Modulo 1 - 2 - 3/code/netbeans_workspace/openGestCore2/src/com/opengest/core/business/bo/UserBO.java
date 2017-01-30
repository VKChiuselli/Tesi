/**
 * <b> UserDao.java
 * 
 * <br>
 * 
 *  Classe dao per la gestione delle operazioni sul modulo utente.
 * 
 */
package com.opengest.core.business.bo;

import java.util.List;

import com.opengest.core.business.dao.UserDao;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.IUser;
import com.opengest.core.business.vo.IndirizzoVO;
import com.opengest.core.business.vo.ProvinciaVO;
import com.opengest.core.business.vo.RegioneVO;
import com.opengest.core.business.vo.UserVO;

/**
 * @author Roberto Giontella
 * 
 */
public class UserBO {
	
	public UserBO(){
	}
	
	/**
	 * Metodo per l'autorizzaizone dell'utente nella sessione di login.
	 */
	public boolean authorization(String username, String password) throws BusinessException {
		try {
			return new UserBO().authorization(username, password);
		} catch (Exception e) {
			throw new BusinessException("[UserDao.authorization]", e);
		}
	}
	
	/**
	 * Metodo finder per la ricerca dell'utente tramite il suo id (primary key).
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IUser findById(Long id) throws BusinessException {
		try {
			return new UserBO().findById(id);
		} catch (Exception e) {
			throw new BusinessException("[UserDao.findById]", e);
		}
	}
	
	/**
	 * Metodo finder per la ricerca dell'utente tramite il suo id (primary key).
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void delete(Long id) throws BusinessException {
		try {
			  new UserBO().delete(id);
		} catch (Exception e) {
			throw new BusinessException("[UserDao.delete]", e);
		}
	}
	
	/**
	 * Metodo per la registrazione dell'utente nella base dati.
	 *  
	 * @param user
	 * void
	 *
	 */
	public void save(IUser user) throws BusinessException {
		try {
			
			// Salvataggio della residenza (valore fittizio)
			IndirizzoVO residenza = new IndirizzoVO();
			List<RegioneVO> rList = new SystemBO().getListaRegioni();
			residenza.setRegione(rList.get(0));
			List<ProvinciaVO> pList = new SystemBO().getListaProvince();
			residenza.setProvincia(pList.get(0));
			user.setResidenza(residenza);
			
			new UserBO().save(user);
			
		} catch (Exception e) {
			throw new BusinessException("[UserDao.save]", e);
		}
	}
	
	/**
	 * Metodo per la modifica dell'utente nella base dati.
	 *  
	 * @param user
	 * void
	 *
	 */
	public void update(IUser user) throws BusinessException {
		try {
			new UserBO().update(user);
		} catch (Exception e) {
			throw new BusinessException("[UserDao.update]", e);
		}
	}
	
	/**
	 * Metodo per la registrazione dell'utente nella base dati.
	 *  
	 * @param user
	 * void
	 *
	 */
	public List<UserVO> findAll() throws BusinessException {
		try {
			return new UserBO().findAll();
		} catch (Exception e) {
			throw new BusinessException("[UserDao.findAll]", e);
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
			return new UserDao().exist(username);
		} catch (Exception e) {
			throw new BusinessException("[UserDao.existUsername]", e);
		}
    }
	

}
