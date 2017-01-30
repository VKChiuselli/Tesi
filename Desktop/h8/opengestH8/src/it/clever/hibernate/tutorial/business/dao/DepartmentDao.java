/**
 * @author 2Clever.IT
 *
 */
package it.clever.hibernate.tutorial.business.dao;

import it.clever.hibernate.tutorial.business.entity.Department;

/**
 * @author 2Clever.IT
 *
 */
public interface DepartmentDao extends BaseDaoInterface<Department, Integer> {

	void saveChain() throws Exception;


}