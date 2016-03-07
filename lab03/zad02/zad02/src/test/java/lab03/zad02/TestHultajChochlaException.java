package lab03.zad02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHultajChochlaException {
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
	public void testHultajChochlaNull() throws NieudanyPsikusException {
		try {
			kontrakt.HultajChochla(null);
			fail("Test is incorrect");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testHultajChochlaNieudanyPsikus() throws NieudanyPsikusException {
		try {
			kontrakt.HultajChochla(1);
			fail("Test is incorrect");
		} catch (NieudanyPsikusException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testHultajChochlaNieudanyPsikus2() throws NieudanyPsikusException {
		try {
			kontrakt.HultajChochla(10);
			fail("Test is incorrect");
		} catch (NieudanyPsikusException e) {
			assertTrue(true);
		}
	}

}
