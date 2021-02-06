package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import no.hvl.dat102.adt.FILMarkivADT;

public class Fil {
	final static String SKILLE = "#";
	
	
	
	//Lese inn fra korrekt fil og lage film objekt som settes inn i filmarkiv som returneres
	public static FILMarkivADT lesFraFil(String filnavn) {
		FILMarkivADT farkiv = null;
		FileReader fil = null;
		BufferedReader les = null;
		
		try {
			fil = new FileReader(filnavn);
			}
			
		
		catch (FileNotFoundException e) {
			System.out.println("Fant ikke fil å lese fra");
		}
		
		try {
			les = new BufferedReader(fil);
			
			//lese inn antall filmer fra første linjen
			String første = les.readLine();
			int ant = Integer.parseInt(første);
			
			farkiv = new Filmarkiv2();
			
			String linje = les.readLine();
			for (int i=0; i<ant; i++) {
				String[] rad = linje.split(SKILLE);
				
				int nr = Integer.parseInt(rad[0]);
				String skaper = rad[1];
				String tittel = rad[2];
				int aar = Integer.parseInt(rad[3]);
				Sjanger sjanger = Sjanger.finnSjanger(rad[4]);
				String selskap = rad[5];
				
				Film f = new Film(nr, skaper, tittel, aar, sjanger, selskap);
				farkiv.leggTilFilm(f);
				
				linje = les.readLine();
				
			}
			
		}
			
		catch (IOException e) {
			System.out.println("Fant ikke til å lese fra");
		}
		return farkiv;
	}
	
	
	public static void skrivTilFil(FILMarkivADT filmarkiv, String filnavn) {
		
		try {
			
			FileWriter fw = new FileWriter(filnavn, false);
			PrintWriter wr = new PrintWriter(fw);
			
			wr.println(filmarkiv.antall());
			//printe opplysningene for en film på hver linje, filmarkiv er ikke nødvendigvis en tabell
			
			Film[] f = filmarkiv.hentFilmTabell();
			for (int i=0; i<filmarkiv.antall(); i++) {
				wr.print(f[i].getFilmnr() + SKILLE);
				wr.print(f[i].getFilmskaper() + SKILLE);
				wr.print(f[i].getTittel() + SKILLE);
				wr.print(f[i].getAar() + SKILLE);
				wr.print(f[i].getSjanger() + SKILLE);
				wr.println(f[i].getFilmselskap());
				
			}
			
		wr.close();
			
		}
		
		catch (IOException e) {
			System.out.println("Feil ved skriving til fil");
		}
		
		
	}
	 

}
