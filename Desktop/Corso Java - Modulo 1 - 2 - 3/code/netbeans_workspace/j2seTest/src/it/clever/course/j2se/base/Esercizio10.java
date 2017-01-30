package it.clever.course.j2se.base;

//Esercizio sull'uso del metodo Math.random() e del ciclo for

import java.util.*;

public class Esercizio10 {
	
	public static final int TENTATIVI=3;
	
	public static void main(String[] args){
		
		Scanner tastiera=new Scanner(System.in);
		double indovina=Math.round(10*(Math.random()));
		int numero;
		boolean indovinato = false;
		
		
		for(int i=1;i<=TENTATIVI && !indovinato;i++){	
			System.out.print("Possibilità n."+i+" Inserisci un numero (0-10): ");
			numero=tastiera.nextInt();
			 if(numero==indovina){
				 indovinato=true;
				 System.out.println("Hai indovinato!!!");
			}else if(numero>indovina)
				System.out.println("Numero troppo grande!");
			      else
				System.out.println("Numero troppo piccolo!");
		}//chiusura for
		
		if(indovinato==false)
			System.out.println("Tentativi esauriti!");
	}//chiusura main
}//chiusura classe
