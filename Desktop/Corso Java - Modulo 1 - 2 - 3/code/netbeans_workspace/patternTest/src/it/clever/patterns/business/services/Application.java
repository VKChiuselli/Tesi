/**
 * Application.java
 *
 * robgion
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.patterns.business.services;

import java.sql.SQLException;
import java.util.List;

import it.clever.patterns.business.model.UserVO;

/**
 * @author robgion
 *
 */
public class Application {

	public static void main(String[] args) {
		
		Application app = new Application();
		app.execute();
	}
	
	public void execute() {
		
		UserService userService = new UserService();
		List<UserVO> userList;
		try {
			userList = userService.retrieveAllUsersFromLocal();
			for(UserVO user : userList) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
