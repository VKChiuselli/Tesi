package com.opengest.core.business.services;

import java.util.List;

import com.opengest.core.business.vo.ProvinciaVO;
import com.opengest.core.business.vo.RegioneVO;

public interface ISystemService {
	
    List<RegioneVO> getListaRegioni() throws Exception;
    
	List<ProvinciaVO> getListaProvince() throws Exception;
}
