package it.clever.hibernate.tutorial.application;

import it.clever.hibernate.tutorial.business.entity.AuthAuthorities;
import it.clever.hibernate.tutorial.business.entity.AuthGroup;
import it.clever.hibernate.tutorial.business.entity.Order;
import it.clever.hibernate.tutorial.business.entity.OrderDetail;
import it.clever.hibernate.tutorial.business.entity.Product;
import it.clever.hibernate.tutorial.business.entity.User;
import it.clever.hibernate.tutorial.business.services.CustomerService;
import it.clever.hibernate.tutorial.business.services.DistrictService;
import it.clever.hibernate.tutorial.business.services.OrderService;
import it.clever.hibernate.tutorial.business.services.ProductService;
import it.clever.hibernate.tutorial.business.services.UserService;
import it.clever.hibernate.tutorial.exception.BusinessException;
import java.math.BigDecimal;

import java.util.List;

public class Application {

	public static void main(String[] args) {

		
            
            
            
		// Ricerca tutti lgi utenti censiti.
//		findAllusers();
		
		// Controllo sull'object identity
	//	testEquality();
		
        
        // Inserisco nuovo prodotto
     testInserimentoProdotto();
        
        
		// Inserisce in modalità  batch ordini.
		//testFlushBatchInsert();
		
		// Gestione della metodologia di flush.
		//testFlushInsert();
		
		// Test della relazione Many-to-One
		//retrieveAllDistricts();
		
		// Test CacadeType Many-to-One
		//testCascadeType();
		
		// Test One-to-One relation
                
		testOneToOneRelation();
		
                
		// Test many-to-many relation
		//testManyToManyRelation();
		
		// Test HQL
		//testHQLQueries1();
		//testHQLQueries2();
		//testHQLQueries3();
		//testHQLQueries4();
		//testHQLQueries5();
		
		// Fine della sessione di lavoro.
		terminateService();
	}
	
	private static void testEquality() {
		CustomerService userService = new CustomerService();
                
             
		try {
			userService.testEquality(1, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
        private static void testInserimentoProdotto(){
            ProductService p = new ProductService();
            
            
               System.out.println("entro?");
		try {
			p.inserimentoProdotto("abc", "ceraunavolta", BigDecimal.ZERO);
		} catch (Exception e) {
			e.printStackTrace();
		}
            
        }
        
        
	
	private static void findAllusers() {
		
	try {
			UserService userService = new UserService();
			List<User> userList = userService.findAll();
			
			for(User user : userList) {
				System.out.println(user);
				System.out.println("\n");
				
				// Frutto di un caricamento HEAGER.
				System.err.println(user.getAddress().getDistrict().getCodice());
				
				/* 
				 * E' impostato un caricamento LAZY.
				 * Se scommentato il codice produce una LazyinitializationException in quanto 
				 * l'accesso alla Entity collegata avviene a sessione chiusa.
				 */
				//System.err.println(user.getAddress().getDepartment().getCodice());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testFlushBatchInsert() {
		
		OrderService orderService = new OrderService();
		try {
			orderService.batchInsert(100000);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	
	private static void testFlushInsert() {
		
		OrderService orderService = new OrderService();
		try {
			orderService.flushOrder();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo per il test della relazione Many-to-One
	 */
	private static void retrieveAllDistricts() {
		
		DistrictService ds = new DistrictService();
		try {
			ds.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo per il test del CascadeType in relazioni ManyToOne
	 */
	private static void testCascadeType() {
		
//		DepartmentService ds = new DepartmentService();
		DistrictService ds = new DistrictService();
		try {
			ds.saveChain();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo per il test della relazione one-to-one con condivisione della chiave primaria.
	 */
	private static void testOneToOneRelation() {
		CustomerService cs = new CustomerService();
		try {
			cs.insertContract(1);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Metodo per il test della relazione many-to-many.
	 */
	private static void testManyToManyRelation() {
		UserService us = new UserService();
		try {
			User user = us.findByIdGroupEager(1);
			for(AuthGroup ag :user.getGroups()) {
				System.out.println(ag);
				for(AuthAuthorities aa : ag.getAuthAuthorities()) {
					System.out.println("\t" + aa);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Metodo per testare le query HQL con relazioni di join
	 */
	private static void testHQLQueries() {
		UserService us = new UserService();
		try {
			List<User> userList = us.findUsersByGroup(2, "SUPERUSER");
			if(userList != null && !userList.isEmpty()) {
				for(User u :userList) {
					System.out.println(u);
				}
			} else {
				System.err.println("Nessun utente trovato appartenente al gruppo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	private static void testHQLQueries2() {
		UserService us = new UserService();
		try {
			List<User> userList = us.findUsersByDistrict(26, "Emilia-Romagna");
			if(userList != null && !userList.isEmpty()) {
				for(User u :userList) {
					System.out.println(u);
					/*
					 * Restituisce un errore se la relazione  LAZY.
					 * L'HQL non gestisce di default la EAGER initialization, quindi 
					 *  necessario forzare direttamente nella query 
					 */
					System.out.println("Regione: " + u.getAddress().getDepartment().getCodice());
				}
			} else {
				System.err.println("Nessun utente trovato appartenente al gruppo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	private static void testHQLQueries3() {
		OrderService us = new OrderService();
		try {
			List<Order> retList = us.findOrdersByOrderFilters(1, 50);
			if(retList != null && !retList.isEmpty()) {
				for(Order u :retList) {
					System.out.println(u);
				}
			} else {
				System.err.println("Nessun ordine trovato.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private static void testHQLQueries4() {
		OrderService us = new OrderService();
		try {
			List<Object[]> retList = us.findInfoOrdersfortable();
			if(retList != null && !retList.isEmpty()) {
				for(Object[] orderDetails :retList) {
					
					System.out.println("\nOrdine \n");
					for(Object detail : orderDetails) {
						
						System.out.print("\t");
						System.out.print(detail);
						
					}
					System.out.println("\n\n");
				}
			} else {
				System.err.println("Nessun ordine trovato.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	
	private static void testHQLQueries5() {
		OrderService us = new OrderService();
		try {
			List<OrderDetail> retList = us.findInfoOrderDetails();
			if(retList != null && !retList.isEmpty()) {
				for(OrderDetail orderDetails :retList) {
					
					System.out.println("\nOrdine \n");
					System.out.print("\t");
					System.out.print(orderDetails);
						
				}
			} else {
				System.err.println("Nessun ordine trovato.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Chiusur del servizio di connessione e dell'applicazione.
	 */
	private static void terminateService() {
		System.out.println("Chiusura della sessione di lavoro in corso...");
		HibernateUtil.terminateService();
		System.exit(0);
	}
}
