package it.clever.spring.tutorial.business.facade.xa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.clever.spring.tutorial.business.entities.User;

@Service
public class XaServiceFacade {

	private UserServiceFacadeImpl userService;
	
	private WarehouseUserServiceFacadeImpl warehouseUserService;
	
	@Transactional(value= "xaTransactionManager", rollbackFor=Exception.class )
	public void updateUserXa() throws Exception {
		
		String newUsername = "user0";
		
		User user = userService.findById(1);
		user.setUsername(newUsername);
		userService.update(user);
		
		User warehouse = warehouseUserService.findById(1L);
		warehouse.setUsername(newUsername);
		warehouseUserService.update(warehouse);
		
		throw new Exception("Abort Transaction");
	}
	
	
	public UserServiceFacadeImpl getUserService() {
		return userService;
	}

	public void setUserService(UserServiceFacadeImpl userService) {
		this.userService = userService;
	}

	public WarehouseUserServiceFacadeImpl getWarehouseUserService() {
		return warehouseUserService;
	}

	public void setWarehouseUserService(
			WarehouseUserServiceFacadeImpl warehouseUserService) {
		this.warehouseUserService = warehouseUserService;
	}
	
	
}
