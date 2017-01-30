package it.clever.course.j2se.base;
//Esercizio sull'uso dei cicli for e do-while

import java.util.*;

public class Esercizio12 {

	public static enum Pizza{MARGHERITA, CONTADINA, CAPRICCIOSA };
	public static final double COSTO_MARGHERITA=4;
	public static final double COSTO_CONTADINA=5.50;
	public static final double COSTO_CAPRICCIOSA=5;

	public static void main(String[] args) {
		
		int n;
		double prezzoTotale=0;
		Scanner tastiera =new Scanner(System.in);
		
		do{
			System.out.print("Quante pizze vuoi ordinare? ");
			n=tastiera.nextInt();
			if(n<=0)
				System.out.println("ERRORE:Inserire numero maggiore di zero!");
		}while(n<=0);
		
		for(int i=1; i<=n; i++){
			String pizza;
			boolean ordine=false;
			do{
				System.out.print("Prego scelga la pizza numero "+i);
				pizza=tastiera.next();
				pizza=pizza.toUpperCase();
				if(pizza.equals("MARGHERITA") || pizza.equals("CAPRICCIOSA") || pizza.equals("CONTADINA")){
					ordine=true;
					switch(Pizza.valueOf(pizza)){
					case MARGHERITA:
						prezzoTotale=prezzoTotale+COSTO_MARGHERITA;
					case CONTADINA:
						prezzoTotale=prezzoTotale+COSTO_CONTADINA;
					case CAPRICCIOSA:
						prezzoTotale=prezzoTotale+COSTO_CAPRICCIOSA;
					}//chiusura switch
				}else
					System.out.println("ERRORE:Pizza non riconosciuta. Inserire Margherita, Capricciosa o Contadina");
			}while(!ordine);
		}//chiusura for	
		System.out.print("Le pizze stanno arrivando! Il totale di " + prezzoTotale);
		
	}//chiusura main
}//chiusura classe