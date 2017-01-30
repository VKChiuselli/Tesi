package it.clever.spring.tutorial.business.dao;

import it.clever.spring.tutorial.business.exception.BusinessException;
import it.clever.spring.tutorial.business.utils.IServiceUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDaoImpl implements BaseDaoService {

	private IServiceUtil hibernateUtil;
	private Session currentSession;
	private Transaction currentTransaction;

	/**
	 * Injection tramite costruttore.
	 * @param hibernateUtil
	 */
	public BaseDaoImpl(IServiceUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	@Override
	public Session openCurrentSession() {
		currentSession = hibernateUtil.getSessionFactory().openSession();
		return currentSession;
	}

	@Override
	public Session beginTransaction() throws BusinessException {
		try {

			currentSession = hibernateUtil.getSessionFactory().openSession();
			currentTransaction = currentSession.beginTransaction();
			return currentSession;

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("DaoFactory",
					"Errore durante l'inizio della transazione", e);
		}
	}

	@Override
	public void endTransaction() throws BusinessException {
		try {

			currentTransaction.commit();
			currentSession.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("DaoFactory",
					"Errore durante la fine della transazione", e);
		}
	}

	@Override
	public void abortTransaction() throws BusinessException {
		try {

			this.currentTransaction.rollback();
			this.currentSession.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("DaoFactory",
					"Errore durante la rollback della transazione", e);
		}
	}

	@Override
	public void closeCurrentSession() {
		currentSession.close();
	}

	@Override
	public Session getCurrentSession() {
		return currentSession;
	}

	@Override
	public void flush() {
		currentSession.flush();		
	}

	@Override
	public void clear() {
		currentSession.clear();		
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public IServiceUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(IServiceUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

}
