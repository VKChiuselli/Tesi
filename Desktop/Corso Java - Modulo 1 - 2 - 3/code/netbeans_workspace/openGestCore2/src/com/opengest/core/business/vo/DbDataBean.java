package com.opengest.core.business.vo;

public class DbDataBean {

	private String serviceType;
	private String dbdriver;
	private String dburl;
	private String dbusername;
	private String dbpassword;
	
	public DbDataBean(String dbdriver, String dburl, String dbusername, String dbpassword, String serviceType) {
		super();
		this.dbdriver = dbdriver;
		this.dburl = dburl;
		this.dbusername = dbusername;
		this.dbpassword = dbpassword;
		this.serviceType = serviceType;
	}

	/**
	 * @return the dbdriver
	 */
	public String getDbdriver() {
		return dbdriver;
	}

	/**
	 * @param dbdriver the dbdriver to set
	 */
	public void setDbdriver(String dbdriver) {
		this.dbdriver = dbdriver;
	}

	/**
	 * @return the dburl
	 */
	public String getDburl() {
		return dburl;
	}

	/**
	 * @param dburl the dburl to set
	 */
	public void setDburl(String dburl) {
		this.dburl = dburl;
	}

	/**
	 * @return the dbusername
	 */
	public String getDbusername() {
		return dbusername;
	}

	/**
	 * @param dbusername the dbusername to set
	 */
	public void setDbusername(String dbusername) {
		this.dbusername = dbusername;
	}

	/**
	 * @return the dbpassword
	 */
	public String getDbpassword() {
		return dbpassword;
	}

	/**
	 * @param dbpassword the dbpassword to set
	 */
	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}

	/**
	 * @return the serviceType
	 */
	public int getServiceType() {
		return Integer.parseInt(this.serviceType);
	}

	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
}
