package it.clever.course.j2se.collections.exceptions;

import it.clever.course.j2se.collections.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerList implements ICustomerList {

	
	private List<Customer> customerList = null;
	
	
	public CustomerList() {
		this.customerList = new ArrayList<Customer>();
	}
	

	
	public List<Customer> getCustomerList() {
		return customerList;
	}

	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for(Customer c : customerList) {
			sb.append(c.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	

	@Override
	public void populateCustomerList(int streamType) {
		if(customerList == null) {
			// Crea la lista se non esiste ancora.
			customerList = new ArrayList<Customer>();
		} else {
			// Svuota la lista.
			customerList.clear();
		}
		
		customerList.addAll(CustomerUtils.readCustomer(streamType));
	}
	
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		int arg = 1;
		if(args.length > 0) {
			try {
				arg = Integer.parseInt(args[0]);
			} catch (Exception e) {
				System.err.println("Valore errato per lo stream type.Verr� utilizzato il valore di default");
			}
		}
		CustomerList customerList = new CustomerList();
		customerList.populateCustomerList(arg);
		Collections.sort(customerList.getCustomerList());
		
		System.out.println(customerList);

	}

}
