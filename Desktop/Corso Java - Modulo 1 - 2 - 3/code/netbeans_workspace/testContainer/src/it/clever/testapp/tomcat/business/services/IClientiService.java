/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.clever.testapp.tomcat.business.services;

import it.clever.testapp.tomcat.business.exceptions.BusinessException;
import it.clever.testapp.tomcat.business.model.ClientiVO;
import it.clever.testapp.tomcat.business.model.UserVO;
import java.util.List;

/**
 *
 * @author v.chiuselli
 */
public interface IClientiService {

    boolean authorization(String username, String password) throws Exception;

    ClientiVO findUserById(Long id) throws BusinessException;

    void saveUser(ClientiVO user) throws BusinessException;

    void updateUser(ClientiVO user) throws BusinessException;

    List<ClientiVO> listUsers() throws BusinessException;

    void deleteUser(Long id) throws BusinessException;

    boolean existUsername(String username) throws BusinessException;
}
