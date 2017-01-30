package it.clever.course.j2se.base;

public class Esercizio1 {

	//Somma e prodotto di due numeri interi	
	private static String nome;
	private  String cognome;
	
	private static int somma, differenza,prodotto,divisione,modulo;
	
	public static void main(String[] args) {
		//inizializzazione delle variabili
		int x,y;
		//assegnazione delle variabili
		x=10;
		y=7;
		//inizializzazione delle variabili
		
		
		//assegnazione delle variabili		
		somma=x+y;
		differenza=x-y;
		prodotto=x*y;
		divisione=x/y;
		modulo=x%y;
		
		//stampa a video
		System.out.println("x+y= "+somma);
		System.out.println("x-y= "+differenza);
		System.out.println("x*y= "+prodotto);
		System.out.println("x/y= "+divisione);
		System.out.println("x%y= "+modulo);
		
		faiQualcosa();
		//getCognome();
		
		Esercizio1.getNome();
		Esercizio1 e1 = new Esercizio1();
		e1.getCognome();
	}
	
	public static void faiQualcosa() {
		
		nome = "Roberto";
	}
	
	public static String getNome(){
		return nome;
	}
	
	public String getCognome() {
		return  cognome;
	}
}

		