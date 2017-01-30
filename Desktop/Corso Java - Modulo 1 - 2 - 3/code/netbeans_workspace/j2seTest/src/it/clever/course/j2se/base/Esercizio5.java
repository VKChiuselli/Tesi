package it.clever.course.j2se.base;

import java.util.Scanner;

//Esercizio sull'uso dei metodi length() e substring()

public class Esercizio5 {
		public static void main (String[] args){
		
		Scanner tastiera = new Scanner(System.in); //creazione oggetto tastiera della classe Scanner
		
		String nome, cognome;
		
		System.out.print("Inserisci il tuo nome: "); 
		nome=tastiera.next();
		System.out.print("Inserisci il tuo cognome: "); 
		cognome=tastiera.next();
		
		if(nome.length() > cognome.length() ){
			
			System.out.println("Il tuo nome é di "+nome.length() +" caratteri");
			
		}else if(nome.length() < cognome.length() ){
			
			System.out.println("Il tuo cognome é di "+ cognome.length() +" caratteri");
			
		}else {
			
			System.out.println("Il tuo nome è di "+ nome.length() +" caratteri");
			System.out.println("Il tuo cognome è di "+ cognome.length() +" caratteri");
		}
		
		
		//soluzione con substring
		System.out.println("Le tue iniziali sono: " + nome.substring(0, 1) +cognome.substring(0, 1)); 
		
		//soluzione con l'uso di charAt alternativa alla precedente:
		System.out.println("Le tue iniziali sono: " +nome.charAt(0) +cognome.charAt(0)); 
	}
	
}
