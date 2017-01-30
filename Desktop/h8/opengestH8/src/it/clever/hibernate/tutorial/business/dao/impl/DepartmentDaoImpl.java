/**
 * <b> UserDaoImpl.java
 * 
 * <br>
 * 
 *  Classe bo per l'accesso ai dati della tabella utente.
 * 
 */
package it.clever.hibernate.tutorial.business.dao.impl;

import it.clever.hibernate.tutorial.business.dao.DepartmentDao;
import it.clever.hibernate.tutorial.business.entity.Department;
import it.clever.hibernate.tutorial.business.entity.District;

import java.util.List;


/**
 * @author 2Clever.IT
 * 
 */
public class DepartmentDaoImpl extends BaseDaoServiceImpl implements DepartmentDao {
	
	
	DepartmentDaoImpl(){
	}
	
	@Override
	public Integer save(Department entity) throws Exception {
		return (Integer)getCurrentSession().save(entity);
	}
	
	public List<Department> findAll() throws Exception  {
		
		List<Department> retuserList = getCurrentSession()
					.createQuery("from Department").list();
		return retuserList;
	}

	@Override
	public void persist(Department entity) throws Exception {
		getCurrentSession().persist(entity);		
	}

	@Override
	public void update(Department entity) throws Exception {
		getCurrentSession().update(entity);		
	}

	@Override
	public Department findById(Integer id) throws Exception {
		return (Department)openCurrentSession().get(Department.class, id);
	}

	@Override
	public void delete(Department entity) throws Exception {
		getCurrentSession().delete(entity);		
	}

	@Override
	public void saveChain() throws Exception {
		
		District dist = new District();
		dist.setCodice("99");
		dist.setNomeCitta("AAAAAA");
		
		Department dept = new Department();
		dept.setCodice("99");
		dept.getProvinces().add(dist);
		
		dist.setDepartment(dept);
		
		save(dept);
	}

}
