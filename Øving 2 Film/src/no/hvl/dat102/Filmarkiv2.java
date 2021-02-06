package no.hvl.dat102;

import no.hvl.dat102.adt.FILMarkivADT;

public class Filmarkiv2 implements FILMarkivADT {

	private int antall;
	private LinearNode<Film> start;
	
	@Override
	public Film[] hentFilmTabell() {
		Film[] filmtab = new Film[antall];
		
		LinearNode<Film> curr = start;
		for (int i=0; i<antall; i++) {
			Film f1 = curr.getElement();
			filmtab[i] = f1;
			curr = curr.getNeste();
		}
		return filmtab;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> n = new LinearNode<>(nyFilm);
		
		n.setNeste(start);
		start = n;
		
		antall++;
	}

	/*
	 * Skal slette første forekomst av filmnr, håndterer tomt arkiv
	 * Kan ryddes opp, unødvendig å sjekke start? Unødvendig å deklarere hjelpevariabler?
	 */
	
	@Override
	public boolean slettFilm(int filmnr) {
		
		if (start == null) {
			return false;
		}
		else if (start.getElement().getFilmnr() == filmnr) {
			start = start.getNeste();
			antall--;
			return true;
			
		}
		else {
			LinearNode<Film> curr = start;
			LinearNode<Film> skalSlettes = null;
			Film f1;
			while (curr.getNeste() != null) {
				skalSlettes = curr.getNeste();
				f1 = skalSlettes.getElement();
				if (f1.getFilmnr() == filmnr) {
					curr.setNeste(skalSlettes.getNeste());
					antall--;
					return true;
				}
				
				curr = curr.getNeste();
			}
		}
		return false;
	}
	
	//Håndterer ikke tomt arkiv ved søk
	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] tab = new Film[antall];
		int ant = 0;
		LinearNode<Film> curr = start;
		for (int i=0; i<antall; i++) {
			
			Film f1 = curr.getElement();
			if (f1.getTittel().toUpperCase().contains(delstreng.toUpperCase())) {
				tab[ant] = f1;
				ant++;
			}
			curr = curr.getNeste();
		}
		return trimTab(tab, ant);
	}
	//Håndterer ikke tomt arkiv ved søk
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] tab = new Film[antall];
		int ant = 0;
		LinearNode<Film> curr = start;
		for (int i=0; i<antall; i++) {
			Film f1 = curr.getElement();
			if (f1.getFilmskaper().toUpperCase().contains(delstreng.toUpperCase())) {
				tab[ant] = f1;
				ant++;
			}
			curr = curr.getNeste();
		}
		return trimTab(tab, ant);
	}

	@Override
	public int antall(Sjanger sjanger) {
		
		int ant = 0;
		LinearNode<Film> curr = start;
		for (int i=0; i<antall; i++) {
			Film f1 = curr.getElement();
			if (f1.getSjanger() == sjanger) {
				ant++;
			}
			curr = curr.getNeste();
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
}
