package it.clever.hibernate.tutorial.business.services;

import it.clever.hibernate.tutorial.business.dao.impl.DaoFactory;
import it.clever.hibernate.tutorial.business.dao.impl.UserDaoImpl;
import it.clever.hibernate.tutorial.business.entity.User;
import it.clever.hibernate.tutorial.exception.BusinessException;

import java.sql.SQLException;
import java.util.List;

public class UserService {

	private UserDaoImpl userDao;
	
	public UserService() {
		this.userDao = new DaoFactory().createUserDao();
	}
	
	public boolean authorization(String username, String password) throws SQLException, Exception  {
		
		boolean authorized = false;
		
		return authorized;
	}

	public User findByUsername(String username) throws Exception  {
		
		User retuser = null;
		this.userDao.openCurrentSession();
		retuser = this.userDao.findByUsername(username);
		this.userDao.closeCurrentSession();
		return retuser;
	}	
	
	public List<User> findAll() throws Exception  {
		
		this.userDao.openCurrentSession();
		List<User> retuserList = this.userDao.findAll();
		this.userDao.closeCurrentSession();
		return retuserList;
	}

	public void persist(User entity) throws Exception {
		this.userDao.beginTransaction();
		this.userDao.persist(entity);		
		this.userDao.closeCurrentSession();
	}

	public void update(User entity) throws Exception {
		this.userDao.beginTransaction();
		this.userDao.update(entity);		
		this.userDao.closeCurrentSession();
	}

	public User findById(Integer id) throws Exception {
		this.userDao.openCurrentSession();
		User retUser = this.userDao.findById(id);
		this.userDao.closeCurrentSession();
		return retUser;
	}

	public void delete(User entity) throws Exception {
		this.userDao.beginTransaction();
		this.userDao.delete(entity);		
		this.userDao.endTransaction();

	}
	
	public User findByIdGroupEager(Integer id) throws Exception {
		this.userDao.openCurrentSession();
		User retUser = this.userDao.findById(id);
		retUser.getGroups().size();
		this.userDao.closeCurrentSession();
		return retUser;
	}
	
	public List<User> findUsersByGroup(Integer groupId, String groupName) throws BusinessException {
		
		List<User> retList = null;
		try {
			this.userDao.openCurrentSession();
			retList = this.userDao.findUsersByGroup(groupId, groupName);
			this.userDao.closeCurrentSession();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("findUsersByGroup", "Errore durante il recupero degli utenti del gruppo", e);
		}
		return retList;
	}
	
	public List<User> findUsersByDistrict(Integer groupId, String groupName) throws BusinessException {
		
		List<User> retList = null;
		try {
			this.userDao.openCurrentSession();
			retList = this.userDao.findUsersByDepartment(groupId, groupName);
			this.userDao.closeCurrentSession();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("findUsersByDistrict", "Errore durante il recupero degli utenti del gruppo", e);
		}
		return retList;
	}
}
