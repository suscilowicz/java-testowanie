package lab03.zad02;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHeheszkiCorrect {
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
	public void testCorrectHeheszki() {
		int result = kontrakt.Heheszki(100);
		assertThat(result, is(both(greaterThanOrEqualTo(0)).and(lessThan(100))));
	}
	
	@Test
	public void testHeheszkiWhen0() {
		int result = kontrakt.Heheszki(0);
		assertEquals(result, 0);
	}
	
	@Test
	public void testHeheszkiMaxInt() {
		int result = kontrakt.Heheszki(Integer.MAX_VALUE);
		assertThat(result, is(both(greaterThanOrEqualTo(0)).and(lessThan(Integer.MAX_VALUE))));
	}

}
