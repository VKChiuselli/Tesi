package it.clever.course.j2se.exceptions;

import java.util.Scanner;

public class ExceptionForward2 {

	public static void main(String[] args) {

		try {
				System.out.println("Esecuzione della divisione in corso:\n");
				execute();
				
			
		} catch (InvalidDataException ide) {
			System.err.println(ide.getMessage());

		} catch (Exception ex){
			
			System.err.println("Errore generico");
			ex.printStackTrace();
			
		} finally {
			System.out.println("Uscita dal programma in corso..");
		}
	}
	
	
	public static void execute() throws InvalidDataException {
		
		try {
				System.out.println("Inserisci il dividendo:");
				String dividendoStr = readNumber();
				
				int dividendo = Integer.parseInt(dividendoStr);
				
				System.out.println("Inserisci il divisore:");
				String divisoreStr = readNumber();
				
				int divisore= Integer.parseInt(divisoreStr);
				
				if(divisore == 0) {
					throw new ArithmeticException();
				}
				double risultato = dividendo/divisore;
				
				System.out.println("Il risultato della divisione è: " + risultato);
				
		} catch (NumberFormatException nfe) {
			
			nfe.printStackTrace();
			throw new InvalidDataException("Inserito un valore non numerico.\n");
			
		} catch (ArithmeticException ae) {
			
			ae.printStackTrace();
			throw new InvalidDataException("Non si può dividere per zero.\n");
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
