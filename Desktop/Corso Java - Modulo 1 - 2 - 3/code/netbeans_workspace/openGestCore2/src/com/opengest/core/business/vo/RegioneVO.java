/**
 * <b> RegioneVO.java
 * 
 * <br>
 * 
 *  Classe vo per il trasporto dei dati delle regioni.
 * 
 */
package com.opengest.core.business.vo;

import java.io.Serializable;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class RegioneVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id = null;
	private String descizione = null;
	
	public RegioneVO() {
	}
	
	public RegioneVO(Integer id) {
		this.id = id;
	}
	public String getDescizione() {
		return descizione;
	}
	public void setDescrizione(String label) {
		this.descizione = label;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
