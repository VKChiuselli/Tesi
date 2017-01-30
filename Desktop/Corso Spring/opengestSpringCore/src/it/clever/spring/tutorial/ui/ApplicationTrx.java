package it.clever.spring.tutorial.ui;

import it.clever.spring.tutorial.business.entities.User;
import it.clever.spring.tutorial.business.facade.trx.UserServiceFacadeImpl;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTrx {

	public static void main(String[] args) {
		
		AbstractApplicationContext  context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/application-context-configtrx.xml");

		try {
			UserServiceFacadeImpl userService = (UserServiceFacadeImpl) context
					.getBean("userService");

			List<User> userList = userService.findAll();
			for (User u : userList) {
				System.out.println(u);
			}
			userService.tryMerge();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Spegnimento controllato del contesto;
		context.registerShutdownHook();
		System.exit(0);
	}
}
