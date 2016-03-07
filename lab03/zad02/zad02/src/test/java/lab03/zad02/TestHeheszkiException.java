package lab03.zad02;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHeheszkiException {
	private Kontrakt kontrakt;

	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}
	
	@Test
	public void testHeheszkiThrowException() {
		try {
			kontrakt.Heheszki(-2);
			fail("Test is incorrect");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testHeheszkiMinInt() {
		try {
			kontrakt.Heheszki(Integer.MIN_VALUE);
			fail("Test is incorrect");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

}
