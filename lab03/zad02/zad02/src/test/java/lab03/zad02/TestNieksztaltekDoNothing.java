package lab03.zad02;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestNieksztaltekDoNothing {
	private Kontrakt kontrakt;
	private int testData;
	private int expectedResult;
	
	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
        	new Object[][]{ 
        		{1, 1},
               	{22, 22},
               	{245, 245},
               	{0,0},
               	{888999, 888999},
               	{-888999, -888999},
               	{-1, -1},
               	{-4545, -4545},
               	{-12458, -12458}
        	});
    }
    
    public TestNieksztaltekDoNothing(int data, int expected){
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
	public void testWhereNieksztaltekDoNothing() {
		int result = kontrakt.Nieksztaltek(testData);
		assertThat(result, is(expectedResult));
	}

}
