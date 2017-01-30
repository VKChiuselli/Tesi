/**
 * <b> SystemDao.java
 * 
 * <br>
 * 
 *  Classe dao per la gestione delle operazioni sulle tabelle di sistema.
 * 
 */
package com.opengest.core.business.bo;

import java.io.Serializable;
import java.util.List;

import com.opengest.core.business.dao.SystemDao;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.ProvinciaVO;
import com.opengest.core.business.vo.RegioneVO;


/**
 * @author Roberto Giontella.
 * 
 */

public class SystemBO implements Serializable {

	
	public SystemBO(){
	}
	
	/**
	 *
	 * Metodo per il recupero della lista delle regioni.
	 *  
	 * @return
	 * List
	 *
	 */
	public List<RegioneVO> getListaRegioni() throws BusinessException {
		
		try {
			return new SystemBO().getListaRegioni();
		} catch (Exception e) {
			throw new BusinessException("[SystemDao.getListaRegioni]", e);
		} 
	}
		
	/**
	 * Metodo per il recupero della lista delle citt�.
	 *  
	 * @return
	 * List
	 *
	 */
	public List<ProvinciaVO> getListaProvince() throws BusinessException {
		
		try {
			return new SystemBO().getListaProvince();
		} catch (Exception e) {
			throw new BusinessException("[SystemDao.getListaProvince]", e);
		}
	}
	

}
