package lab03.zad02;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCyfroKradCorrect {
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
	public void testOneDigit() {
		Integer result = kontrakt.CyfroKrad(1);
		assertThat(result, nullValue());
	}
	@Test
	public void testTwoDigits() {
		Integer result = kontrakt.CyfroKrad(12);
		assertThat(result, either(is(1)).or(is(2)));
	}

}
