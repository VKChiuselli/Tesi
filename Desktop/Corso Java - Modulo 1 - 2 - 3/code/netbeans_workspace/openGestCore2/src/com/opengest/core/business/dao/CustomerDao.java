/**
 * <b> CustomerDao.java</b>
 * 
 * <br>
 * 
 *  Classe bo per l'accesso ai dati della tabella clienti.
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
import com.opengest.core.business.vo.CustomerVO;
import com.opengest.core.business.vo.ICustomer;


/**
 * @author Roberto Giontella
 * 
 */
public class CustomerDao {
	
	
	public CustomerDao(){
	}
	
	
	/**
	 * Metodo finder per la ricerca del cliente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws Exception
	 */
	public ICustomer findById(Long id) throws SQLException, Exception  {
		
		ICustomer product = null;
		PreparedStatement pstmt = ServiceFactory.getInstance().getCurrentServiceLocal()
										.prepareStatement(IApplicationConstants.QUERY_FIND_CUSTOMER_BY_PRIMARY_KEY);		
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs != null) {
			product = new CustomerVO();
			while(rs.next()){
				product.setId(rs.getLong(1));
				product.setCode(rs.getString(2));
				product.setRagsoc(rs.getString(3));
				product.setPiva(rs.getLong(4));
			}				
		}
		return product;
	}
	
	/**
	 * Metodo per la cancellazione del cliente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws Exception
	 */
	public void delete(Long id) throws SQLException, Exception  {
		
		PreparedStatement pstmt = ServiceFactory.getInstance().getCurrentServiceLocal()
				.prepareStatement(IApplicationConstants.QUERY_DELETE_CUSTOMER_BY_PRIMARY_KEY);		
		pstmt.setLong(1, id);
		pstmt.executeUpdate();
	}
	
	/**
	 * Metodo per la registrazione del cliente nella base dati.
	 *  
	 * @param product
	 * void
	 * @throws Exception 
	 *
	 */
	public void save(ICustomer product) throws SQLException, Exception  {
		
		try {
			
			  //Recupero della lista delle stringhe delle citt�.
			  PreparedStatement pst = ServiceFactory.getInstance().getCurrentServiceLocal()
					  						.prepareStatement(IApplicationConstants.QUERY_SAVE_CUSTOMER);
	    		
			  pst.setString(1, product.getCode());
			  pst.setString(2, product.getRagsoc());
			  pst.setLong(3, product.getPiva());
			  
			  //Censimento del cliente nel database.
			  int numRowsChanged = pst.executeUpdate();
			  System.out.println("Aggiornati prodotti: " + numRowsChanged);
			  
		} catch(ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
				throw cnfe;
		} catch(SQLException sqle) {
				sqle.printStackTrace();
				throw sqle;
		}
	}
	/**
	 * Metodo per la modifica del cliente nella base dati.
	 *  
	 * @param product
	 * void
	 * @throws Exception 
	 *
	 */
	public void update(ICustomer product) throws SQLException, Exception  {
		
		try {
			
			//Recupero della lista delle stringhe delle citt�.
			PreparedStatement pst = ServiceFactory.getInstance().getCurrentServiceLocal()
					.prepareStatement(IApplicationConstants.QUERY_UPDATE_CUSTOMER);
			
			  pst.setString(1, product.getCode());
			  pst.setString(2, product.getRagsoc());
			  pst.setLong(3, product.getPiva());
			  pst.setLong(4, product.getId());
			
			//Censimento del cliente nel database.
			int numRowsChanged = pst.executeUpdate();
			System.out.println("Aggiornati clienti: " + numRowsChanged);
			
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			throw cnfe;
		} catch(SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}
	}
	
	/**
	 * Metodo finder per la ricerca di tutti i prodotti.
	 * @param id
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws Exception
	 */
	public List<ICustomer> findAll() throws SQLException, Exception  {
		
		List<ICustomer> retlist = null;
		Statement stmt = ServiceFactory.getInstance().getCurrentServiceLocal()
										.createStatement();		
		ResultSet rs = stmt.executeQuery(IApplicationConstants.QUERY_FIND_All_CUSTOMERS);
		if(rs != null) {
			retlist = new ArrayList<ICustomer>();
			while(rs.next()){
				ICustomer prod = new CustomerVO();
				prod.setId(rs.getLong(1));
				prod.setCode(rs.getString(2));
				prod.setRagsoc(rs.getString(3));
				prod.setPiva(rs.getLong(4));
				retlist.add(prod);
			}				
		}
		return retlist;
	}	
	
	/**
	 * Metodo per il controllo dell'esistenza di un codice cliente.
	 * @param sql
	 * @param code
	 * @return
	 * @throws SQLException
	 */
    public boolean exist(String code) throws SQLException, Exception  {
        ResultSet resultSet = null;
        boolean exist = false;

        try {
			PreparedStatement pst = ServiceFactory.getInstance().getCurrentServiceLocal()
					.prepareStatement(IApplicationConstants.QUERY_EXIST_CUSTOMER_CODE);
			pst.setString(1, code);
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
