package it.clever.course.j2se.base;

import java.util.*;
import java.text.*;

/* 
 * Esercizio sull'uso di switch con condizione su variabile char, 
 * metodi Math.log e Math.pow, e metodo format della classe DecimalFormat
 */

public class Esercizio9 {

	public static void main (String[] args){
		
		double a,b;
		String risposta;
		char operazione;
		Scanner tastiera= new Scanner(System.in);
		DecimalFormat df= new DecimalFormat("0.00");
		
		System.out.print("Inserisci il valore di a: ");
		a=tastiera.nextDouble();
		
		System.out.print("Inserisci il valore di b: ");
		b=tastiera.nextDouble();
		
		System.out.print("Quale operazione desideri eseguire? (+ - * / L P) ");
		risposta=tastiera.next();
		
		operazione=risposta.charAt(0);
		
		switch(operazione){
			case '+':
				System.out.println("a+b= "+ df.format(a+b));
				break;
			case '-':
				System.out.println("a-b= "+ df.format(a-b));
				break;
			case '*':
				System.out.println("a*b= "+ df.format(a*b));
				break;
			case '/':
				if(b!=0)
					System.out.println("a/b= "+ df.format(a/b));
				else
					System.out.println("Impossibile eseguire la divisione!");
				break;
			case 'L':
			case 'l':
				if(a>0 && b>0 && b!=1)
					System.out.println("logb(a)= "+ df.format(Math.log(a)/Math.log(b)) );
				else
					System.out.println("Impossibile eseguire il logaritmo!");
				break;
			case 'P':
			case 'p':
				if(a!=0 && b!=0)
					System.out.println("a^b= "+ df.format(Math.pow(a, b)) );
				else
					System.out.println("Impossibile eseguire la potenza!");
				break;
			default:
				System.out.println("L'operazione richiesta non è stata riconosciuta");
		}
		
	}
}
