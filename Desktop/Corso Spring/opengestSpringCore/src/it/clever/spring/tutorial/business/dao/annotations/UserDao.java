/**
 * @author 2Clever.IT
 *
 */
package it.clever.spring.tutorial.business.dao.annotations;

import it.clever.spring.tutorial.business.entities.User;

import java.io.Serializable;
import java.util.List;

/**
 * @author 2Clever.IT
 *
 */
public interface UserDao extends BaseDaoInterface2<User, Serializable>{

	public List<User> findUsersByGroup(Integer groupId, String groupName) throws Exception;
	
	public List<User> findUsersByDepartment(Integer distId, String distCode) throws Exception;
	
	public List<User> findUsersByFilters(String name, String surname, String email)
			throws Exception;
	
	public List<User> findUsersByCriteriaFilters(String name, String surname, String email)
			throws Exception;

	public User findByUsername(String username);

}