package com.nsi.rsni.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by acerioni on 01/12/2016.
 */
public interface BaseDaoInterface<T, Id extends Serializable> {

    public void persist(T entity) throws Exception;

    public Id save(T entity) throws Exception;

    public void update(T entity) throws Exception;

    public T findById(Id id) throws Exception;

    public void delete(T entity) throws Exception;

    public List<T> findAll() throws Exception;

}