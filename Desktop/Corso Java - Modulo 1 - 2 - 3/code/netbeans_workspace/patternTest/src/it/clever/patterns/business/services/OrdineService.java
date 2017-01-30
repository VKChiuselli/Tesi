/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.clever.patterns.business.services;

import it.clever.patterns.business.bo.OrdineBo;
import it.clever.patterns.business.bo.UserBo;
import it.clever.patterns.business.model.OrdineVO;
import it.clever.patterns.business.model.UserVO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author v.chiuselli
 */
public class OrdineService {
    
    public List<OrdineVO> retrieveAllUsersFromLocal() throws SQLException {
		return new OrdineBo().retrieveAllUsersFromLocal();
	}
    
    
}
