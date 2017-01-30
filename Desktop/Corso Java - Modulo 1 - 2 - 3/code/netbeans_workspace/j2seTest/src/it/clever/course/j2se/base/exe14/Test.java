package it.clever.course.j2se.base.exe14;

//classe principale in cui si creano istanze della classe Auto e si richiamo i metodi li definiti
import java.util.*;

public class Test {

	public static void main(String[] args) {
	
		Auto.TipoAuto tipo;
		
		int annoImm, kmPercorsi, annoCorrente;
		
		String targa,targaAuto, primaTarga, secondaTarga, targaMenoKm="no";
		
		Scanner tastiera=new Scanner(System.in);
		
		boolean trovato=false;
		
		System .out.println("Auto numero 1");
		Auto auto1=new Auto();	
		System .out.print("Che tipo di auto è? ");
		tipo=Auto.TipoAuto.valueOf(tastiera.next());
		auto1.setTipo(tipo);
		System .out.print("In quale anno è stata immatricolata? ");
		annoImm=tastiera.nextInt();
		auto1.setAnno(annoImm);
		System .out.print("Quale è la sua targa? ");
		targa=tastiera.next();
		auto1.setTarga(targa);
		System .out.print("Quanti km ha già percorso l'auto? ");
		kmPercorsi=tastiera.nextInt();
		auto1.setKm(kmPercorsi);
		
		System .out.println("Auto numero 2");
		Auto auto2=new Auto();	
		System .out.print("Che tipo di auto è? ");
		tipo=Auto.TipoAuto.valueOf(tastiera.next());
		auto2.setTipo(tipo);
		System .out.print("In quale anno è stata immatricolata? ");
		annoImm=tastiera.nextInt();
		auto2.setAnno(annoImm);
		System .out.print("Quale è la sua targa? ");
		targa=tastiera.next();
		auto2.setTarga(targa);
		System .out.print("Quanti km ha già percorso l'auto? ");
		kmPercorsi=tastiera.nextInt();
		auto2.setKm(kmPercorsi);
		
		System .out.println("Auto numero 3");
		Auto auto3=new Auto();	
		System .out.print("Che tipo di auto è? ");
		tipo=Auto.TipoAuto.valueOf(tastiera.next());
		auto3.setTipo(tipo);
		System .out.print("In quale anno è stata immatricolata? ");
		annoImm=tastiera.nextInt();
		auto3.setAnno(annoImm);
		System .out.print("Quale è la sua targa? ");
		targa=tastiera.next();
		auto3.setTarga(targa);
		System .out.print("Quanti km ha già percorso l'auto? ");
		kmPercorsi=tastiera.nextInt();
		auto3.setKm(kmPercorsi);
		
		System.out.println("\nParco macchine a disposizione:\n");
		System.out.println("\n" + auto1.toString());
		System.out.println("\n" + auto2.toString());
		System.out.println("\n" + auto3.toString());
		
		System.out.println("\nDi quale tipo di auto vuoi informazioni? (SPORTIVA, BERLINA, FAMILIARE) ");
		String risposta=(tastiera.next()).toUpperCase();
		tipo=Auto.TipoAuto.valueOf(risposta);  
		
			if(auto1.getTipo()==tipo){ 
				System.out.println("Auto numero 1 \n"+auto1.toString());
				trovato=true;
			}if(auto2.getTipo()==tipo){
				System.out.println("Auto numero 2 \n"+auto2.toString());
				trovato=true;
			}if(auto3.getTipo()==tipo){
				System.out.println("Auto numero 3 \n"+auto3.toString());
				trovato=true;
			}if(trovato==false)
				System.out.println("Nessuna auto trovata del tipo richiesto!");
		
	
		System.out.print("\nInserire targa dell'auto di cui si vuole verificare l'età e anno corrente:");
		targaAuto=tastiera.next();
		annoCorrente=tastiera.nextInt(); 
		
		if(auto1.getTarga().equals(targaAuto))
			System.out.println("L'auto con targa "+targaAuto+" ha anni "+auto1.calcolaAnni(annoCorrente));
		else if(auto2.getTarga().equals(targaAuto))
			System.out.println("L'auto con targa "+targaAuto+" ha anni "+auto2.calcolaAnni(annoCorrente));
		else if(auto3.getTarga().equals(targaAuto))
			System.out.println("L'auto con targa "+targaAuto+" ha anni "+auto3.calcolaAnni(annoCorrente));
		else
			System.out.println("Auto non trovata!");// nel caso che la targa inserita non corrispondesse a quella di nessuna auto
		
		
		System.out.print("\nInserire di seguito le targhe delle auto da confrontare: ");
		System.out.print("\nInserisci la prima targa: ");
		primaTarga=tastiera.next();
		System.out.print("\nInserisci la seconda targa: ");
		secondaTarga=tastiera.next();
		if((auto1.getTarga().equals(primaTarga) && auto2.getTarga().equals(secondaTarga))||(auto1.getTarga().equals(secondaTarga) && auto2.getTarga().equals(primaTarga)))
			targaMenoKm=auto1.targaAutoConMenoKm(auto2);
		else if((auto1.getTarga().equals(primaTarga) && auto3.getTarga().equals(secondaTarga))||(auto1.getTarga().equals(secondaTarga) && auto3.getTarga().equals(primaTarga)))
			targaMenoKm=auto1.targaAutoConMenoKm(auto3);
		else if((auto2.getTarga().equals(primaTarga) && auto3.getTarga().equals(secondaTarga))||(auto2.getTarga().equals(secondaTarga) && auto3.getTarga().equals(primaTarga)))
			targaMenoKm=auto2.targaAutoConMenoKm(auto3);
					
			
		 if(targaMenoKm.equals("")) //se i km percorsi dalle due auto sono uguali
			 System.out.println("Le auto " +primaTarga +" e "+secondaTarga+" hanno percorso un numero uguale di km");
		 else if(targaMenoKm.equals("no")) // se non è si è mai richiamato il metodo targaAutoConMenoKm 
			 System.out.println("Una o più targhe non trovate! ");
		 else// se il metodo è stato richiamato e si è avuto un risultato diverso da zero
			 System.out.println("Tra le auto " +primaTarga +" e "+secondaTarga+" quella con meno km percorsi è quella con la targa "+targaMenoKm);
			
	}
}
