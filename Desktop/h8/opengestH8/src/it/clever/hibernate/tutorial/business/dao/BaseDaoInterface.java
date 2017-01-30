package it.clever.hibernate.tutorial.business.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDaoInterface<T, Id extends Serializable> {

	public void persist(T entity) throws Exception;

	public Id save(T entity) throws Exception;

	public void update(T entity) throws Exception;

	public T findById(Id id) throws Exception;

	public void delete(T entity) throws Exception;

	public List<T> findAll() throws Exception;

}