package it.clever.course.j2se.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TestMap {

	public static void main(String[] args) {
		
		String[] arr1 = new String[10];
		String arr[] = new String[10];
		
		
		
		Map<Integer, Customer> customerMap = new HashMap<Integer, Customer>();
		
		Customer c1 = new Customer("Mario", "Rossi");
		customerMap.put(c1.getCode(), c1);
		
		Customer c2 = new Customer("Mario", "Rossi");
		customerMap.put(c2.getCode(), c2);
		
		Customer c3 = new Customer("Silvia", "Rossi");
		customerMap.put(c3.getCode(), c3);
		
		Customer c4 = new Customer("Angela", "Angelici");
		customerMap.put(c4.getCode(), c4);
		
		// Sostituisce il customer 4.
		Customer c5 = new Customer(c4);
		c5.setName("ClonedAngela");
		customerMap.put(c4.getCode(), c5);
		
		// Stampa a video degli elementi della mappa.
		Set<Integer> keySet = customerMap.keySet();
		for(Integer key : keySet) {
			System.out.println("Key map: " + key + ", key element: " + customerMap.get(key));
		}
		
		for(Customer c : customerMap.values()) {
			System.out.println(c);
		}
			
		
		Scanner scanner = new Scanner(System.in); 
		System.out.println("\nInserire il codice cliente da ricercare:");
		Integer code = scanner.nextInt();
		
		if(customerMap.containsKey(code)) {
			
			System.out.println("\nIl cliente ricercato è: \n");
			System.out.println("\n" + customerMap.get(code));
			
		} else {
			System.err.println("Codice cliente non valido.");
		}
		
	}
	
}
