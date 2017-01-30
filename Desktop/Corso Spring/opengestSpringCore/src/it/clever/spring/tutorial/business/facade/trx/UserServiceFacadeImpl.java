package it.clever.spring.tutorial.business.facade.trx;

import it.clever.spring.tutorial.business.dao.trx.UserDao;
import it.clever.spring.tutorial.business.entities.User;
import it.clever.spring.tutorial.business.exception.BusinessException;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceFacadeImpl implements ApplicationService{

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

	public void tryMerge() throws Exception {
		//try {
			
			
			User detachedUser = (User)this.userDao.findById(1L);

			System.out.println("\nPrima lettura: " + detachedUser + "\n\n");

			detachedUser.setCognome(detachedUser.getCognome() + "_MOD1");
			System.out.println("\n\nSeconda lettura: " + detachedUser + "\n\n");

			User newUser = (User)this.userDao.findById(1L);
			System.out.println("\n\nTerza lettura: " + newUser.getAddress().getDepartment().getCodice() +"\n\n");
			
			User retUser = (User)this.userDao.merge(detachedUser);
			retUser.setCognome("Rossini");

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
