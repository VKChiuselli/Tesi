package it.clever.course.j2se.base.exe15;

import it.clever.course.j2se.base.exe15.Auto;

import java.util.Scanner;

public class AutoUtils {
	
	/**
	 * Metodo per la creazione del listino delle auto.
	 * @return
	 */
	public static Auto[] creaListino() {
		
		Auto[] retArr = new Auto[3]; 
		
		Auto.TipoAuto tipo;
		int annoImm, kmPercorsi, annoCorrente;
		String targa,targaAuto, primaTarga, secondaTarga, targaMenoKm=null;
		Scanner tastiera=new Scanner(System.in);
		boolean trovato=false;
		
		for(int i = 0;i < retArr.length; i++) {
			
			System .out.println("Auto numero " + (i+1));
			Auto auto=new Auto();	
			System .out.print("Che tipo di auto è? ");
			tipo=Auto.TipoAuto.valueOf(tastiera.next());
			auto.setTipo(tipo);
			
			System .out.print("In quale anno è stata immatricolata? ");
			annoImm=tastiera.nextInt();
			auto.setAnno(annoImm);
			System .out.print("Quale è la sua targa? ");
			targa=tastiera.next();
			auto.setTarga(targa);
			System .out.print("Quanti km ha già percorso l'auto? ");
			kmPercorsi=tastiera.nextInt();
			auto.setKm(kmPercorsi);
			
			retArr[i] = auto;
		}
		
		return retArr;
	}
	
	/**
	 * Metodo per recuperare le informazioni di un'auto desiderata.
	 * @param listino
	 */
	public static void recuperaInformazioni(Auto[] listino) {
		
		Scanner tastiera=new Scanner(System.in);
		
		System.out.println("\nDi quale tipo di auto vuoi informazioni? (SPORTIVA, BERLINA, FAMILIARE) ");
		String risposta = tastiera.next();
		risposta= risposta.toUpperCase();
		
		
		
		Auto.TipoAuto tipo =Auto.TipoAuto.valueOf(risposta);  
		
		boolean trovato = false;
		
		for(int i = 0; i < listino.length; i++) {
			
			if(listino[i].getTipo() == tipo) {
				System.out.println("Auto numero "+ listino[i].getMatricola() + "\n" + listino[i].toString());
				trovato=true;
				break;
			}
		}
		if(trovato==false) {
			System.out.println("Nessuna auto trovata del tipo richiesto!");
		}
	}
	
	/**
	 * Metodo per il recupero deglianni di un'auto a partire dalla sua targa.
	 * @param listino
	 */
	public static void recuperaAnniAuto(Auto[] listino) {

		Scanner tastiera=new Scanner(System.in);
		
		System.out.println("\nRrcupero anni veicolo in corso..");
		System.out.print("\nInserire targa dell'auto di cui si vuole verificare l'età:");
		String targaAuto=tastiera.next();
		
		System.out.print("\nInserire l'anno corrente:");
		int annoCorrente = tastiera.nextInt(); 
		
		boolean trovato = false;
		
		for(int i = 0; i < listino.length; i++) {
					
			if(listino[i].getTarga().equals(targaAuto)) {
				trovato = true;
				System.out.println("L'auto con targa "+targaAuto+" ha anni " + listino[i].calcolaAnni(annoCorrente));
				break;
			}
		}
		
		if(!trovato) {
			System.out.println("Auto non trovata!");
		}
	}
	
	/**
	 * Metodo che cerca l'auto con meno km
	 * @param listino
	 */
	public static boolean recuperaAutoConMenoKm(Auto[] listino) {
		
		boolean fail = false;
		
		System.out.print("\nInserire di seguito le targhe delle auto da confrontare: ");
		System.out.print("\nInserisci la prima targa: ");
		
		Scanner tastiera=new Scanner(System.in);
		
		String primaTarga=tastiera.next();
		System.out.print("\nInserisci la seconda targa: ");
		
		String secondaTarga=tastiera.next();
		
		Auto primaAuto = null;
		Auto secondaAuto = null;
		
		for(int i = 0; i < listino.length; i++) {
			if(listino[i].getTarga().equals(primaTarga)) {
				primaAuto = listino[i];
				break;
			}
		}
		if(primaAuto == null) {
			return true;
		}
		
		for(int i = 0; i < listino.length; i++) {
			if(listino[i].getTarga().equals(secondaTarga)) {
				secondaAuto = listino[i];
				break;
			}
		}
		
		if(secondaAuto == null) {
			return true;
		}
		
		String 	targaMenoKm = primaAuto.targaAutoConMenoKm(secondaAuto);
		
		 if(targaMenoKm.equals("")) {
			 //se i km percorsi dalle due auto sono uguali
			 System.out.println("Le auto " +primaTarga +" e "+secondaTarga+" hanno percorso un numero uguale di km");
		 } else {
			 // se il metodo è stato richiamato e si è avuto un risultato diverso da zero
			 System.out.println("Tra le auto " +primaTarga +" e "+secondaTarga+" quella con meno km percorsi è quella con la targa "+targaMenoKm);
		 }
	
		 
		 return fail;
		 
	}
	
}
