/**
 * <b> SystemDao.java
 * 
 * <br/>
 * 
 * Classe per la gestione dei dati di sistema.
 * 
 */
package com.opengest.core.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opengest.core.business.params.IApplicationConstants;
import com.opengest.core.business.services.impl.JDBCService;
import com.opengest.core.business.services.impl.ServiceFactory;
import com.opengest.core.business.vo.ProvinciaVO;
import com.opengest.core.business.vo.RegioneVO;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class SystemDao {
	
	/**
	 *
	 * Metodo per il recupero della lista delle regioni.
	 *  
	 * @return
	 * List
	 *
	 */
	public List<RegioneVO> getListaRegioni() throws SQLException, Exception {
		
		List<RegioneVO> retlist = new ArrayList<RegioneVO>();
		
		//Recupero della lista delle stringhe delle regioni.
		Statement pstmt = ServiceFactory.getInstance().getCurrentServiceLocal()
										 .createStatement();
		ResultSet rs = pstmt.executeQuery(IApplicationConstants.QUERY_FIND_REGIONI_LIST);
		
		while(rs.next()){
			RegioneVO rb = new RegioneVO();
			Integer id = rs.getInt("id_regione");
			String regione = rs.getString("codice");
			rb.setId(id);
			rb.setDescrizione(regione);
			retlist.add(rb);
		}		
		return retlist;  
	}
		
	/**
	 * Metodo per il recupero della lista delle provincie.
	 *  
	 * @return
	 * List
	 *
	 */
	public List<ProvinciaVO> getListaProvince() throws SQLException, Exception  {
		
		List<ProvinciaVO> retlist = new ArrayList<ProvinciaVO>();
		
		//Recupero della lista delle stringhe delle citt�.
		Statement pstmt = ServiceFactory.getInstance().getCurrentServiceLocal()
				.createStatement();
		ResultSet rs = pstmt.executeQuery(IApplicationConstants.QUERY_FIND_CITTA_LIST);
		
		while(rs.next()){
			Integer id = rs.getInt("id_provincia");
			String nomeCitta = rs.getString("nome_citta");
			String provincia = rs.getString("codice");
			Integer idregione = rs.getInt("id_regione");
			ProvinciaVO pb = new ProvinciaVO();
			pb.setId(id);
			pb.setProvincia(provincia);
			pb.setIdregione(idregione);
			pb.setNomeCitta(nomeCitta);
			retlist.add(pb);
		}			
		return retlist;  
	}
}
