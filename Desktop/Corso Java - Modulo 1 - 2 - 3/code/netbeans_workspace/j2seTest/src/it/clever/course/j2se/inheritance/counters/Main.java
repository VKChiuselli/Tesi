package it.clever.course.j2se.inheritance.counters;

public class Main {
	
	public static void main(String Args[]) {
		
		// Chiamata del costruttore di default 
		Counter c = new Counter();
		System.out.println("c.val: " + c.getValue());
		
		// Chiamata del costruttore di default 
		ReverseCounter c1 = new ReverseCounter();
		System.out.println("c1.val: " + c1.getValue());
		
		c1.dec();
		System.out.println("c1.val: " + c1.getValue());
		
		// Chiamata al costruttore di default.
		System.out.println("\nGestione ReverseCounter2...\n");
		ReverseCounter2 c2 = new ReverseCounter2();
		System.out.println("c2.val: " + c2.getValue());

		System.out.println("\nGestione ReverseCounter3...\n");
		ReverseCounter3 c3 = new ReverseCounter3();
		System.out.println("c3.val: " + c3.getValue());
	}
}