/**
 * <b> UserDaoImpl.java
 * 
 * <br>
 * 
 *  Classe bo per l'accesso ai dati della tabella utente.
 * 
 */
package it.clever.hibernate.tutorial.business.dao.impl;

import it.clever.hibernate.tutorial.business.dao.DistrictDao;
import it.clever.hibernate.tutorial.business.entity.Department;
import it.clever.hibernate.tutorial.business.entity.District;

import java.util.List;

import org.hibernate.Session;


/**
 * @author 2Clever.IT
 * 
 */
public class DistrictDaoImpl extends BaseDaoServiceImpl implements DistrictDao {
	
	
	DistrictDaoImpl(){
	}
	
	@Override
	public Integer save(District entity) throws Exception {
		return (Integer)getCurrentSession().save(entity);
	}
	
	public List<District> findAll() throws Exception  {
		
		List<District> retuserList = getCurrentSession()
					.createQuery("from District").list();
		return retuserList;
	}

	@Override
	public void persist(District entity) throws Exception {
		getCurrentSession().persist(entity);		
	}

	@Override
	public void update(District entity) throws Exception {
		getCurrentSession().update(entity);		
	}

	@Override
	public District findById(Integer id) throws Exception {
		return (District)openCurrentSession().get(District.class, id);
	}

	@Override
	public void delete(District entity) throws Exception {
		getCurrentSession().delete(entity);		
	}

	@Override
	public void saveChain() throws Exception {
		
		District dist = new District();
		dist.setCodice("99");
		dist.setNomeCitta("AAAAAA");
		
		Department dept = new Department();
		dept.setCodice("99");
		
		dist.setDepartment(dept);
		
		save(dist);
	}



}
