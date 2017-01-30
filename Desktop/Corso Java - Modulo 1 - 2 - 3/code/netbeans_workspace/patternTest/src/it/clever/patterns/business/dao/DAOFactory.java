/**
 * DAOFactory.java
 *
 * robgion
 * www.2clever.it
 *
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.patterns.business.dao;

/**
 * @author robgion
 *
 */
public abstract class DAOFactory {

    public static final Class JDBC = it.clever.patterns.business.dao.impl.JdbcDaoFactory.class;

    public static DAOFactory instance(Class factory) {
        try {
            return (DAOFactory) factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);
        }
    }

    public abstract UserDao getUserDao();

    public abstract CustomerDao getCustomerDao();

    public abstract OrdineDao getOrdineDao();
}
