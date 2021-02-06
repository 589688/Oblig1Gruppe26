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
		
		Scanner skanner = new Scanner(System.in);
		System.out.println("H�ndtering av filmarkiv: Skriv 1 for nytt arkiv eller 0 for eksisterende:");
		int valg = skanner.nextInt();
		
		switch (valg) {
		
		case 1: filma = new Filmarkiv2();break;
			
		case 0: { 
			try {
		
			filma = Fil.lesFraFil(FILNAVN);break;
		}
			
			catch (NumberFormatException e) {
			System.out.println("Filmarkiv fantes ikke p� fil, oppretter nytt");
			filma = new Filmarkiv2();break;
		}
		}	
		
		default: System.out.println("Ikke gyldig valg");
	}
		
	}
	
	public void start() {
		Scanner skanner = new Scanner(System.in);
		
		//Legge inn filmer fra konsollen, kan legge inn s� mange man vil til man velger � avslutte
		int valg;
		do {
		filma.leggTilFilm(tekstgr.lesFilm());
		
		System.out.println("Skriv 1 for � ligge til enda en film, skriv 0 for � avslutte inlegg");
		valg = skanner.nextInt();
		
		}
		while (valg == 1);
		
		/*
		 * Skrive ut statistikk, enkel linje for � teste s�k av produsent/tittel, 
		 * samt teste slette funksjon. Har ikke lagt inn do-while her, er kun testing av hver enkelt funksjon
		 */
		System.out.println("Her kommer litt statistikk fra filmarkivet\n");
		tekstgr.skrivUtStatistikk(filma);
		System.out.println("\n Skriv en del av navnet p� filmen for � se om den finnes i arkivet: ");
		String filmDelstreng = skanner.next();
		filmDelstreng += skanner.nextLine();
		tekstgr.skrivUtFilmDelstrengITittel(filma, filmDelstreng);
		System.out.println("\n Skriv en del av navnet p� en regiss�r/produsent for � se om filmer av dem finnes i arkivet");
		String skaperDelstreng = skanner.next();
		skaperDelstreng += skanner.nextLine();
		tekstgr.skrivUtFilmProdusent(filma, skaperDelstreng);
		
		System.out.println("Skriv inn nr p� film du vil slette fra arkivet");
		if (filma.slettFilm(skanner.nextInt())) {
			System.out.println("Film ble slettet");
		}
		else {
			System.out.println("Film kunne ikke slettes");
		}
		
		Fil.skrivTilFil(filma, FILNAVN);
		System.out.println("Filmarkiv burde n� v�re lagret p� fil");
		skanner.close();
}
}