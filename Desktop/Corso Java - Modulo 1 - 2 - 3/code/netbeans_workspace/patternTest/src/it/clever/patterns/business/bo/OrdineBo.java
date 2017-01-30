/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.clever.patterns.business.bo;

import it.clever.patterns.business.dao.DAOFactory;
import it.clever.patterns.business.dao.OrdineDao;
import it.clever.patterns.business.dao.UserDao;
import it.clever.patterns.business.model.OrdineVO;
import it.clever.patterns.business.model.UserVO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author v.chiuselli
 */
public class OrdineBo {

    public List<OrdineVO> retrieveAllUsersFromLocal() throws SQLException {

        List<OrdineVO> result = null;
        DAOFactory jdbcFactory = DAOFactory.instance(DAOFactory.JDBC);
        OrdineDao ordineDao = jdbcFactory.getOrdineDao();
        result = ordineDao.findAll();

        return result;
    }

}