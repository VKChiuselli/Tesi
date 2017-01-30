/* * <b> UserDaoImpl.java
 * 
 * <br>
 * 
 *  Classe bo per l'accesso ai dati della tabella utente.
 * 
 */
package it.clever.spring.tutorial.business.dao.annotations;

import it.clever.spring.tutorial.business.entities.User;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 2Clever.IT
 * 
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	@Override
	public Integer save(User entity) throws Exception {
		return (Integer) this.sessionFactory.getCurrentSession().save(entity);
	}
	
	@Override
	public void saveOrUpdate(User entity) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}
	
	@Override
	public void persist(User entity) throws Exception {
		this.sessionFactory.getCurrentSession().persist(entity);
	}

	@Override
	public void update(User entity) throws Exception {
		this.sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public User findById(Serializable id) throws Exception {
		return (User) this.sessionFactory.getCurrentSession().get(User.class, id);
	}
	@Override
	public void delete(User entity) throws Exception {
		this.sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public User merge(User entity) throws Exception {
		return (User) this.sessionFactory.getCurrentSession().merge(entity);
	}

	@Override
	public List<User> findAll() throws Exception {

		List<User> retuserList = this.sessionFactory.getCurrentSession().createQuery("from User")
				.list();
		return retuserList;
	}

	public User findByUsername(String username) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				"from User u where u.username = :username");

		query.setParameter("username", username);
		User retUser = (User) query.uniqueResult();
		return retUser;
	}

	public List<User> findUsersByGroup(Integer groupId, String groupName)
			throws Exception {
		List<User> retList = null;

		Query query = this.sessionFactory.getCurrentSession().createQuery(
				"select u from User u join u.groups as g"
						+ " where g.id = :groupId"
						+ " and g.groupName = :groupName");

		query.setParameter("groupId", groupId);
		query.setParameter("groupName", groupName);
		retList = query.list();

		return retList;
	}

	public List<User> findUsersByDepartment(Integer deptId, String deptCode)
			throws Exception {
		List<User> retList = null;

		// Non aggira la LAZY initialization
		String q1 = "select u from User u "
				+ " where u.address.department.idRegione = :deptId"
				+ " and u.address.department.codice = :deptCode";

		// Permette l'inizializzazione del Department.
		String q2 = "select u from User u join fetch u.address.department d"
				+ " where d.idRegione = :deptId" + " and d.codice = :deptCode";

		Query query = this.sessionFactory.getCurrentSession().createQuery(q1);

		query.setParameter("deptId", deptId);
		query.setParameter("deptCode", deptCode);
		retList = query.list();

		return retList;
	}

	@Override
	public List<User> findUsersByFilters(String name, String surname, String email)
			throws Exception {
		List<User> retList = null;

		// Non aggira la LAZY initialization
		String q1 = "select u from User u ";

		boolean whereCondSetted = false;
		if(name != null && !name.isEmpty()) {
			q1 += " where u.nome = :name";
			whereCondSetted = true;
		}
		if(surname != null && !surname.isEmpty()) {
			if(!whereCondSetted) {
				q1 += " where ";
				whereCondSetted = true;
			} else {
				
				q1 += " and ";
			}
			q1 += " u.cognome = :surname";
		}
		if(email != null && !email.isEmpty()) {
			if(!whereCondSetted) {
				q1 += " where ";
				whereCondSetted = true;
			} else {
				
				q1 += " and ";
			}
			q1 += " u.email = :email";
		}
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(q1);
		if(name != null && !name.isEmpty()) {
			query.setParameter("name", name);
		}
		if(surname != null && !surname.isEmpty()) {
			query.setParameter("surname", surname);
		}
		if(email != null && !email.isEmpty()) {
			query.setParameter("email", email);
		}
		retList = query.list();

		return retList;
	}
	
	@Override
	public List<User> findUsersByCriteriaFilters(String name, String surname, String email)
			throws Exception {
		
		List<User> retList = null;
		
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(User.class);
		
		if(name != null && !name.isEmpty()) {
			criteria.add(Restrictions.like("nome", "%" + name + "%"));
		}
		if(surname != null && !surname.isEmpty()) {
			criteria.add(Restrictions.like("cognome", "%" + surname + "%"));
		}
		if(email != null && !email.isEmpty()) {
			criteria.add(Restrictions.like("email", "%" + email + "%"));
		}
		criteria.addOrder(org.hibernate.criterion.Order.asc("cognome"));
		
		retList = criteria.list();
		
		return retList;
	}

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void flush() throws Exception {
		this.sessionFactory.getCurrentSession().flush();
	}


}
