package com.example.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	private Calculator calc = new Calculator();
	@Test
	public void addCheck(){
		assertEquals(5.1, calc.add(3.0,2.1), 0.1);
	}
	@Test
	public void subCheck(){
		assertEquals(0.5, calc.sub(3.0,2.5), 0.1);
	}
	@Test
	public void multiCheck(){
		assertEquals(11.0, calc.multi(2.0,5.5), 0.1);
	}
	@Test
	public void divCheck(){
		assertEquals(2.0, calc.div(4.0,2.0),0.1);
	}
	@Test
	public void greaterCheck(){
		assertTrue(calc.greater(3.0,2.4));
		assertFalse(calc.greater(2.1,3.9));
	}
	@Test(expected = ArithmeticException.class)
	public void divWith0Check(){
		calc.div(3.0,0.0);
	}
}
