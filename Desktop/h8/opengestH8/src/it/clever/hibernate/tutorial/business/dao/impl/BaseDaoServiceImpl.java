package it.clever.hibernate.tutorial.business.dao.impl;

import java.io.Serializable;

import it.clever.hibernate.tutorial.application.HibernateUtil;
import it.clever.hibernate.tutorial.business.dao.BaseDaoService;
import it.clever.hibernate.tutorial.exception.BusinessException;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class BaseDaoServiceImpl implements BaseDaoService {

	private Session currentSession;
	private Transaction currentTransaction;

	/* (non-Javadoc)
	 * @see it.clever.hibernate.tutorial.business.dao.BaseDaoService#openCurrentSession()
	 */
	@Override
	public Session openCurrentSession() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
		return currentSession;
	}

	/* (non-Javadoc)
	 * @see it.clever.hibernate.tutorial.business.dao.BaseDaoService#beginTransaction()
	 */
	@Override
	public Session beginTransaction() throws BusinessException {
		try {

			currentSession = HibernateUtil.getSessionFactory().openSession();
			currentTransaction = currentSession.beginTransaction();
			return currentSession;

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("DaoFactory",
					"Errore durante l'inizio della transazione", e);
		}
	}

	/* (non-Javadoc)
	 * @see it.clever.hibernate.tutorial.business.dao.BaseDaoService#endTransaction()
	 */
	@Override
	public void endTransaction() throws BusinessException {
		try {

                    currentSession.flush();
			currentTransaction.commit();
			currentSession.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("DaoFactory",
					"Errore durante la fine della transazione", e);
		}
	}

	/* (non-Javadoc)
	 * @see it.clever.hibernate.tutorial.business.dao.BaseDaoService#abortTransaction()
	 */
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

	/* (non-Javadoc)
	 * @see it.clever.hibernate.tutorial.business.dao.BaseDaoService#closeCurrentSession()
	 */
	@Override
	public void closeCurrentSession() {
		currentSession.close();
	}

	/* (non-Javadoc)
	 * @see it.clever.hibernate.tutorial.business.dao.BaseDaoService#getCurrentSession()
	 */
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

}
