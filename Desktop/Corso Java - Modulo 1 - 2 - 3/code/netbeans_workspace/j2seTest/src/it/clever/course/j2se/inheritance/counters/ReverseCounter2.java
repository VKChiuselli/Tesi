package it.clever.course.j2se.inheritance.counters;

/**
 * Classe che estende Counter decrementando 
 * il valore della variabile di istanza val. 
 *
 */
public class ReverseCounter2 extends Counter {
	
	/**
	 * Viene aggiunto il costruttore di default per ReverseCounter2.
	 * All'istanziazione dell'oggetto, viene aggiunta in modo trasparente una
	 * chiamata al costruttore super().
	 */
	public ReverseCounter2() {
		System.out.println("Counter2: costruttore di default!");
		val = 1;
	}
	
	public void dec()
	{ 
			val--; 
	}
}
