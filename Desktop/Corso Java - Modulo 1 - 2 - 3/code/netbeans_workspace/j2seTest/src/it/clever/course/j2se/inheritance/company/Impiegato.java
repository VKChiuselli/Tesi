package it.clever.course.j2se.inheritance.company;

public class Impiegato {
	
	private String nome;
	private double salario;
	private String matricola;
	private int anniDiServizio;

	public Impiegato(String n, double s, String m, int ads) {
		nome = n;
		salario = s;
		matricola = m;
		anniDiServizio = ads;
	}

	public void incrementaSalario(double percentuale) {
		salario = salario * 1 + percentuale / 100;
	}

	public String getNome() {
		return nome;
	}

	public int getAnniServizio() {
		return anniDiServizio;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nNome:" + nome);
		sb.append("\nMatricola:" + matricola);
		sb.append("\nAnni di servizio:" + anniDiServizio);
		sb.append("\nSalario:" + salario);
		return sb.toString();
	}
}
