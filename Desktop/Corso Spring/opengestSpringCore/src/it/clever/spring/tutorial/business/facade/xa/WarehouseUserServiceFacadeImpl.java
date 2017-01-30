package it.clever.spring.tutorial.business.facade.xa;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.clever.spring.tutorial.business.dao.xa.UserDaoWarehouseImpl;
import it.clever.spring.tutorial.business.entities.User;
import it.clever.spring.tutorial.business.exception.BusinessException;
import it.clever.spring.tutorial.business.facade.trx.ApplicationService;

@Transactional(value="warehouseTxManager", rollbackFor=BusinessException.class )
public class WarehouseUserServiceFacadeImpl implements ApplicationService {

	private UserDaoWarehouseImpl warehouseDao;

	public WarehouseUserServiceFacadeImpl() {
	}

	public boolean authorization(String username, String password)
			throws SQLException, Exception {

		boolean authorized = false;

		return authorized;
	}

	public User findByUsername(String username) throws Exception {

		User retuser = null;
		retuser = this.warehouseDao.findByUsername(username);
		return retuser;
	}

	public List<User> findAll() throws Exception {

		List<User> retuserList = (List<User>)this.warehouseDao.findAll();
		return retuserList;
	}

	public void persist(User entity) throws Exception {
		this.warehouseDao.persist(entity);
	}

	
	public void update(User entity) throws Exception {
		this.warehouseDao.update(entity);
	}

	public User findById(Long id) throws Exception {
		User retUser = (User)this.warehouseDao.findById(id);
		
		return retUser;
	}

	public void delete(User entity) throws Exception {
		
		this.warehouseDao.delete(entity);
		

	}

	public User findByIdGroupEager(Integer id) throws Exception {
		User retUser = (User)this.warehouseDao.findById( id);
		retUser.getGroups().size();
		
		return retUser;
	}

	public List<User> findUsersByGroup(Integer groupId, String groupName)
			throws BusinessException {

		List<User> retList = null;
		try {
			retList = this.warehouseDao.findUsersByGroup(groupId, groupName);
			
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
			retList = this.warehouseDao.findUsersByDepartment(groupId, groupName);
			
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
			
			
			User detachedUser = (User)this.warehouseDao.findById(1L);

			System.out.println("\nPrima lettura: " + detachedUser + "\n\n");

			detachedUser.setCognome(detachedUser.getCognome() + "_MOD1");
			System.out.println("\n\nSeconda lettura: " + detachedUser + "\n\n");

			// Viene caricato un nuovo oggetto in meoria ed è un PRESISTENT object.
			User newUser = (User)this.warehouseDao.findById(1L);
			System.out.println("\n\nCodice regione: " + newUser.getAddress().getDepartment().getCodice() +"\n\n");
			
			User retUser = (User)this.warehouseDao.merge(detachedUser);
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
	
	public List<User> findUsersByCriteriaFilters(String name, String surname, String email)
			throws BusinessException {
		
		try {
			List<User> retList = null;
			try {
				retList = this.warehouseDao.findUsersByCriteriaFilters(name, surname, email);
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
	

	public UserDaoWarehouseImpl getWarehouseDao() {
		return warehouseDao;
	}

	public void setWarehouseDao(UserDaoWarehouseImpl userDao) {
		this.warehouseDao = userDao;
	}
	
	
}
