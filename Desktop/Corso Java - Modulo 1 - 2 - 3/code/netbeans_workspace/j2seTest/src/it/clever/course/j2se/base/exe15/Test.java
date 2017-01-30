package it.clever.course.j2se.base.exe15;

//classe principale in cui si creano istanze della classe Auto e si richiamo i metodi li definiti

public class Test {

	public static void main(String[] args) {
	
		// Creazione del listino del parco macchine.
		Auto[] listino = AutoUtils.creaListino();
		
		
		System.out.println("\nParco macchine a disposizione:\n");
		for(Auto auto : listino) {
			System.out.println("\n" + auto.toString());
		}
		
		// Recupero delle informazioni di un veicolo.
		AutoUtils.recuperaInformazioni(listino);
		
		// Recupero degli anni di un veicolo.
		AutoUtils.recuperaAnniAuto(listino);
		
		// Recupero del veicolo con meno anni.
		boolean fail = true;
		do {
			fail = AutoUtils.recuperaAutoConMenoKm(listino);
		} while(fail);
		
	}
}
