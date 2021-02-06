package no.hvl.dat102;

import no.hvl.dat102.adt.FILMarkivADT;

public class Filmarkiv implements FILMarkivADT {
	
private Film[] filmtabell;
private int antall;

	public Filmarkiv() {
		filmtabell = new Film[50];
	}
	
	public Filmarkiv(int n) {
		filmtabell = new Film[n];
	}

	@Override
	public Film[] hentFilmTabell() {
		return filmtabell;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall < filmtabell.length) {
		filmtabell[antall] = nyFilm;
		antall++;
		}
		else {
			utvidKapasitet();
			filmtabell[antall] = nyFilm;
			antall++;
		}
	}

	@Override
	public boolean slettFilm(int filmnr) {
		for(int i=0; i<antall; i++) {
			if (filmtabell[i].getFilmnr() == filmnr)
				antall--;
				filmtabell[i] = filmtabell[antall];
				return true;
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] nytab = new Film[antall];
		int nyant = 0;
		for (int i=0; i<antall; i++) {
			if (filmtabell[i].getTittel().toUpperCase().contains(delstreng.toUpperCase())) {
				nytab[nyant] = filmtabell[i];
				nyant++;
			}
		} 
		return trimTab(nytab, nyant);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] nytab = new Film[antall];
		int nyant = 0;
		for (int i=0; i<antall; i++) {
			if (filmtabell[i].getFilmskaper().toUpperCase().contains(delstreng.toUpperCase())) {
				nytab[nyant] = filmtabell[i];
				nyant++;
			}
		} 
		return trimTab(nytab, nyant);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int ant=0;
		for (int i=0; i<antall; i++) {
			if (filmtabell[i].getSjanger() == sjanger)
				ant++;
		}
		return ant;
	}

	@Override
	public int antall() {
		
		return antall;
	}
	
	private Film[] trimTab(Film[] tab, int n) { // n er antall elementer
		 Film[] filmtab2 = new Film[n];
		 int i = 0;
		 while (i < n) {
		filmtab2[i] = tab[i];
		i++;
		 }
		 return filmtab2;
		}
	
	private void utvidKapasitet(){  //eks. utvide 10%
		 Film[] hjelpetabell = new Film[(int)Math.ceil(1.1 *
		filmtabell.length)];
		 for (int i = 0; i < filmtabell.length; i++){
		 hjelpetabell[i] = filmtabell[i];
		 }
		 filmtabell = hjelpetabell;
		}

	

}
