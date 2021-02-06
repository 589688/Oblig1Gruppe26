package no.hvl.dat102.sirkulaer;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeTestADT;

public class SirkulaerKoeTest extends KoeTestADT {
	
	/*
	 * Status: SirkulaerKoeTest validerer
	 */

	@Override
	protected KoeADT<Integer> reset() {
		return new SirkulaerKoe<Integer>();
	}
	
}