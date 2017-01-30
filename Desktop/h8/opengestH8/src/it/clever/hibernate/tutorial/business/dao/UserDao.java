/**
 * @author 2Clever.IT
 *
 */
package it.clever.hibernate.tutorial.business.dao;

import java.util.List;

import it.clever.hibernate.tutorial.business.entity.User;

/**
 * @author 2Clever.IT
 *
 */
public interface UserDao extends BaseDaoInterface<User, Integer> {

	public List<User> findUsersByGroup(Integer groupId, String groupName) throws Exception;
	
	public List<User> findUsersByDepartment(Integer distId, String distCode) throws Exception;
}