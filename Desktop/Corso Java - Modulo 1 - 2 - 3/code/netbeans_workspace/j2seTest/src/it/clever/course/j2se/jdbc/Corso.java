package it.clever.course.j2se.jdbc;


public class Corso {

	private Long id;
	private String titolo;
	private String codice;
	private String note;
	private Integer durata;
	
	
	public Corso(Long id, String titolo, String codice, String note, Integer durata) {
		this.id = id;
		this.titolo = titolo;
		this.codice = codice;
		this.note = note;
		this.durata = durata;
	}


//mappo uno a uno, un oggetto del DB con uno Java.
	public Corso() {
		
	}


	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getDurata() {
		return durata;
	}

	public void setDurata(Integer durata) {
		this.durata = durata;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id2) {
		this.id = id2;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


}
