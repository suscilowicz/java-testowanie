package lab03.zad02;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)

public class TestCyfroKradCorrectWithParams {
	private Kontrakt kontrakt;
	private int testData;
	private ArrayList<Integer> expectedResult;
	public TestCyfroKradCorrectWithParams(int data, ArrayList<Integer>expected){
		testData = data;
		expectedResult = expected;
	}
	
	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{468, new ArrayList<Integer>() {{ add(46); add(48); add(68); }}},
                	{-987, new ArrayList<Integer>() {{ add(-98); add(-87); add(-97); }}},
                	{888, new ArrayList<Integer>() {{ add(88); }}}
                });
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
	public void testThreeDigits() {
		int result = kontrakt.CyfroKrad(testData);
		assertThat(expectedResult, hasItem(result));
	}

}
