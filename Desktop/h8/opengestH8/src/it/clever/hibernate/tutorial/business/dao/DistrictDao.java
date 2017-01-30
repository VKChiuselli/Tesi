/**
 * @author 2Clever.IT
 *
 */
package it.clever.hibernate.tutorial.business.dao;

import it.clever.hibernate.tutorial.business.entity.District;

/**
 * @author 2Clever.IT
 *
 */
public interface DistrictDao extends BaseDaoInterface<District, Integer> {

	public void saveChain() throws Exception;

}