package lab03.zad02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTititException {
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
	public void testTititThrowArithmeticException() {
		try {
			kontrakt.Titit(0);
			fail("Test is incorrect");
		} catch (ArithmeticException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testTititThrowNullPointerException() {
		try {
			kontrakt.Titit(null);
			fail("Test is incorrect");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

}
