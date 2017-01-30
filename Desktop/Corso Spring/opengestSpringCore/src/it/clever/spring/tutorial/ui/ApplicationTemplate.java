package it.clever.spring.tutorial.ui;

import it.clever.spring.tutorial.business.entities.User;
import it.clever.spring.tutorial.business.facade.template.OrderServiceFacadeImpl;
import it.clever.spring.tutorial.business.facade.template.UserServiceFacadeImpl;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTemplate {

	public static void main(String[] args) {
		
		AbstractApplicationContext  context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/application-context-template.xml");

		try {
			UserServiceFacadeImpl userService = (UserServiceFacadeImpl) context
					.getBean("userService");

			List<User> userList = userService.findAll();
			for (User u : userList) {
				System.out.println(u);
			}
			userService.tryMerge();
			
			OrderServiceFacadeImpl orderService = (OrderServiceFacadeImpl) context
					.getBean("orderService");
			
			orderService.batchInsert(1000);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Spegnimento controllato del contesto;
		context.registerShutdownHook();
		System.exit(0);
	}
}
