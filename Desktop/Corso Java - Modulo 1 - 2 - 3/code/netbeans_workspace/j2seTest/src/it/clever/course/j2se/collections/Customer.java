package it.clever.course.j2se.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Customer implements Comparable<Customer> {

	private static Integer counter = 0;
	
	private String name;
	private String surname;
	private Integer code;
	
	
	
	public Customer(String name, String surname) {
		this.name = name;
		this.surname = surname;
		counter = counter +1;
		this.code = counter;
	}
	
	public Customer(Customer toClone) {
		this.name = toClone.getName();
		this.surname = toClone.getSurname();
		this.code = toClone.getCode();		
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Integer getCounter() {
		return counter;
	}

	public String getSurname() {
		return surname;
	}

	public Integer getCode() {
		return code;
	}

	
	@Override
	public int hashCode() {
		return getCode();
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", code="
				+ code + ", hashcode=" + this.hashCode() + " ]";
	}

	@Override
	public int compareTo(Customer other) {
		int i = 0;
		i = name.compareTo(other.getName());
		if(i == 0 ) {
			i = surname.compareTo(other.getSurname());
		}
		if(i == 0 ) {
			i = code.compareTo(other.getCode());
		}
		return i;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Collection<Customer> customerList = new ArrayList<Customer>();
		Collection<Customer> customerList2 = new ArrayList<Customer>();
		
		Customer c1 = new Customer("Mario", "Rossi");
		customerList.add(c1);
		customerList2.add(c1);
		
		Customer c2 = new Customer("Mario", "Rossi");
		customerList.add(c2);
		customerList2.add(c2);
		
		Customer c3 = new Customer("Silvia", "Rossi");
		customerList.add(c3);
		
		Customer c4 = new Customer("Angela", "Angelici");
		customerList.add(c4);
		
		Customer c5 = new Customer(c4);
		customerList.add(c5);
		
		
		customerList2.addAll(customerList);
		//Stampa della seconda lista
		System.out.println("\nStampa della seconda lista:\n");
		for(Customer c : customerList2 ) {
			System.out.println(c);
		}		
	
		
		System.out.println("\n**********************************************" +
				"\nBefore sorting..\n");
		for(Customer c : customerList ) {
			System.out.println(c);
		}
		
		List<Customer> clist = new ArrayList<Customer>(customerList);
		Collections.sort(clist);
		
		System.out.println("\nAfter sorting..\n");
		for(Customer c : clist ) {
			System.out.println(c);
		}
		
		System.out.println("\nMin element..\n");
		System.out.println(Collections.min(clist));
		
		System.out.println("\nMax element..\n");
		System.out.println(Collections.max(clist));
		
		
	}

}
