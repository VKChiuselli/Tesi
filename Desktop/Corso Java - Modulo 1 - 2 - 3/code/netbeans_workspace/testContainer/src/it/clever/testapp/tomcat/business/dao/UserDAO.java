/**
 * <b> UserDAO.java
 * 
 * <br>
 * 
 *  Classe dao per la gestione delle operazioni sul modulo utente.
 * 
 */
package it.clever.testapp.tomcat.business.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.clever.testapp.tomcat.business.exceptions.BusinessException;
import it.clever.testapp.tomcat.business.model.UserVO;
import it.clever.testapp.tomcat.business.services.impl.ServiceFactory;
import it.clever.testapp.tomcat.business.utils.IApplicationConstants;


public class UserDAO {
	
	public UserDAO(){
	}
	
	/**
	 * Metodo per l'autorizzaizone dell'utente nella sessione di login.
	 */
	public boolean authorization(String username, String password) throws BusinessException {
		
		boolean authorized = false;
		
		//Ricerca della presenza dei dati di login inseriti.
		PreparedStatement pstmt = ServiceFactory.getInstance().getCurrentServiceLocal()
										.prepareStatement(IApplicationConstants.QUERY_FIND_USER_BY_USERNAME_PASSWORD);
		try {
			pstmt.setString(1, username);
			pstmt.setString(2, password);		
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				//Riga trovata, quindi l'utente ha accesso all'applicazione.
				authorized = true;
			}else{
				//Riga non trovata, quindi l'utente non � ancora registrato o i dati inseriti non sono validi.
				authorized =  false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Errore grave", e);
		}
		return authorized;
	}

	public List<UserVO> findAll() throws BusinessException {
		try {
			List<UserVO> retuserList = null;
			Statement stmt = ServiceFactory.getInstance().getCurrentServiceLocal()
											.createStatement();		
			ResultSet rs = stmt.executeQuery(IApplicationConstants.QUERY_FIND_All_USERS);
			if(rs != null) {
				retuserList = new ArrayList<UserVO>();
				while(rs.next()){
					UserVO retuser = new UserVO();
					retuser.setId(rs.getLong("id_utente"));
					retuser.setNome(rs.getString("nome"));
					retuser.setCognome(rs.getString("cognome"));
					retuserList.add(retuser);
				}				
			}
			return retuserList;
		} catch (Exception e) {
			throw new BusinessException("[UserDAO.findAll]", e);
		}
	}
}
