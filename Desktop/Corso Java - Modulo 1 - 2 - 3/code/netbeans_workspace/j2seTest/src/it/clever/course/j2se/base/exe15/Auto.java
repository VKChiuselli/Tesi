package it.clever.course.j2se.base.exe15;

//Definizione di costrutture vuoto e di alcuni metodi 

public class Auto {
	
	public static enum TipoAuto{SPORTIVA, FAMILIARE, BERLINA};
	
	private static int counter;
	private int matricola;
	private String targa;
	private TipoAuto tipo;
	private int km,annoImm;
	
	public Auto(){
		this.matricola = ++counter;
	}

	//metodi set
	
	public void setTipo(TipoAuto tipo){
		this.tipo=tipo;
	}

	public void setKm(int km){
		this.km=km;
	}
	public void setAnno(int anno){
		this.annoImm=anno;
	}
	public void setTarga(String targa){
		this.targa=targa;
	}
	
	//metodi get
	
	public int getMatricola() {
		return matricola;
	}
	
	public TipoAuto getTipo(){
		return this.tipo;
	}
	public int getKm(){
		return this.km;
	}
	public int getAnno(){
		return this.annoImm;
	}
	public String getTarga(){
		return this.targa;
	}
	
	public String toString(){
		return
				"Targa: "+this.targa+
				"\nTipo: "+this.tipo+
				"\nAnno di immatricolazione: "+this.annoImm+
				"\nKm percorsi: "+this.km + 
				"\nMatricola:" + this.matricola;
	}
	
	//metodo che ritorna la differenza fra l'anno attuale e quello di immatricolazione
	public int calcolaAnni(int annoCorrente){
		int differenza;
		differenza=annoCorrente-this.getAnno();
		return differenza;
		//oppure solo: return annoCorrente-this.getAnno();
	}
	
	//metodo che confronta i km percorsi da due auto ritornando la targa di quella con meno km
	public String targaAutoConMenoKm(Auto auto){
		if(this.getKm() > auto.getKm())
			return auto.getTarga();
		else if(this.getKm() < auto.getKm())
			return this.getTarga();
		else// se i km sono uguali
			return ""; //stringa vuota!
	}
	
	
}
