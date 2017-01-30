package it.clever.course.j2se.inheritance.counters;

/**
 * Classe che estende Counter decrementando 
 * il valore della variabile di istanza val. 
 *
 */
public class ReverseCounter3 extends Counter2 {
	
	/**
	 * Viene aggiunto il costruttore di default per ReverseCounter3.
	 * Visto che Counter2 non ha più un costruttore di default, la prima 
	 * istruzione deve essere un richiamo al costruttore di Counter con
	 * una assegnazione di default.
	 * 
	 * Il costruttore di default può essere generato automaticamente 
	 * solo se la superclasse ne possiede uno.
	 * In caso contrario le classi che ereditano da questa devono
	 * esplicitamente usare la super ed invocare il corretto
	 * costruttore.
	 */
	public ReverseCounter3() {
		super(0);
		System.out.println("Counter2: costruttore di default!");
		val = 1;
	}
	
	public void dec()
	{ 
			val--; 
	}
}
