package it.clever.course.j2se.base;

import java.util.*;

public class Esercizio2 {

	public static void main(String[] args) {
		
		//creazione oggetto tastiera della classe Scanner
		Scanner tastiera = new Scanner(System.in); 
		
		int b,h; // inizializzazione delle variabili b e h
		
		System.out.print("Inserisci l'altezza del triangolo ");
		//assegnazione del valore letto da tastiera alla variabile h
		h= tastiera.nextInt(); 
		
		System.out.print("Inserisci la lunghezza della base "); 
		//assegnazione del valore letto da tastiera alla variabile b
		b= tastiera.nextInt(); 

		System.out.println("L'area di un triangolo con base "+b +" e altezza "+h +" è uguale a " + (b*h/2));  
		
	}

}
