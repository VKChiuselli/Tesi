/**
 * <b> UserDao.java
 * 
 * <br>
 * 
 *  Classe bo per l'accesso ai dati della tabella utente.
 * 
 */
package com.opengest.core.business.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opengest.core.business.params.IApplicationConstants;
import com.opengest.core.business.services.impl.ServiceFactory;
import com.opengest.core.business.vo.IUser;
import com.opengest.core.business.vo.UserVO;


/**
 * @author Roberto Giontella
 * 
 */
public class UserDao {
	
	
	public UserDao(){
	}
	
	/**
	 * Metodo che controlla l'autorizzazione dell'utente durante il login.
	 * 
	 * @param username
	 * @param password
	 * @return
	 * boolean
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 *
	 */
	public boolean authorization(String username, String password) throws SQLException, Exception  {
		
		boolean authorized = false;
		
		//Ricerca della presenza dei dati di login inseriti.
		PreparedStatement pstmt = ServiceFactory.getInstance().getCurrentServiceLocal()
										.prepareStatement(IApplicationConstants.QUERY_FIND_USER_BY_USERNAME_PASSWORD);
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
		return authorized;
	}
	
	/**
	 * Metodo finder per la ricerca dell'utente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws Exception
	 */
	public IUser findById(Long id) throws SQLException, Exception  {
		
		IUser retuser = null;
		PreparedStatement pstmt = ServiceFactory.getInstance().getCurrentServiceLocal()
										.prepareStatement(IApplicationConstants.QUERY_FIND_USER_BY_PRIMARY_KEY);		
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs != null) {
			retuser = new UserVO();
			while(rs.next()){
				retuser.getAccount().setUsername(rs.getString("username"));
				retuser.getAccount().setPassword(rs.getString("password"));
				retuser.getAccount().setEmail(rs.getString("email"));
				retuser.setNome(rs.getString("nome"));
				retuser.setCognome(rs.getString("cognome"));
				retuser.setId(rs.getLong("id_utente"));
			}				
		}
		return retuser;
	}
	
	/**
	 * Metodo per la cancellazione dell'utente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws Exception
	 */
	public void delete(Long id) throws SQLException, Exception  {
		
		PreparedStatement pstmt = ServiceFactory.getInstance().getCurrentServiceLocal()
				.prepareStatement(IApplicationConstants.QUERY_DELETE_USER_BY_PRIMARY_KEY);		
		pstmt.setLong(1, id);
		pstmt.executeUpdate();
	}
	
	/**
	 * Metodo per la registrazione dell'utente nella base dati.
	 *  
	 * @param user
	 * void
	 * @throws Exception 
	 *
	 */
	public void save(IUser user) throws SQLException,Exception  {
		
		try {
			
			  //Recupero della lista delle stringhe delle citt�.
			  PreparedStatement pst = ServiceFactory.getInstance().getCurrentServiceLocal()
					  						.prepareStatement(IApplicationConstants.QUERY_SAVE_USER);
	    		
			  pst.setString(1, user.getAccount().getUsername());
			  pst.setString(2, user.getAccount().getPassword());
			  pst.setString(3, user.getNome());
			  pst.setString(4, user.getCognome());
			  pst.setString(5, user.getAccount().getEmail());
			  pst.setLong(6, user.getResidenza().getProvincia().getId());
			  pst.setLong(7, user.getResidenza().getRegione().getId());
			  
			  //Censimento dell'utente nel database.
			  int numRowsChanged = pst.executeUpdate();
			  System.out.println("Aggiornati utenti: " + numRowsChanged);
			  
		} catch(ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
				throw cnfe;
		} catch(SQLException sqle) {
				sqle.printStackTrace();
				throw sqle;
		}
	}
	/**
	 * Metodo per la modifica dell'utente nella base dati.
	 *  
	 * @param user
	 * void
	 * @throws Exception 
	 *
	 */
	public void update(IUser user) throws SQLException, Exception  {
		
		try {
			
			//Recupero della lista delle stringhe delle citt�.
			PreparedStatement pst = ServiceFactory.getInstance().getCurrentServiceLocal()
					.prepareStatement(IApplicationConstants.QUERY_UPDATE_USER);
			
			pst.setString(1, user.getAccount().getUsername());
			pst.setString(2, user.getAccount().getPassword());
			pst.setString(3, user.getAccount().getEmail());
			pst.setString(4, user.getNome());
			pst.setString(5, user.getCognome());
			pst.setLong(6, user.getId());
			
			//Censimento dell'utente nel database.
			int numRowsChanged = pst.executeUpdate();
			System.out.println("Aggiornati utenti: " + numRowsChanged);
			
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			throw cnfe;
		} catch(SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}
	}
	
	/**
	 * Metodo finder per la ricerca di tutti gli utenti.
	 * @param id
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws Exception
	 */
	public List<UserVO> findAll() throws SQLException, Exception  {
		
		List<UserVO> retuserList = null;
		Statement stmt = ServiceFactory.getInstance().getCurrentServiceLocal()
										.createStatement();		
		ResultSet rs = stmt.executeQuery(IApplicationConstants.QUERY_FIND_All_USERS);
		if(rs != null) {
			retuserList = new ArrayList<UserVO>();
			while(rs.next()){
				UserVO retuser = new UserVO();
				retuser.setId(rs.getLong("id_utente"));
				retuser.getAccount().setUsername(rs.getString("username"));
				retuser.getAccount().setPassword(rs.getString("password"));
				retuser.getAccount().setEmail(rs.getString("email"));
				retuser.setNome(rs.getString("nome"));
				retuser.setCognome(rs.getString("cognome"));
				retuserList.add(retuser);
			}				
		}
		return retuserList;
	}

	/**
	 * Metodo per il controllo dell'esistenza di uno username
	 * @param sql
	 * @param user
	 * @return
	 * @throws SQLException
	 */
    public boolean exist(String username) throws SQLException, Exception  {
        ResultSet resultSet = null;
        boolean exist = false;

        try {
			PreparedStatement pst = ServiceFactory.getInstance().getCurrentServiceLocal()
					.prepareStatement(IApplicationConstants.QUERY_EXIST_USERNAME);
			pst.setString(1, username);
            resultSet = pst.executeQuery();
            exist = resultSet.next();
        } catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			throw cnfe;
		}  catch (SQLException e) {
            throw new SQLException(e);
        }
        return exist;
    }
	
}
