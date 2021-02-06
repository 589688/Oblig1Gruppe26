package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeTestADT;

public class KjedetKoeTest extends KoeTestADT {

	/*
	 * Status: KjedetKoeTest validerer
	 */
	

	@Override
	protected KoeADT<Integer> reset() {
		return new KjedetKoe<Integer>();
	}
	
	
}
