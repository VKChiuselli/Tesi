/**
 * GenericDAO.java
 *
 * robgion
 * www.2clever.it
 *
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.patterns.business.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import it.clever.patterns.business.model.BaseVO;

/**
 * @author robgion
 *
 */
public interface GenericDAO<T extends BaseVO, ID extends Serializable> {

    public T findById(ID id, boolean lock) throws SQLException;

    public List<T> findAll() throws SQLException;

    public T makePersistent(T entity) throws SQLException;
}
