/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.clever.patterns.business.dao.impl;

import it.clever.patterns.business.dao.JdbcManager;
import it.clever.patterns.business.dao.OrdineDao;
import it.clever.patterns.business.model.OrdineVO;
import it.clever.patterns.business.model.UserVO;
import it.clever.patterns.business.utils.IApplicationConstants;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author v.chiuselli
 */
public class OrdineDaoImpl implements OrdineDao{

    private JdbcManager jdbcManager;
    
    
       public OrdineDaoImpl(JdbcManager jdbcManager) {
		super();
		this.jdbcManager = jdbcManager;
	}
    
    
    @Override
    public OrdineVO findById(Long id, boolean lock) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrdineVO> findAll() throws SQLException {
 
        List<OrdineVO> result =  null;
   
        
        	Statement stmt = jdbcManager.createStatement();		
		ResultSet rs = stmt.executeQuery(IApplicationConstants.QUERY_FIND_All_ORDINI);
		if(rs != null) {
			result = new ArrayList<OrdineVO>();
			while(rs.next()){
				OrdineVO retuser = new OrdineVO();
				retuser.setId(rs.getLong("id_ordine"));
                                retuser.setId_cliente(rs.getInt("id_cliente"));
                                retuser.setId_prodotto(rs.getInt("id_prodotto"));
				retuser.setAmmontare(rs.getInt("ammontare"));
				
				retuser.setData_ordine(rs.getDate("data_ordine"));
				retuser.setQuantita(rs.getInt("quantita"));
				retuser.setVersion(rs.getInt("version"));
				result.add(retuser);
			}				
		}
        
        
        
        
        return result;

    }

    @Override
    public OrdineVO makePersistent(OrdineVO entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
