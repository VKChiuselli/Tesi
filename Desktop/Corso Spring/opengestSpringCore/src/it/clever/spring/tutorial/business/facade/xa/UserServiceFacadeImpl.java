package it.clever.spring.tutorial.business.facade.xa;

import it.clever.spring.tutorial.business.dao.xa.UserDaoImpl;
import it.clever.spring.tutorial.business.entities.User;
import it.clever.spring.tutorial.business.exception.BusinessException;
import it.clever.spring.tutorial.business.facade.trx.ApplicationService;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(value="transactionManager")
public class UserServiceFacadeImpl implements ApplicationService {

	private UserDaoImpl userDao;

	public UserServiceFacadeImpl(){
		
	}

	/*
	public UserServiceFacadeImpl(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
*/
	public boolean authorization(String username, String password)
			throws SQLException, Exception {

		boolean authorized = false;

		return authorized;
	}

	public User findByUsername(String username) throws Exception {

		User retuser = null;
		retuser = this.userDao.findByUsername(username);
		return retuser;
	}

	public List<User> findAll() throws Exception {

		List<User> retuserList = (List<User>)this.userDao.findAll();
		return retuserList;
	}

	public void persist(User entity) throws Exception {
		this.userDao.persist(entity);
	}

	public void update(User entity) throws Exception {
		
		this.userDao.update(entity);
		
	}

	public User findById(Integer id) throws Exception {
		User retUser = (User)this.userDao.findById(new Long(id));
		
		return retUser;
	}

	public void delete(User entity) throws Exception {
		
		this.userDao.delete(entity);
		

	}

	public User findByIdGroupEager(Integer id) throws Exception {
		User retUser = (User)this.userDao.findById( id);
		retUser.getGroups().size();
		
		return retUser;
	}

	public List<User> findUsersByGroup(Integer groupId, String groupName)
			throws BusinessException {

		List<User> retList = null;
		try {
			retList = this.userDao.findUsersByGroup(groupId, groupName);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("findUsersByGroup",
					"Errore durante il recupero degli utenti del gruppo", e);
		}
		return retList;
	}

	public List<User> findUsersByDistrict(Integer groupId, String groupName)
			throws BusinessException {

		List<User> retList = null;
		try {
			retList = this.userDao.findUsersByDepartment(groupId, groupName);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("findUsersByDistrict",
					"Errore durante il recupero degli utenti del gruppo", e);
		}
		return retList;
	}

	public void tryMerge() throws Exception {
		//try {
			
			
			User detachedUser = (User)this.userDao.findById(1L);

			System.out.println("\nPrima lettura: " + detachedUser + "\n\n");

			detachedUser.setCognome(detachedUser.getCognome() + "_MOD1");
			System.out.println("\n\nSeconda lettura: " + detachedUser + "\n\n");

			// Viene caricato un nuovo oggetto in meoria ed è un PRESISTENT object.
			User newUser = (User)this.userDao.findById(1L);
			System.out.println("\n\nCodice regione: " + newUser.getAddress().getDepartment().getCodice() +"\n\n");
			
			User retUser = (User)this.userDao.merge(detachedUser);
			retUser.setCognome("Giont");

			// Generazione dell'eccezione.
			Object o = null;
			o.toString();
/*			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new BusinessException("findUsersByDistrict",
					"Errore durante il recupero degli utenti.", e);
		}
*/		
	}
	

	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	
	
}
