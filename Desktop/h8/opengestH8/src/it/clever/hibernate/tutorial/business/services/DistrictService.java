package it.clever.hibernate.tutorial.business.services;

import it.clever.hibernate.tutorial.business.dao.impl.DaoFactory;
import it.clever.hibernate.tutorial.business.dao.impl.DistrictDaoImpl;
import it.clever.hibernate.tutorial.business.entity.District;

import java.util.List;

public class DistrictService {

	private DistrictDaoImpl districtDao;
	
	
	public DistrictService() {
		this.districtDao = new DaoFactory().createDistrictDao();
	}
	
	public List<District> findAll() throws Exception  {
		
		this.districtDao.openCurrentSession();
		List<District> retList = this.districtDao.findAll();
/*		
		for(District dist : retList) {
			//1.  Utilizzo del metodo initialize().
			Hibernate.initialize(dist.getDepartment());
		}
*/		
		this.districtDao.closeCurrentSession();
		
		for(District dist : retList) {
			System.out.println(dist);
			
			/*
			 * Viene generata una org.hibernate.LazyInitializationException: 
			 * could not initialize proxy - no Session.
			 * 
			 * Si tenta di accedere ad una entity collegata da una LAZY initialization
			 * al di fuori della sessione attiva.
			 * 
			 * Sono possibili due approcci:
			 * 
			 * 1. utilizzo del metodo Hibernate.initialize();
			 * 2. Un’altra soluzione è quella di modificare il tipo di inizializzazione per Hibernate, 
			 * 	  al prezzo di diminuire le performance:
			 */
			
			System.err.println("Department: " + dist.getDepartment().getCodice());
		}
			
		
		return retList;
	}

	public void persist(District entity) throws Exception {
		this.districtDao.beginTransaction();
		this.districtDao.persist(entity);		
		this.districtDao.closeCurrentSession();
	}

	public void update(District entity) throws Exception {
		this.districtDao.beginTransaction();
		this.districtDao.update(entity);		
		this.districtDao.closeCurrentSession();
	}

	public District findById(Integer id) throws Exception {
		this.districtDao.openCurrentSession();
		District retOrder = this.districtDao.findById(id);
		this.districtDao.closeCurrentSession();
		return retOrder;
	}

	public void delete(District entity) throws Exception {
		this.districtDao.beginTransaction();
		this.districtDao.delete(entity);		
		this.districtDao.endTransaction();
	}
	
	public void saveChain() throws Exception {
		try {
			this.districtDao.beginTransaction();
			this.districtDao.saveChain();		
			this.districtDao.endTransaction();
			
		} catch (Exception e) {
			this.districtDao.abortTransaction();
			throw new Exception();
		}
	}
}
