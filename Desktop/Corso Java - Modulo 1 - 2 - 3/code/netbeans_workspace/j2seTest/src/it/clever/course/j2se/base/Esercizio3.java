package it.clever.course.j2se.base;

import java.util.*;

public class Esercizio3 {
	
	//costante
	public static final double IVA=0.21; 

	public static void main(String[] args) {
		
		//creazione oggetto scanner della classe Scanner
		Scanner tastiera = new Scanner(System.in); 
		
		double pa, pb, pc;
		
		System.out.print("Inserisci il prezzo del prodotto a= ");
		pa= tastiera.nextDouble();
		System.out.print("Inserisci il prezzo del prodotto b= ");
		pb= tastiera.nextDouble();
		System.out.print("Inserisci il prezzo del prodotto c= ");
		pc= tastiera.nextDouble();
		
		System.out.println("Per un totale di € " +(pa+pb+pc)*(1+IVA));
		
				
	}

}
