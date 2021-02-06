package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.adt.FILMarkivADT;

public class Tekstgrensesnitt {
	
	public final static Scanner TAST = new Scanner(System.in);
	
	// lese opplysningene om en FILM fra tastatur, lage nytt Film objekt med disse opplysnignene
	 public Film lesFilm() {
		 
		 System.out.println("Skriv filmnr");
		 int nr = TAST.nextInt();
		 
		 System.out.println("Skriv filmskaper:");
		 String skaper = TAST.next();
		 skaper += TAST.nextLine();
		 
		 System.out.println("Skriv filmtittel: ");
		 String tittel = TAST.next();
				tittel += TAST.nextLine();
		 
		 System.out.println("Skriv utgivelsesår: ");
		 int aar = TAST.nextInt();
		 
		 System.out.println("Skriv filmsjanger: ");
		 String sj = TAST.next();
		 sj += TAST.nextLine();
		 Sjanger sjanger = Sjanger.finnSjanger(sj);
		
		 System.out.println("Skriv filmselskap: ");
		 String selskap = TAST.next();
		 selskap += TAST.nextLine();
		
		 
		Film film = new Film(nr, skaper, tittel, aar, sjanger, selskap);
		
		 return film;
	 }
	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	 public void visFilm(Film film){
		 System.out.println("Filmen vises");
		 System.out.println("Info om film\n" + film.toString());
		 
	 }
	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	 public void skrivUtFilmDelstrengITittel(FILMarkivADT filma, String delstreng){
		 Film[] film = filma.soekTittel(delstreng);
		 
		 System.out.println("Filmer med navn: " + delstreng);
		 for (Film x : film) {
			 System.out.println(x.getTittel());
		 }
	 }
	// Skriver ut alle Filmer av en produsent / en gruppe
	 public void skrivUtFilmProdusent(FILMarkivADT filma, String delstreng) {
		 Film[] film = filma.soekProdusent(delstreng);
		 
		 System.out.println("Filmer av produsent: " + delstreng);
		 for (Film x: film) {
			 System.out.println(x.getTittel());
		 }
		 
	 }
	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	 public void skrivUtStatistikk(FILMarkivADT filma){
		  System.out.println("Antall filmer er: " + filma.antall());
		  System.out.println("Antall filmer i hver sjanger ser slik ut: ");
		  
		  for (Sjanger x : Sjanger.values()) {
			  System.out.println(x + " " + filma.antall(x));
		  }
	 }
	
	}


