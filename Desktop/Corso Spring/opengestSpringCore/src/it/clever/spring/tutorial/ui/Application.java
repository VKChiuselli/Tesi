package it.clever.spring.tutorial.ui;

import it.clever.spring.tutorial.business.entities.Product;
import it.clever.spring.tutorial.business.entities.User;
import it.clever.spring.tutorial.business.facade.ProductServiceFacadeImpl;
import it.clever.spring.tutorial.business.facade.UserServiceFacadeImpl;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "/META-INF/spring/application-context.xml");

        try {
            UserServiceFacadeImpl userService = (UserServiceFacadeImpl) context
                    .getBean("userService");

            List<User> userList = userService.findAll();
            for (User u : userList) {
                System.out.println(u);
            }

            ProductServiceFacadeImpl productService = (ProductServiceFacadeImpl) context
                    .getBean("productService");
            Integer id = 1;
            Product product = productService.loadProduct(id);

            System.out.println(product.getCodice() +" e poi " + product.getDescrizione());

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            // Spegnimento controllato del contesto;
            context.registerShutdownHook();
            System.exit(0);
        }

    }
}
