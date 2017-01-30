package it.clever.course.j2se.base.classes;

public class Main {

	
	public static void main(String[] args) {
		
		Persona p = new Persona(1L, "Roberto", "Giontella", "GNTRRT76B01L222F");

		
		System.out.println("\nNome:" + p.getNome());
		System.out.println("Cognome:" + p.getCognome());
		System.out.println("CF:" + p.getCodFisc());
		
		System.out.println("\n" + p);
		
		modify(p);
		System.out.println("\nModify object:");
		System.out.println("\n" + p);
		
		Persona p2 = new Persona(1L, "Roberto_new", "Giontella", "GNTRRT76B01L222F");
		System.out.println("\n" + p2);
		p2.setCode(1);
		System.err.println(p.equals(p2));
	}
	
	/**
	 * Trasferimento per riferimento.
	 * Al metodo è trasferita una copia del riferimento contenuto nella variabile 
	 * e non l'oggetto stesso.
	 * @param p
	 */
	public static void modify(Persona p) {
		p.setNome(p.getNome() + "_new");
	}
}
