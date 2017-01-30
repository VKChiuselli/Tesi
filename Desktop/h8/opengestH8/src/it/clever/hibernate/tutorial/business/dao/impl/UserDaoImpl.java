/**
 * <b> UserDaoImpl.java
 * 
 * <br>
 * 
 *  Classe bo per l'accesso ai dati della tabella utente.
 * 
 */
package it.clever.hibernate.tutorial.business.dao.impl;

import it.clever.hibernate.tutorial.business.dao.UserDao;
import it.clever.hibernate.tutorial.business.entity.User;

import java.util.List;

import org.hibernate.Query;

/**
 * @author 2Clever.IT
 * 
 */
public class UserDaoImpl extends BaseDaoServiceImpl implements UserDao {
	
	
	UserDaoImpl(){
	}
	
	
	@Override
	public Integer save(User entity) throws Exception {
		return (Integer)getCurrentSession().save(entity);
	}

	@Override
	public void persist(User entity) throws Exception {
		getCurrentSession().persist(entity);		
	}

	@Override
	public void update(User entity) throws Exception {
		getCurrentSession().update(entity);		
	}

	@Override
	public User findById(Integer id) throws Exception {
		return (User)getCurrentSession().get(User.class, id);
	}

	@Override
	public void delete(User entity) throws Exception {
		getCurrentSession().delete(entity);		
	}

	@Override
	public List<User> findAll() throws Exception  {
		
		List<User> retuserList = getCurrentSession()
				.createQuery("from User").list();
		return retuserList;
	}

	public User findByUsername(String username) {
		Query query = getCurrentSession()
				.createQuery("from User u where u.username = :username");
		
		query.setParameter("username", username);
		User retUser = (User)query.uniqueResult();
		return retUser;
	}
	
	
	public List<User> findUsersByGroup(Integer groupId, String groupName) throws Exception  {
		List<User> retList = null;
		
		Query query = getCurrentSession()
						.createQuery("select u from User u join u.groups as g" +
								" where g.id = :groupId" +
								" and g.groupName = :groupName");
		
		query.setParameter("groupId", groupId);
		query.setParameter("groupName", groupName);
		retList = query.list();
		
		return retList;
	}

	public List<User> findUsersByDepartment(Integer deptId, String deptCode) throws Exception  {
		List<User> retList = null;
		
		// Non aggira la LAZY initialization
		String q1 = "select u from User u " +
				" where u.address.department.idRegione = :deptId" +
				" and u.address.department.codice = :deptCode";

		// Permette l'inizializzazione dele Department.
		String q2 = "select u from User u join fetch u.address.department d" +
				" where d.idRegione = :deptId" +
				" and d.codice = :deptCode";
		
		Query query = getCurrentSession()
						.createQuery(q1);
		
		query.setParameter("deptId", deptId);
		query.setParameter("deptCode", deptCode);
		retList = query.list();
		
		return retList;
	}
}
