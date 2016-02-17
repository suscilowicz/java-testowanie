package com.example.nwd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NWDTest {
	private NWD test;
	@Before
	public void setUp(){
		test = new NWD();
	}
	
	@Test
	public void resultIsNotNull(){
		assertNotNull(test.nwd(8,0));
	}
	
	@Test
	public void correctResult(){
		assertEquals(1, test.nwd(3,2));
	}
	
	@Test
	public void correctResult_2(){
		assertNotSame(2, test.nwd(5,2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void secondIntLowerThen0(){
		test.nwd(3,-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void firstIntLowerThen0(){
		test.nwd(-1,3);
	}
		
	@After
	public void tearDown(){
		test = null;
	}
}
