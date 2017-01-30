package it.clever.course.j2se.base.classes;

public class Persona {

	public static int counter = 0;

	public int code;

	public Long id;
	private String nome;
	private String cognome;
	private String codFisc;
	private int anno;

	public Persona() {
		System.out.println("Costruttore di base.");
		this.code = ++counter;
	}

	public Persona(Long id) {
		this();
		this.id = id;
	}

	public Persona(Long id, String nome, String cognome, String codFisc) {
		this(id);

		System.out.println("Costruttore parametrico.");

		this.nome = nome;
		this.cognome = cognome;
		this.codFisc = codFisc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodFisc() {
		return codFisc;
	}

	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		if (anno >= 1996) {
			this.anno = anno;
		} else {
			System.out.println("Non puoi accedere");
		}
	}

	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome
				+ ", codFisc=" + codFisc + "]";
	}

}
