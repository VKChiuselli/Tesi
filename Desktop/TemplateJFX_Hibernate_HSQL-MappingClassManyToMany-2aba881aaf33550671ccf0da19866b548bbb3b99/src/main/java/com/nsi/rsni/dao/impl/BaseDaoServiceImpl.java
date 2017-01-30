package com.nsi.rsni.dao.impl;

import com.nsi.rsni.dao.BaseDaoServiceInterface;
import com.nsi.rsni.exception.BusinessException;
import com.nsi.rsni.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by acerioni on 01/12/2016.
 */
public class BaseDaoServiceImpl implements BaseDaoServiceInterface{

    private Session currentSession;
    private Transaction currentTransaction;

    @Override
    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSession();
        return currentSession;
    }

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
}
