/**
 * CustomerVO.java
 *
 * robgion
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.patterns.business.model;

/**
 * @author robgion
 *
 */
public class CustomerVO extends BaseVO {

	private String code;
	private String ragsoc;
	private Long piva;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRagsoc() {
		return ragsoc;
	}
	public void setRagsoc(String ragsoc) {
		this.ragsoc = ragsoc;
	}
	public Long getPiva() {
		return piva;
	}
	public void setPiva(Long piva) {
		this.piva = piva;
	}
	
}
