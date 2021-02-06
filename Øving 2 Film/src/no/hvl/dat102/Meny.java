package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.adt.FILMarkivADT;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private FILMarkivADT filma;
	
	final String MAPPE = System.getProperty("user.dir") + "src/no/hvl/dat102/" ;
	final String FILNAVN = "FilmFil.txt";
	
	public Meny() {
		tekstgr = new Tekstgrensesnitt();
		
		System.out.println("Håndtering av filmarkiv: Skriv 1 for nytt arkiv eller 0 for eksisterende:");
		int valg = Tekstgrensesnitt.TAST.nextInt();
		
		switch (valg) {
		
		case 1: filma = new Filmarkiv2();break;
			
		case 0: { 
			try {
		
			filma = Fil.lesFraFil(FILNAVN);break;
		}
			
			catch (NumberFormatException e) {
			System.out.println("Filmarkiv fantes ikke på fil, oppretter nytt");
			filma = new Filmarkiv2();break;
		}
		}	
		
		default: System.out.println("Ikke gyldig valg");
	}
		
	}
	
	public void start() {
		
		//Legge inn filmer fra konsollen, kan legge inn så mange man vil til man velger å avslutte
		int valg;
		do {
		filma.leggTilFilm(tekstgr.lesFilm());
		
		System.out.println("Skriv 1 for å ligge til enda en film, skriv 0 for å avslutte inlegg");
		valg = Tekstgrensesnitt.TAST.nextInt();
		
		}
		while (valg == 1);
		
		/*
		 * Skrive ut statistikk, enkel linje for å teste søk av produsent/tittel, 
		 * samt teste slette funksjon. Har ikke lagt inn do-while her, er kun testing av hver enkelt funksjon
		 */
		System.out.println("Her kommer litt statistikk fra filmarkivet\n");
		tekstgr.skrivUtStatistikk(filma);
		System.out.println("\n Skriv en del av navnet på filmen for å se om den finnes i arkivet: ");
		String filmDelstreng = Tekstgrensesnitt.TAST.next();
		filmDelstreng += Tekstgrensesnitt.TAST.nextLine();
		tekstgr.skrivUtFilmDelstrengITittel(filma, filmDelstreng);
		System.out.println("\n Skriv en del av navnet på en regissør/produsent for å se om filmer av dem finnes i arkivet");
		String skaperDelstreng = Tekstgrensesnitt.TAST.next();
		skaperDelstreng += Tekstgrensesnitt.TAST.nextLine();
		tekstgr.skrivUtFilmProdusent(filma, skaperDelstreng);
		
		System.out.println("Skriv inn nr på film du vil slette fra arkivet (-1 hvis du ikke vil slette noen)");
		if (filma.slettFilm(Tekstgrensesnitt.TAST.nextInt())) {
			System.out.println("Film ble slettet");
		}
		else {
			System.out.println("Film kunne ikke slettes");
		}
		
		Fil.skrivTilFil(filma, FILNAVN);
		System.out.println("Filmarkiv burde nå være lagret på fil");
		Tekstgrensesnitt.TAST.close();
}
}