/**
 * @author 2Clever.IT
 *
 */
package it.clever.hibernate.tutorial.business.dao;

import it.clever.hibernate.tutorial.business.entity.Customer;
import it.clever.hibernate.tutorial.business.entity.CustomerContract;
import it.clever.hibernate.tutorial.business.entity.Product;
import it.clever.hibernate.tutorial.business.entity.User;
import java.math.BigDecimal;

import java.sql.SQLException;

/**
 * @author 2Clever.IT
 *
 */
public interface ProductDao extends BaseDaoInterface<Product, Integer> {

    public Integer inserimentoProdotto(String codice, String descrizione,  BigDecimal prezzo) throws Exception;
}
