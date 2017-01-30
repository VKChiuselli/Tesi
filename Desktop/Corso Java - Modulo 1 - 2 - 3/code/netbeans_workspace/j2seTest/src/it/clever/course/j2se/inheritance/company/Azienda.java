package it.clever.course.j2se.inheritance.company;

public class Azienda {

	public static void main(String[] args) {
		
		Impiegato[] organico = new Impiegato[3];
		
		organico[0] = new Impiegato("Mario Rossi", 1000, "I1", 10 );
		organico[1] = new Impiegato("Gaetano Bianchi", 1000, "I2", 1 );
		organico[2] = new Manager("Gaetano Bianchi", 1000, "I2", 20, "Clara");
		
		System.out.println("\nStampa dipendenti:\n");
		for(Impiegato i : organico) {
			System.out.println(i.toString());
		}
		
		System.out.println("\nIncremento salario del 5%.\n");
		for(Impiegato i : organico) {
			/*
			 * Incrementa il salario di ciascun dipendente di un 5%.
			 */
			i.incrementaSalario(5);
		}
		
		System.out.println("\nStampa dipendenti:\n");
		for(Impiegato i : organico) {
			System.out.println(i.toString());
		}
		
	}
}
