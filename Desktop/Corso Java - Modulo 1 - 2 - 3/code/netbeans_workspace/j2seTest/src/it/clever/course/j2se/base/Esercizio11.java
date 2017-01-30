package it.clever.course.j2se.base;

//Esercizio sull'uso del ciclo while

import java.util.*;

public class Esercizio11 {
	
	public static void main(String[] args){
		int calTotali=0,calEsercizio, calObiettivo,tempoEsercizio=0,tempoDisponibile=0;
		Scanner tastiera=new Scanner(System.in);
		
		System.out.print("Quanto cal vuoi consumare oggi? ");
		calObiettivo=tastiera.nextInt();
		System.out.print("Quanto tempo disponibile hai oggi per fare esercizi? (in minuti) ");
		tempoDisponibile=tastiera.nextInt();
		
		while(calTotali< calObiettivo && tempoDisponibile!=0){
			System.out.print("Quanto tempo dura l'esercizio (in minuti)? ");
			tempoEsercizio=tastiera.nextInt();
			if(tempoDisponibile>=tempoEsercizio){
				System.out.print("Quanto cal consuma? ");
				calEsercizio=tastiera.nextInt();
				tempoDisponibile=tempoDisponibile-tempoEsercizio;
				calTotali=calTotali+calEsercizio;
			}else 
				System.out.println("Esercizio troppo lungo, non hai tempo!");
			System.out.println("Le calorie consumate in totale sono "+calTotali);
			System.out.println("Il tempo disponibile residuo  di "+tempoDisponibile +" minuti");
		}//chiusura while
		
	}//chiusura main
}