package it.clever.course.j2se.base;

import java.awt.Dimension;

public class ReferenceAssignment {

	public static void main(String args[]) {
	    
		assignment_1();
		
		assignment_2();
		
		comparison();
	}
	
	private static void assignment_1() {
		
		System.out.println("Esecuzione assegnazione con puntamento:\n") ;
		
		Dimension x = new Dimension(4, 4);
	    Dimension y;

	    y = x;

	    System.out.println("x vale : " + x) ;
	    System.out.println("y vale : " + y) ;

	    y.setSize(2, 2); // Modifica delle coordinate

	    System.out.println("\nModifica delle coordinate..\n") ;
	    System.out.println("x vale : " + x) ;
	    System.out.println("y vale : " + y) ;		
	}
	
	private static void assignment_2() {
	    
		System.out.println("\nEsecuzione assegnazione con nuovo valore:\n") ;
		
		Integer x = new Integer(4);
	    Integer y;
	    y = x;

	    System.out.println("x vale : " + x) ;
	    System.out.println("y vale : " + y) ;
	    
	    System.out.println("\nModifica delle coordinate..\n") ;
	    y = 2 ;
	    System.out.println("x vale : " + x) ;
	    System.out.println("y vale : " + y) ;
		
	}
	
	
	private static void comparison() {
		
		System.out.println("\nComparazione di oggetti:\n") ;
		Integer x = new Integer(4);
		Integer y;
		
		System.out.println("\nAssegnazione y=x:\n") ;
		y = x;
		System.out.println("x vale : " + x) ;
		System.out.println("y vale : " + y) ;
		
		System.out.println("\nAssegnazione nuovo valore: y=4\n") ;
		y = 4 ;
		System.out.println("x vale : " + x) ;
		System.out.println("y vale : " + y) ;
		if (x == y) {
			System.out.println("x e y sono uguali");
		} else {
			System.out.println("x e y sono diversi");
		}		
	}
}
