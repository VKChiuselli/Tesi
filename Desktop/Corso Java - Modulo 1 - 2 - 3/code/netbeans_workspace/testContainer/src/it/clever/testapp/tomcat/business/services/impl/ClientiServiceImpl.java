/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.clever.testapp.tomcat.business.services.impl;

import it.clever.testapp.tomcat.business.dao.ClientiDAO;
import it.clever.testapp.tomcat.business.dao.UserDAO;
import it.clever.testapp.tomcat.business.exceptions.BusinessException;
import it.clever.testapp.tomcat.business.model.ClientiVO;
import it.clever.testapp.tomcat.business.model.UserVO;
import it.clever.testapp.tomcat.business.services.*;
import java.util.List;

/**
 *
 * @author v.chiuselli
 */
public class ClientiServiceImpl implements IClientiService{

    @Override
    public boolean authorization(String username, String password) throws Exception {
   return new ClientiDAO().authorization(username, password);    }

    @Override
    public ClientiVO findUserById(Long id) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveUser(ClientiVO user) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(ClientiVO user) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClientiVO> listUsers() throws BusinessException {
     	return new ClientiDAO().findAll();    }

    @Override
    public void deleteUser(Long id) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existUsername(String username) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
