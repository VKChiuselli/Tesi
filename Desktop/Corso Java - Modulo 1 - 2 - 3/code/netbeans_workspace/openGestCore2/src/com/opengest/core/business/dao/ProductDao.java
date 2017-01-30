/**
 * <b> UserDao.java</b>
 * 
 * <br>
 * 
 *  Classe bo per l'accesso ai dati della tabella prodotti.
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
import com.opengest.core.business.vo.IProduct;
import com.opengest.core.business.vo.ProductVO;


/**
 * @author Roberto Giontella
 * 
 */
public class ProductDao {
	
	
	public ProductDao(){
	}
	
	
	/**
	 * Metodo finder per la ricerca del prodotto tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws Exception
	 */
	public IProduct findById(Long id) throws SQLException, Exception  {
		
		IProduct product = null;
		PreparedStatement pstmt = ServiceFactory.getInstance().getCurrentServiceLocal()
										.prepareStatement(IApplicationConstants.QUERY_FIND_PRODUCT_BY_PRIMARY_KEY);		
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs != null) {
			product = new ProductVO();
			while(rs.next()){
				product.setPrice(rs.getBigDecimal("prezzo"));
				product.setDescription(rs.getString("descrizione"));
				product.setCode(rs.getString("codice"));
				product.setId(rs.getLong("id_prodotto"));
			}				
		}
		return product;
	}
	
	/**
	 * Metodo per la cancellazione del prodotto tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws Exception
	 */
	public void delete(Long id) throws SQLException, Exception  {
		
		PreparedStatement pstmt = ServiceFactory.getInstance().getCurrentServiceLocal()
				.prepareStatement(IApplicationConstants.QUERY_DELETE_PRODUCT_BY_PRIMARY_KEY);		
		pstmt.setLong(1, id);
		pstmt.executeUpdate();
	}
	
	/**
	 * Metodo per la registrazione del prodotto nella base dati.
	 *  
	 * @param product
	 * void
	 * @throws Exception 
	 *
	 */
	public void save(IProduct product) throws SQLException, Exception  {
		
		try {
			
			  //Recupero della lista delle stringhe delle citt�.
			  PreparedStatement pst = ServiceFactory.getInstance().getCurrentServiceLocal()
					  						.prepareStatement(IApplicationConstants.QUERY_SAVE_PRODUCT);
	    		
			  pst.setString(1, product.getCode());
			  pst.setString(2, product.getDescription());
			  pst.setBigDecimal(3, product.getPrice());
			  
			  //Censimento del prodotto nel database.
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
	 * Metodo per la modifica del prodotto nella base dati.
	 *  
	 * @param product
	 * void
	 * @throws Exception 
	 *
	 */
	public void update(IProduct product) throws SQLException, Exception  {
		
		try {
			
			//Recupero della lista delle stringhe delle citt�.
			PreparedStatement pst = ServiceFactory.getInstance().getCurrentServiceLocal()
					.prepareStatement(IApplicationConstants.QUERY_UPDATE_PRODUCT);
			
			  pst.setString(1, product.getCode());
			  pst.setString(2, product.getDescription());
			  pst.setBigDecimal(3, product.getPrice());
			  pst.setLong(4, product.getId());
			
			//Censimento del prodotto nel database.
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
	 * Metodo finder per la ricerca di tutti i prodotti.
	 * @param id
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws Exception
	 */
	public List<IProduct> findAll() throws SQLException, Exception  {
		
		List<IProduct> retlist = null;
		Statement stmt = ServiceFactory.getInstance().getCurrentServiceLocal()
										.createStatement();		
		ResultSet rs = stmt.executeQuery(IApplicationConstants.QUERY_FIND_All_PRODUCTS);
		if(rs != null) {
			retlist = new ArrayList<IProduct>();
			while(rs.next()){
				IProduct prod = new ProductVO();
				prod.setId(rs.getLong("id_prodotto"));
				prod.setCode(rs.getString("codice"));
				prod.setDescription(rs.getString("descrizione"));
				prod.setPrice(rs.getBigDecimal("prezzo"));
				retlist.add(prod);
			}				
		}
		return retlist;
	}	
	
	/**
	 * Metodo per il controllo dell'esistenza di un codice prodotto.
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
					.prepareStatement(IApplicationConstants.QUERY_EXIST_CODE);
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
