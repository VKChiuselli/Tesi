package it.clever.spring.tutorial.business.facade.annotations;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.clever.spring.tutorial.business.dao.annotations.UserDao;
import it.clever.spring.tutorial.business.entities.User;
import it.clever.spring.tutorial.business.exception.BusinessException;

@Service
public class UserServiceFacadeImpl {

	@Autowired
	private UserDao userDao;

	public UserServiceFacadeImpl() {
	}

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

	@Transactional
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
		User retUser = (User)this.userDao.findById(id);
		
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

	@Transactional
	public void tryMerge() throws Exception {
		//try {
			
			
			User detachedUser = (User)this.userDao.findById(1L);

			System.out.println("\nPrima lettura: " + detachedUser + "\n\n");

			detachedUser.setCognome(detachedUser.getCognome() + "_MOD1");
			System.out.println("\n\nSeconda lettura: " + detachedUser + "\n\n");

			// Modifica dello stato.
			
			
			// Viene caricato un nuovo oggetto in meoria ed è un PRESISTENT object.
			User newUser = (User)this.userDao.findById(1L);
			System.out.println("\n\nTerza lettura: " + newUser +"\n\n");
			
			/*
			 * La merge del DETACHED object comporta il riversamento delle modifiche
			 * nell'oggetto persistence.
			 * 
			 * L'oggetto merged rimane comunque DETACHED e quindi non agganciato al contesto,
			 * nonostante l'oggetto restituito sia un PERSISTENT object.
			 */
			User retUser = (User)this.userDao.merge(detachedUser);
			retUser.setCognome("Pippo");

			// Generazione dell'eccezione.
			Object o = null;
//			o.toString();
/*			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new BusinessException("findUsersByDistrict",
					"Errore durante il recupero degli utenti.", e);
		}
*/		
	}
	
	public List<User> findUsersByCriteriaFilters(String name, String surname, String email)
			throws BusinessException {
		
		try {
			List<User> retList = null;
			try {
				retList = this.userDao.findUsersByCriteriaFilters(name, surname, email);
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusinessException("findUsersByDistrict",
						"Errore durante il recupero degli utenti del gruppo", e);
			}
			return retList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("findUsersByDistrict",
					"Errore durante il recupero degli utenti.", e);
		}
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
}
