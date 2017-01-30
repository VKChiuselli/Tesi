/* * <b> UserDaoImpl.java
 * 
 * <br>
 * 
 *  Classe bo per l'accesso ai dati della tabella utente.
 * 
 */
package it.clever.spring.tutorial.business.dao.template;

import it.clever.spring.tutorial.business.entities.BaseEntity;
import it.clever.spring.tutorial.business.entities.User;

import java.io.Serializable;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * @author 2Clever.IT
 *
 * Utilizza l'HibernateDaoSupport che permette di utilizzare l'HibernateTemplate 
 * in modo trasparente.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public List<User> findAll() throws Exception {

		List<User> retuserList = (List<User>)getHibernateTemplate().find("from User");
		return retuserList;
	}

	@SuppressWarnings("unchecked")
	public User findByUsername(String username) {
		List<User>  userList = (List<User> )getHibernateTemplate().find(
				"from User u where u.username = ?", username);

		User retUser = userList.get(0);
		return retUser;
	}

	@SuppressWarnings("unchecked")
	public List<User> findUsersByGroup(Integer groupId, String groupName)
			throws Exception {
		
		String[] parameNames = {"groupId", "groupName"};
		Object[] paramValues = new Object[2];
		paramValues[0] = groupId;
		paramValues[1] = groupName;
		
		List<User> retList = null;

		retList = (List<User>)getHibernateTemplate().findByNamedParam(
				"select u from User u join u.groups as g"
						+ " where g.id = :groupId"
						+ " and g.groupName = :groupName", parameNames, paramValues);

		return retList;
	}


	@Override
	public List<User> findUsersByCriteriaFilters(String name, String surname, String email)
			throws Exception {
		
		List<User> retList = null;
		
		Criteria criteria = null;//getCurrentSession()
				//.createCriteria(User.class);
		
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

	@Override
	public List<User> findUsersByDepartment(Integer distId, String distCode)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUsersByFilters(String name, String surname,
			String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void persist(BaseEntity entity) throws Exception {
		getHibernateTemplate().persist(entity);
	}

	@Override
	public Serializable save(BaseEntity entity) throws Exception {
		return getHibernateTemplate().save(entity);
	}

	@Override
	public void saveOrUpdate(BaseEntity entity) throws Exception {
		getHibernateTemplate().saveOrUpdate(entity);		
	}

	@Override
	public void delete(BaseEntity entity) throws Exception {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(BaseEntity entity) throws Exception {
		getHibernateTemplate().update(entity);
	}

	@Override
	public BaseEntity merge(BaseEntity entity) throws Exception {
		return getHibernateTemplate().merge(entity);
	}

	
	@Override
	public BaseEntity findById(Class entityClass, Serializable id) throws Exception {
		return (BaseEntity)getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<? extends BaseEntity> findAll(Class entityClass) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		return (List<BaseEntity>)getHibernateTemplate().findByCriteria(criteria);
	}

}
