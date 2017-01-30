package it.clever.hibernate.tutorial.business.dao;

import it.clever.hibernate.tutorial.exception.BusinessException;

import org.hibernate.Session;

public interface BaseDaoService {

	public abstract Session openCurrentSession();

	/**
	 * Metodo per l'inizio della transazione.
	 * 
	 * @throws BusinessException
	 */
	public abstract Session beginTransaction() throws BusinessException;

	/**
	 * Metodo per la fine della transazione.
	 * 
	 * @throws BusinessException
	 */
	public abstract void endTransaction() throws BusinessException;

	/**
	 * Metodo per la rollback della transazione.
	 * 
	 * @throws BusinessException
	 */
	public abstract void abortTransaction() throws BusinessException;

	public abstract void closeCurrentSession();

	public abstract Session getCurrentSession();

	public abstract void flush();
	
	public abstract void clear();
	

}