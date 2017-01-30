package it.clever.spring.tutorial.ui;

import it.clever.spring.tutorial.business.entities.User;
import it.clever.spring.tutorial.business.facade.annotations.UserServiceFacadeImpl;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationAnnotations {

	public static void main(String[] args) {
		
		AbstractApplicationContext  context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/application-context-annotated.xml");

		try {
			UserServiceFacadeImpl userService = (UserServiceFacadeImpl) context
					.getBean("userService");

			List<User> userList = userService.findAll();
			for (User u : userList) {
				System.out.println(u);
			}
			
			/*
			 * Test update con con considerazioni sul merge.
			 */
			userService.tryMerge();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Spegnimento controllato del contesto;
		context.registerShutdownHook();
		System.exit(0);
	}
}
