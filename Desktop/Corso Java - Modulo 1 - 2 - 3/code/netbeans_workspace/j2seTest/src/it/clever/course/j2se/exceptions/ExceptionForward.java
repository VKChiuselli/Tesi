package it.clever.course.j2se.exceptions;

import java.util.Scanner;

public class ExceptionForward {

	public static void main(String[] args) {

		try {
				System.out.println("Esecuzione della divisione in corso:\n");
				execute();
				
		} catch (Exception ex){
			
			System.err.println(ex.getMessage());
			
		} finally {
			System.out.println("Uscita dal programma in corso..");
		}
	}
	
	
	public static void execute() throws Exception {
		
		try {
				System.out.println("Inserisci il dividendo:");
				String dividendoStr = readNumber();
				
				int dividendo = Integer.parseInt(dividendoStr);
				
				System.out.println("Inserisci il divisore:");
				String divisoreStr = readNumber();
				
				int divisore= Integer.parseInt(divisoreStr);
				
				if(divisore == 0) {
					throw new IllegalArgumentException();
				}
				double risultato = dividendo/divisore;
				
				System.out.println("Il risultato della divisione è: " + risultato);
				
		} catch (NumberFormatException nfe) {
			
			nfe.printStackTrace();
			throw new Exception("Inserito un valore non numerico.\n");
			
		} catch (IllegalArgumentException iae) {
			
			iae.printStackTrace();
			throw new Exception("Non si può dividere per zero\n.");
		}
	}
	
	/**
	 * Metodo che legge un numero inserito da tastiera.
	 * @return
	 */
	public static String readNumber() {
		Scanner scanner = new Scanner(System.in);
		String dividendo = scanner.next();
		return dividendo;
	}

}
