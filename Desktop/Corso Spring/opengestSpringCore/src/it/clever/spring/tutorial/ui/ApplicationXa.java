package it.clever.spring.tutorial.ui;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.clever.spring.tutorial.business.entities.User;
import it.clever.spring.tutorial.business.facade.xa.WarehouseUserServiceFacadeImpl;
import it.clever.spring.tutorial.business.facade.xa.XaServiceFacade;

public class ApplicationXa {

	public static void main(String[] args) {
		
		AbstractApplicationContext  context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/application-context-xa.xml");

		try {
			
			XaServiceFacade xaServiceFacade = (XaServiceFacade) context
					.getBean("xaServiceFacade");

			xaServiceFacade.updateUserXa();
			
			/*
			 */
			WarehouseUserServiceFacadeImpl wsf = (WarehouseUserServiceFacadeImpl)context
					.getBean("warehouseUserService");
			List<User> userList = wsf.findAll();
			for (User u : userList) {
				System.out.println(u);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Spegnimento controllato del contesto;
		context.registerShutdownHook();
		System.exit(0);
	}
}
