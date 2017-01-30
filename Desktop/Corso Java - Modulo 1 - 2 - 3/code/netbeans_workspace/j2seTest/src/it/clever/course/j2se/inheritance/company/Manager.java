package it.clever.course.j2se.inheritance.company;

public class Manager extends Impiegato {

	private String nomeSegretaria;

	public Manager(String n, double s, String m, int ads, String ns) {
		super(n, s, m, ads);
		nomeSegretaria = ns;
	}

	public void incrementaSalario(double percentuale) {
        // Aggiunge alla percentuale lo 0.5% per ogni anno di servizio
        double bonus = 0.5 * getAnniServizio();
        super.incrementaSalario(percentuale + bonus);
    }

	public String getNomeSegretaria() {
		return nomeSegretaria;
	}

	public void setNomeSegretaria(String nome) {
		nomeSegretaria = nome;
	}
	
	@Override
	public String toString() {
		/*
		 * Richiama il metodo toString() della classe padre
		 * per non perdere le sue potenzialità di base.
		 * Mancasse questa chiamata, il metodo della superclassse verrebbe
		 * completamente offuscato. 
		 */
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\nSegretaria: " + nomeSegretaria);
		return sb.toString();
	}
}
