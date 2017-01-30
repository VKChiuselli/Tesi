package com.nsi.rsni.dao;

import com.nsi.rsni.exception.BusinessException;
import org.hibernate.Session;

/**
 * Created by acerioni on 01/12/2016.
 */
public interface BaseDaoServiceInterface {

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
