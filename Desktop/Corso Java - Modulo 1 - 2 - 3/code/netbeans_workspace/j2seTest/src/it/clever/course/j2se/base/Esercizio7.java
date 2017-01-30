package it.clever.course.j2se.base;

/* Esercizio sull'uso dello switch con condizione su variabili di tipo int*/

import java.util.Scanner;

	public class Esercizio7 {

	public static void main (String[] args){
		
		int posizione;
		String nome;
		Scanner tastiera= new Scanner(System.in);
		
		System.out.print("Inserisci il nome del podista: ");
		nome=tastiera.next();
		System.out.print("Inserisci la posizione sul podio (1,2,3): ");
		posizione=tastiera.nextInt();
		
		if(posizione > 0) {
			
			switch(posizione){
			case 1:
				System.out.println("Complimenti "+nome+"! Sei arrivato primo!");
				break;
			case 2:
				System.out.println("Bravissimo "+nome+". Sei arrivato secondo");
				break;
			case 3:
				System.out.println("Bella prestazione "+nome+". Sei arrivato terzo");
				break;
			default:
				System.out.println(nome+", purtroppo non sei sul podio!");
				break;
			}//chiusura switch
			
		}else {
			System.out.println("Posizione non corretta");
		}
	}
}