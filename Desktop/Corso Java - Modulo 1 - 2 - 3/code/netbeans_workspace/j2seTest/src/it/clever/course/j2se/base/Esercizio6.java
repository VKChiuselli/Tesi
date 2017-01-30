
package it.clever.course.j2se.base;

import java.util.Scanner;

/*
  Esercizio sull'uso di if, boolean, cast, equals.
  Calcolo del voto finale di un esame secondo i casi seguenti:
  presenza/assenza di progetto + parziali/esame totale
*/

public class Esercizio6 {

	public static void main(String[] args) {
		
		Scanner tastiera=new Scanner(System.in);
		
		float votoPrimoParziale=0, votoSecondoParziale=0, votoProgetto=0;
		int votoFinale, votoEsameTotale=0;
		boolean parziali, progetto;
		String risposta;
		
		System.out.print("Hai fatto il progetto? (si/no) ");
		risposta=tastiera.next();
		// in alternativa usare equalsIgnorCase al posto di equals
		if(risposta.equals("si") || risposta.equals("sì")) {
			progetto=true;
		} else {
			progetto=false;
		}
		System.out.print("Hai fatto i parziali? (S/N)");
		risposta=tastiera.next();
		// esempio di uso di charAt, potevo usare anche in questo caso equalsIgnorCase o equals
		if(risposta.charAt(0)=='S' || risposta.charAt(0)=='s') {
			parziali=true;
		} else {
			parziali=false;
		}
		
		if(progetto){
			System.out.print("Inserisci il voto del progetto: ");
			votoProgetto=tastiera.nextFloat();
		}
		if(parziali){
			System.out.print("Inserisci il voto del primo parziale: ");
			votoPrimoParziale=tastiera.nextFloat();
			System.out.print("Inserisci il voto del secondo parziale: ");
			votoSecondoParziale=tastiera.nextFloat();
		}
		
		if(progetto && parziali){ //progetto+2parziali
			// cast che tronca il voto
           		votoFinale=(int)(votoPrimoParziale+votoSecondoParziale+votoProgetto)/3;
			
			// prima alternativa per arrotondare all'intero superiore
			// votoFinale=(int)((votoPrimoParziale+votoSecondoParziale+votoProgetto)/3+1);
			
			// seconda alternativa per arrotondare all'intero più vicino
			// votoFinale= Math.round((votoPrimoParziale+votoSecondoParziale+votoProgetto)/3);
           		
		} else if (progetto && !parziali){ 
			//progetto+esame totale
			System.out.print("Inserisci il voto dell'esame totale: ");
			votoEsameTotale=tastiera.nextInt();
		
			// cast che tronca il voto
			votoFinale=(int)(votoEsameTotale+votoProgetto)/2;
			// possibili alternative analoghe a quelle presentate nel caso progetto && parziali
			
			} else if(parziali) { // non si è fatto il progetto ma solo i parziali
				votoFinale=(int)(votoPrimoParziale+votoSecondoParziale)/2;
			}else { // non sono stati fatti nè il progetto nè i parziali
					System.out.print("Inserisci il voto dell'esame totale:");
					votoFinale=tastiera.nextInt();
			}
		
		System.out.print("Il voto totale è "+votoFinale);			
	}

}
