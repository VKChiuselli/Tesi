package it.clever.spring.tutorial.business.dao.xa;

import it.clever.spring.tutorial.business.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseDaoInterface<T extends BaseEntity, Id extends Serializable> {

	public void persist(BaseEntity entity) throws Exception;

	public Id save(BaseEntity entity) throws Exception;

	public void saveOrUpdate(BaseEntity entity) throws Exception;

	public void update(BaseEntity entity) throws Exception;

	public BaseEntity findById(Class entityClass, Id id) throws Exception;

	public void delete(BaseEntity entity) throws Exception;

	public List<? extends BaseEntity> findAll(Class entityClass) throws Exception;
	
	public BaseEntity merge(BaseEntity entity) throws Exception;

}
