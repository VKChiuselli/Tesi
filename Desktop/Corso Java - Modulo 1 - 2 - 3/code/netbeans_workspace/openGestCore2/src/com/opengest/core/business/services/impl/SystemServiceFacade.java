package com.opengest.core.business.services.impl;

import java.util.List;

import com.opengest.core.business.bo.SystemBO;
import com.opengest.core.business.services.ISystemService;
import com.opengest.core.business.vo.ProvinciaVO;
import com.opengest.core.business.vo.RegioneVO;

public class SystemServiceFacade implements ISystemService {
	
	public List<RegioneVO> getListaRegioni() throws Exception {
		return new SystemBO().getListaRegioni();  
	}
		
	
	public List<ProvinciaVO> getListaProvince() throws Exception {
		return new SystemBO().getListaProvince();
	}
}
