/**
 * <b> IndirizzoVO.java
 * 
 * <br>
 * 
 *  Classe vo per il trasporto dei dati degli indirizzi.
 * 
 */
package com.opengest.core.business.vo;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class IndirizzoVO {

	private String via;
	private String numero;
	private String citta;
	private RegioneVO regione;
	private ProvinciaVO provincia;
	private String codicePostale;
	
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}

	public RegioneVO getRegione() {
		return regione;
	}
	public void setRegione(RegioneVO regione) {
		this.regione = regione;
	}
	public ProvinciaVO getProvincia() {
		return provincia;
	}
	public void setProvincia(ProvinciaVO provincia) {
		this.provincia = provincia;
	}
	public String getCodicePostale() {
		return codicePostale;
	}
	public void setCodicePostale(String codicePostale) {
		this.codicePostale = codicePostale;
	}
	
	

}
