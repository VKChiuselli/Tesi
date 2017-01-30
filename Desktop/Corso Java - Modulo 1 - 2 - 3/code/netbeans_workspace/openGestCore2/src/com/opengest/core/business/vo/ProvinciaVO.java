/**
 * <b> ProvinciaVO.java
 * 
 * <br>
 * 
 *  Classe vo per il trasporto dei dati delle provincie.
 * 
 */
package com.opengest.core.business.vo;

import java.io.Serializable;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class ProvinciaVO implements Serializable {

	private Integer id;
	private Integer idregione;
	private String provincia;
	private String nomeCitta;
	
	
	public ProvinciaVO() {
	}

	public ProvinciaVO(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}

	/**
	 * @return the idregione
	 */
	public Integer getIdregione() {
		return idregione;
	}

	/**
	 * @param idregione the idregione to set
	 */
	public void setIdregione(Integer idregione) {
		this.idregione = idregione;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the nomeCitta
	 */
	public String getNomeCitta() {
		return nomeCitta;
	}

	/**
	 * @param nomeCitta the nomeCitta to set
	 */
	public void setNomeCitta(String nomeCitta) {
		this.nomeCitta = nomeCitta;
	}
	
}
