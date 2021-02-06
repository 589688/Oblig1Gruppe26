package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.exception.EmptyCollectionException;

public abstract class KoeTestADT {

	private KoeADT<Integer> koe;
	
	//Testdata
	private Integer t1 = 0;
	private Integer t2 = 2;
	private Integer t3 = 2;
	private Integer t4 = 3;
	private Integer t5 = 10;

	
	protected abstract KoeADT<Integer> reset();
	/**
	 * Lager en ny kø før hver test
	 * 
	 * @return	
	 */
	
	@BeforeEach 
	public void setup() {
		koe = reset();
	}
	
	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}
	
	/**
	 * Teste innKoe og utKoe
	 */
	
	@Test
	public void innOgUt() {
		koe.innKoe(t1);
		koe.innKoe(t2);
		koe.innKoe(t3);
		koe.innKoe(t4);
		
		try {
			assertEquals(t1, koe.utKoe());
			assertEquals(t2, koe.utKoe());
			assertEquals(t3, koe.utKoe());
			assertEquals(t4, koe.utKoe());
		}
		
		catch (EmptyCollectionException e) {
			fail("Uventet feil utKoe" + e.getMessage());
		}
	}
	/**
	 * Teste innKoe og utKoe med duplikat
	 */
	@Test
	public void innOgUtMedDuplikater() {
		koe.innKoe(t1);
		koe.innKoe(t2);
		koe.innKoe(t3);
		koe.innKoe(t4);
		
		try {
			assertEquals(t1, koe.utKoe());
			assertEquals(t2, koe.utKoe());
			assertEquals(t3, koe.utKoe());
			assertEquals(t4, koe.utKoe());
		}
		
		catch (EmptyCollectionException e) {
			fail("Uventet feil utKoe" + e.getMessage());
		}
	}
	
	/**
	 * Teste inn/ut og om første blir returnert uten å slette
	 */
	@Test
	public void InnUtOgFoerste() {
		koe.innKoe(t1);
		koe.innKoe(t2);
		koe.innKoe(t3);
		
		try {
			assertEquals(t1, koe.utKoe());
			assertEquals(t2, koe.foerste());
			assertEquals(2, koe.antall());
		}
		
		catch (EmptyCollectionException e) {
			fail("Uventet feil inn/ut/foerste" + e.getMessage());
		}
	}
	
	/**
	 * Teste ikke tom koe
	 */
	@Test
	public void ikkeTom() {
		koe.innKoe(t1);
		koe.innKoe(t2);
		assertFalse(koe.erTom());
	}
	
	/**
	 * Teste om tom koe er tom
	 */
	@Test 
	public void innUtErTom() {
		try {
		koe.innKoe(t4);
		koe.utKoe();
		assertTrue(koe.erTom());
		}
		
		catch (EmptyCollectionException e) {
			fail("inn/ut feilet uventet" + e.getMessage());
		}
	}
	
	/**
	 * Teste størrelse
	 */
	@Test
	public void stor() {
		koe.innKoe(t1);
		koe.innKoe(t2);
		koe.innKoe(t3);
		koe.innKoe(t5);
		assertEquals(4, koe.antall());
	}
	
	/**
	 * utKoe fra tom koe skal gi underflow exception
	 */
	@Test
	public void UtKoeFraTom() {
		
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}
	
}

















