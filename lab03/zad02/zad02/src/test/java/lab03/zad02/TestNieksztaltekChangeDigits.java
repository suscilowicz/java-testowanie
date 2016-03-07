package lab03.zad02;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matcher.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestNieksztaltekChangeDigits {
	private Kontrakt kontrakt;
	private int testData;
	private ArrayList<Integer> expectedResult;
	
	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
        	new Object[][]{ 
               	{376, new ArrayList<Integer>() {{ add(876); add(316); add(379);}}},
               	{475356, new ArrayList<Integer>() {{ add(475856); add(445359); add(415356);}}},
               	{-475356, new ArrayList<Integer>() {{ add(-475856); add(-445359); add(-415356);}}},
        	});
    }
    
    public TestNieksztaltekChangeDigits(int data, ArrayList<Integer>expected){
		testData = data;
		expectedResult = expected;
	}

	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}

	@Test
	public void testWhereNieksztaltekChangeDigits() {
		int result = kontrakt.Nieksztaltek(testData);
		assertThat(expectedResult, hasItem(result));
	}
}
