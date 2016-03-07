package lab03.zad02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTititCorrect {
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
	public void testTititWhenCukierekIsNotChanged() {
		boolean result = kontrakt.Titit(1);
		assertEquals(result, true);
	}
	@Test
	public void testTititWhenCukierekIsNotChanged2() {
		boolean result = kontrakt.Titit(-1);
		assertEquals(result, true);
	}
	@Test
	public void testTititWhenCukierekIsChanged() {
		kontrakt.cukierek=1;
		boolean result = kontrakt.Titit(1);
		assertEquals(result, true);
	}
	@Test
	public void testTititWhenCukierekIsChanged2() {
		kontrakt.cukierek = 25;
		boolean result = kontrakt.Titit(5);
		assertEquals(result, true);
	}
	@Test
	public void testTititWhenCukierekIsChangedThrowsFalse() {
		kontrakt.cukierek = 25;
		boolean result = kontrakt.Titit(10);
		assertEquals(result, false);
	}

}
