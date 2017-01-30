package it.clever.course.j2se.base;

public class TryInitialization {

	static int[] values = new int[10];
	
	/**
	 * Blocco statico di inizializzazione dell'array.
	 * Viene richiamato unicamente al caricamento in memoria della classe.
	 * Eseguito solamente una volta.
	 * 
	 * Se il blocco diventa non statico, viene eseguito ogni volta che
	 * si istanzia un oggetto della classe.
	 * 
	 * La variabile statica, condivisa tra tutte le classi, perde di utilità.
	 */
	static {
		System.out.println("Running initialization block.");
		for(int i= 0; i< values.length; i++) {
			values[i] = (int)(100*Math.random());
		}
	}
	
	/**
	 * Lista dei valori dell'array.
	 */
	public void listValues() {
		for(int i= 0; i< values.length; i++) {
			System.out.print(" " + values[i]); 
		}
	}
	
	public static void main(String[] args) {
		
		TryInitialization ti = new TryInitialization();
		System.out.println("\nFirst object:\n");
		ti.listValues();
		
		ti = new TryInitialization();
		System.out.println("\n\nSecond object:\n");
		ti.listValues();
	}
}
