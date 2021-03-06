package com.opengest.core.business.services;

public class ConfigParams {

	private String PARAM_DATABASE_DRIVER;
	private String PARAM_DATABASE_URL;
	private String PARAM_DATABASE_USERNAME;
	private String PARAM_DATABASE_PASSWORD;
	private String PARAM_DATABASE_DATASOURCE;
	private String PARAM_DATABASE_START_MODE;

	private String CONTEXT_CONFIG_LOAD_MODE;
	private String CONTEXT_CONFIG_LOAD_MODE_PROPERTIES;
	private String CONTEXT_CONFIG_LOAD_MODE_XML;

	public ConfigParams(String pARAM_DATABASE_DRIVER,
			String pARAM_DATABASE_URL, String pARAM_DATABASE_USERNAME,
			String pARAM_DATABASE_PASSWORD, String pARAM_DATABASE_DATASOURCE,
			String pPARAM_DATABASE_START_MODE) {

		this.PARAM_DATABASE_DRIVER = pARAM_DATABASE_DRIVER;
		this.PARAM_DATABASE_URL = pARAM_DATABASE_URL;
		this.PARAM_DATABASE_USERNAME = pARAM_DATABASE_USERNAME;
		this.PARAM_DATABASE_PASSWORD = pARAM_DATABASE_PASSWORD;
		this.PARAM_DATABASE_DATASOURCE = pARAM_DATABASE_DATASOURCE;
		this.PARAM_DATABASE_START_MODE = pPARAM_DATABASE_START_MODE;
	}

	public ConfigParams(String pARAM_DATABASE_DRIVER,
			String pARAM_DATABASE_URL, String pARAM_DATABASE_USERNAME,
			String pARAM_DATABASE_PASSWORD, String pARAM_DATABASE_DATASOURCE,
			String pPARAM_DATABASE_START_MODE,
			String pCONTEXT_CONFIG_LOAD_MODE,
			String pCONTEXT_CONFIG_LOAD_MODE_PROPERTIES,
			String pCONTEXT_CONFIG_LOAD_MODE_XML) {

		PARAM_DATABASE_DRIVER = pARAM_DATABASE_DRIVER;
		PARAM_DATABASE_URL = pARAM_DATABASE_URL;
		PARAM_DATABASE_USERNAME = pARAM_DATABASE_USERNAME;
		PARAM_DATABASE_PASSWORD = pARAM_DATABASE_PASSWORD;
		PARAM_DATABASE_DATASOURCE = pARAM_DATABASE_DATASOURCE;
		PARAM_DATABASE_START_MODE = pPARAM_DATABASE_START_MODE;

		CONTEXT_CONFIG_LOAD_MODE = pCONTEXT_CONFIG_LOAD_MODE;
		CONTEXT_CONFIG_LOAD_MODE_PROPERTIES = pCONTEXT_CONFIG_LOAD_MODE_PROPERTIES;
		CONTEXT_CONFIG_LOAD_MODE_XML = pCONTEXT_CONFIG_LOAD_MODE_XML;
	}

	public String getPARAM_DATABASE_DRIVER() {
		return PARAM_DATABASE_DRIVER;
	}

	public String getPARAM_DATABASE_URL() {
		return PARAM_DATABASE_URL;
	}

	public String getPARAM_DATABASE_USERNAME() {
		return PARAM_DATABASE_USERNAME;
	}

	public String getPARAM_DATABASE_PASSWORD() {
		return PARAM_DATABASE_PASSWORD;
	}

	public String getPARAM_DATABASE_DATASOURCE() {
		return PARAM_DATABASE_DATASOURCE;
	}

	public String getPARAM_DATABASE_START_MODE() {
		return PARAM_DATABASE_START_MODE;
	}

	public String getCONTEXT_CONFIG_LOAD_MODE() {
		return CONTEXT_CONFIG_LOAD_MODE;
	}

	public String getCONTEXT_CONFIG_LOAD_MODE_PROPERTIES() {
		return CONTEXT_CONFIG_LOAD_MODE_PROPERTIES;
	}

	public String getCONTEXT_CONFIG_LOAD_MODE_XML() {
		return CONTEXT_CONFIG_LOAD_MODE_XML;
	}

}
