package it.clever.course.j2se.exceptions.file;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryException {

	private static String divisore = null;
	private static String dividendo = null;
	
	public static void main(String[] args) {

				try {		
					
					//Esecuzione senza gestione personalizzata delle eccezioni.
					readParams();
					double result = getResultNoHandle(dividendo, divisore); 
					System.out.println("Il risultato è: " + result);
					
					//Esecuzione con gestione personalizzata delle eccezioni.
					readParams();
					double result2 = getResultHandle(dividendo, divisore);
					
					
					System.out.println("Il risultato è: " + result2);
					
				} catch(NumberFormatException nfe){
					
					System.err.println("Errore nell'inserimento del numero.Eccezione non gestita.");
					nfe.printStackTrace();
					
				} catch (IOException e) {
					
					System.err.println("Errore nella lettura dei parametri.");
					e.printStackTrace();
					
				} catch (ApplicationException e) {
				
					System.err.println(e.getMessage());
				}		
	}
	
	/**
	 * Metodo che legge da tastiera dividendo e divisore.
	 * @throws IOException
	 */
	private static void readParams() throws IOException{
			BufferedReader msgStream = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Inserisci il dividendo:\n");
			dividendo = msgStream.readLine();			
			System.out.print("\nInserisci il divisore:\n");			
			divisore = msgStream.readLine();
	}
	
	/**
	 * 
	 * @param dividendo
	 * @param divisore
	 * Metodo che calcola la frazione tra due double senza gestire eccezioni di tipo NumberFormatException
	 */
	private static double getResultNoHandle(String dividendo, String divisore) {
		double result = 0;		
		Double dividend = new Double(dividendo);
		Double scissor = new Double(divisore);		
		result = (dividend/scissor);
		return result;
	}
	
	private static double getResultHandle(String dividendo, String divisore) throws ApplicationException{
		double result = 0;
		Double dividend = null;
		Double scissor = null;
		try{
			dividend = new Double(dividendo);
		}catch(NumberFormatException nfe){
			String[] args = {"dividendo"};
			throw new ApplicationException("EM3", args);
		}
		try{
		    scissor = new Double(divisore);
		}catch(NumberFormatException nfe){
			String[] args = {"divisore"};
			throw new ApplicationException("EM3", args);
		}
		result = (dividend/scissor);
		return result;		
	}
	

}
