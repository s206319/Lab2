package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String parola;
	private boolean corretta;
	
	public RichWord(String parola) {
		this.parola = parola;
		corretta=false;
	}
	public boolean isCorretta() {
		return corretta;
	}
	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}
	public String getParola() {
		return parola;
	}
	@Override
	public String toString() {
		return "RichWord [parola=" + parola + ", corretta=" + corretta + "]";
	}
	
	
}
