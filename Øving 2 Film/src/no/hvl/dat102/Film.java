package no.hvl.dat102;

public class Film {
	
private int filmnr;
private String filmskaper;
private String tittel;
private int aar;
private Sjanger sjanger;
private String filmselskap;

public Film() {
	
}

/*
 * Konstruktør som gir filmnr gitt som parameter (brukt til innlesing)
 * Mulighet for forbedring: Tildele et ubrukt filmnr automatisk ved innlesing av ny film
 */

public Film(int filmnr, String skaper, String tittel, int aar, Sjanger sjanger, String selskap) {
	this.filmnr = filmnr;
	filmskaper = skaper;
	this.tittel = tittel;
	this.aar = aar;
	this.sjanger = sjanger;
	filmselskap = selskap;
}

public int getFilmnr() {
	return filmnr;
}

public void setFilmnr(int filmnr) {
	this.filmnr = filmnr;
}

public String getFilmskaper() {
	return filmskaper;
}

public void setFilmskaper(String filmskaper) {
	this.filmskaper = filmskaper;
}

public String getTittel() {
	return tittel;
}

public void setTittel(String tittel) {
	this.tittel = tittel;
}

public int getAar() {
	return aar;
}

public void setAar(int aar) {
	this.aar = aar;
}

public Sjanger getSjanger() {
	return sjanger;
}

public void setSjanger(Sjanger sjanger) {
	this.sjanger = sjanger;
}

public String getFilmselskap() {
	return filmselskap;
}

public void setFilmselskap(String filmselskap) {
	this.filmselskap = filmselskap;
}





}
