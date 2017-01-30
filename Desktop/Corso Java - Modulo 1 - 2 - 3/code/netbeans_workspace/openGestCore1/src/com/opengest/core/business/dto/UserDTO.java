package com.opengest.core.business.dto;

import java.io.Serializable;

import com.opengest.core.business.vo.IUser;
import com.opengest.core.business.vo.UserVO;

public class UserDTO  implements Serializable {

	private IUser userBean;
	
	public UserDTO() {
		this.userBean = new UserVO();
	}
	
	
	public UserDTO(IUser userBean) {
		this.userBean = userBean;
	}


	public IUser getUserBean() {
		return userBean;
	}
	
}
