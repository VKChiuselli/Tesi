package it.clever.course.j2se.base;

//Esercizio sull'uso di operatori di incremento/decremento

public class Esercizio4 {
		public static void main (String[] args){
		
		int x=10;
		int z=0;

		System.out.println("All'inizio x vale "+x+" mentre z "+z); 
		
		z=++x;
		System.out.println("Dopo z=++x x vale "+x+" mentre z "+z); 
		
		z=--x;
		System.out.println("Dopo z=--x x vale "+x+" mentre z "+z); 
		
		z=x++;
		System.out.println("Dopo z=x++ x vale "+x+" mentre z "+z); 
		
		z=x--;
		System.out.println("Dopo z=x-- x vale "+x+" mentre z "+z); 
				
	}
	
}
