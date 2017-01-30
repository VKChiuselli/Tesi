package it.clever.hibernate.tutorial.business.services;

import it.clever.hibernate.tutorial.business.dao.DepartmentDao;
import it.clever.hibernate.tutorial.business.dao.impl.DaoFactory;
import it.clever.hibernate.tutorial.business.dao.impl.DepartmentDaoImpl;
import it.clever.hibernate.tutorial.business.dao.impl.DistrictDaoImpl;
import it.clever.hibernate.tutorial.business.entity.Department;
import it.clever.hibernate.tutorial.business.entity.District;

import java.util.List;

import org.hibernate.Hibernate;

public class DepartmentService {

	private DepartmentDaoImpl departmentDao;
	
	
	public DepartmentService() {
		this.departmentDao = new DaoFactory().createDepartmentDao();
	}
	
	public List<Department> findAll() throws Exception  {
		this.departmentDao.openCurrentSession();
		List<Department> retList = this.departmentDao.findAll();
		this.departmentDao.closeCurrentSession();
		return retList;
	}

	public void persist(Department entity) throws Exception {
		this.departmentDao.beginTransaction();
		this.departmentDao.persist(entity);		
		this.departmentDao.closeCurrentSession();
	}

	public void update(Department entity) throws Exception {
		this.departmentDao.beginTransaction();
		this.departmentDao.update(entity);		
		this.departmentDao.closeCurrentSession();
	}

	public Department findById(Integer id) throws Exception {
		this.departmentDao.openCurrentSession();
		Department retOrder = this.departmentDao.findById(id);
		this.departmentDao.closeCurrentSession();
		return retOrder;
	}

	public void delete(Department entity) throws Exception {
		this.departmentDao.beginTransaction();
		this.departmentDao.delete(entity);		
		this.departmentDao.endTransaction();
	}
	
	public void saveChain() throws Exception {
		try {
			this.departmentDao.beginTransaction();
			this.departmentDao.saveChain();
			this.departmentDao.endTransaction();
		} catch (Exception ex) {
			this.departmentDao.abortTransaction();
			ex.printStackTrace();
			throw new Exception();
		}
	}
}
