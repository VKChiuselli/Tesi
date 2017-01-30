package it.clever.course.j2se.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		boolean done = false;
		
				do { 
					
				  try{ 
						
					  int num = readNumber();
					  int den = readNumber();
					  
					  double result = div(num, den);
					  System.out.println(result);
					  done = true; 
					  
				  }catch(MyException nfe) {
					  
					  System.err.println(nfe.getMessage());
					  
				  }catch(Exception e1){
		
					  System.err.println(e1.getMessage());
					  
				  } finally {
					  
				  }
				  
				}while (! done);				
		
	}

	private static int readNumber() throws MyException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Inserisci un numero");
		
		int num = 0;
		try {
			
			num = scanner.nextInt();
			
		} catch(InputMismatchException nfe) {
			
			nfe.printStackTrace();
			throw new MyException("Formato numerico non valido");
		}
		return num;
	}
	
	private static double div(int num, int den) throws MyException     {
	     if (den==0) 
			throw  new MyException("Impossibile dividere per 0");
		  return (double)num/den;
	   }
	
	
}
