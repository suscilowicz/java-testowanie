package lab03.zad02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCyfroKradException {
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
	public void testCyfroKradNull() {
		try {
			kontrakt.CyfroKrad(null);
			fail("Test is incorrect");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

}
