package it.clever.course.j2se.base;
/* 
 * Esercizio sull'uso dello switch, costanti enum 
 * e metodi String toUpperCase-toLowerCase.
 */
import java.util.Scanner;

public class Esercizio8 {

	public static enum Mete{MILANO,VENEZIA,ROMA};
	
	public static final double BIGLIETTOBOVE=29, BIGLIETTOBOMI=42, BIGLIETTOBORO= 54;
	
	public static void main (String[] args){

		Scanner tastiera=new Scanner(System.in);
		String risposta, destinazione;
		
		
		System.out.print("Scegli la stazione di arrivo(Milano, Venezia,Roma): ");
		risposta=tastiera.next();
		risposta=risposta.toUpperCase(); //trasforma le lettere minuscole in maiuscole
		destinazione=risposta.substring(0, 1)+risposta.substring(1).toLowerCase();
		
		// istruzione di controllo per verificare di aver inserito una meta possibile
		if(risposta.equals("ROMA") || risposta.equals("VENEZIA") || risposta.equals("MILANO"))
			switch(Mete.valueOf(risposta)){
			case ROMA:
				System.out.println("Il viaggio Bologna- "+destinazione +" costa €: "+ BIGLIETTOBORO);
				System.out.println("Benvenuto nella capitale!");
				break;
			case MILANO:
				System.out.println("Il viaggio Bologna- "+destinazione+" costa €: "+ BIGLIETTOBOMI);
				break;
			case VENEZIA:
				System.out.println("Il viaggio Bologna- "+destinazione+"costa €: "+ BIGLIETTOBOVE);
				break;
			}//chiusura switch
			else
				System.out.println("Destinazione non presente nel servizio");
		
			/* Serie di istruzioni if-else sostitutive all'istruzione switch
			if(Mete.valueOf(risposta)==Mete.ROMA){
				System.out.println("Il viaggio Bologna- "+destinazione+" costa €: "+ bigliettoBORO);
				System.out.println("Benvenuto nella capitale!");
			}else if(Mete.valueOf(risposta)==Mete.MILANO)
				System.out.println("Il viaggio Bologna- "+destinazione+" costa €: "+ bigliettoBOMI);
			else 
				System.out.println("Il viaggio Bologna- "+destinazione+"costa €: "+ bigliettoBOVE);
			*/
		
		
	}
}
