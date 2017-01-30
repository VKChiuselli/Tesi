package it.clever.course.j2se.exceptions;

public class Esempio1 {
	
	public static void main(String args[]) {
		
		int a = 0;
		String s = "t";
		
		try {
			
			if(args.length > 0) {
				// Lettura dei parametri di avvio
				a = Integer.parseInt(args[0]);
			} else {
				a = Integer.parseInt(s);
			}
			
			System.out.println("Il valore inserito è : " + a);
			
		} catch (NumberFormatException e) {
			
			System.out.println("Stringa mal fatta");
		}
	}
}
