package com.example.zad5;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LiczbaRzymskaTest {
	private String test;

	@Before
	public void setUp(){
		test = "";
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void mniejszaOd1(){
		test = new LiczbaRzymska(0).toString();
	}
	@Test(expected = IllegalArgumentException.class)
	public void wiekszaOd3999(){
		test = new LiczbaRzymska(4000).toString();
	}
	@Test
	public void wynikNieJestPusty(){
		assertNotNull(test = new LiczbaRzymska(267).toString());
	}
	@Test
	public void wynikJestDobry(){
		assertEquals("CCLVI",test = new LiczbaRzymska(256).toString());
	}
	
	@After
	public void tearDown(){
		test = null;
	}
}
