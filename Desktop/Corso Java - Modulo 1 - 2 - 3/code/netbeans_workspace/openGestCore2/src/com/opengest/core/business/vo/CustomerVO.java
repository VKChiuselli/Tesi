/**
 * <b> CustomerVO.java
 * 
 * <br>
 * 
 *  Classe vo per il trasporto dei dati dei clienti.
 * 
 */
package com.opengest.core.business.vo;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class CustomerVO implements ICustomer {

	private Long id;
	private String code;
	private String ragsoc;
	private Long piva;
	
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.ICustomer#getId()
	 */
	public Long getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.ICustomer#setId(java.lang.Long)
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.ICustomer#getCode()
	 */
	public String getCode() {
		return code;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.ICustomer#setCode(java.lang.String)
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.ICustomer#getRagsoc()
	 */
	public String getRagsoc() {
		return ragsoc;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.ICustomer#setRagsoc(java.lang.String)
	 */
	public void setRagsoc(String ragsoc) {
		this.ragsoc = ragsoc;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.ICustomer#getPiva()
	 */
	public Long getPiva() {
		return piva;
	}
	/* (non-Javadoc)
	 * @see com.opengest.core.business.vo.ICustomer#setPiva(java.lang.Long)
	 */
	public void setPiva(Long piva) {
		this.piva = piva;
	}
	
	
}
