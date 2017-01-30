package it.clever.spring.tutorial.business.dao.template;

import it.clever.spring.tutorial.business.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


public abstract class BaseDaoImpl extends HibernateDaoSupport {

	public void persist(BaseEntity entity) throws Exception {
		getHibernateTemplate().persist(entity);
	}

	public Serializable save(BaseEntity entity) throws Exception {
		return getHibernateTemplate().save(entity);
	}

	public void saveOrUpdate(BaseEntity entity) throws Exception {
		getHibernateTemplate().saveOrUpdate(entity);		
	}

	public void delete(BaseEntity entity) throws Exception {
		getHibernateTemplate().delete(entity);
	}

	public void update(BaseEntity entity) throws Exception {
		getHibernateTemplate().update(entity);
	}

	public BaseEntity merge(BaseEntity entity) throws Exception {
		return getHibernateTemplate().merge(entity);
	}

	
	public BaseEntity findById(Class entityClass, Serializable id) throws Exception {
		return (BaseEntity)getHibernateTemplate().get(entityClass, id);
	}

	@Transactional
	public List<? extends BaseEntity> findAll(Class entityClass) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		return (List<BaseEntity>)getHibernateTemplate().findByCriteria(criteria);
	}



}
