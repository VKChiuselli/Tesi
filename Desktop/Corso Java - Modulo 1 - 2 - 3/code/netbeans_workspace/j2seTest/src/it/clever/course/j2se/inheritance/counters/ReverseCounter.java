package it.clever.course.j2se.inheritance.counters;

/**
 * Classe che estende Counter decrementando 
 * il valore della variabile di istanza val. 
 *
 * All'istanziazione dell'oggetto, viene richiamato implicitamente il costruttore
 * della classe di base.
 * In modo trasparente viene richiamato il metodo (costruttore) super();
 * 
 */
public class ReverseCounter extends Counter {
	
	public void dec() {
		val--;
	}
}
