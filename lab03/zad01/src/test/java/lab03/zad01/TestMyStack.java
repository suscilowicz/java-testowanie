package lab03.zad01;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMyStack {
	private MyStack mystack;

	@Before
	public void setUp() throws Exception {
		mystack = new MyStack();
	}

	@After
	public void tearDown() throws Exception {
		mystack = null;
	}

	@Test
	public void isNullAtStart() {
		mystack.setStack(new ArrayList <Integer>());
		boolean result = mystack.isNull();
		assertEquals(result, true);
	}
	
	@Test
	public void testTopWhenStackIsNull(){
		try {
			mystack.setStack(new ArrayList <Integer>());
			mystack.myPop();
			fail("Stack is null");
		}
		catch (ArrayIndexOutOfBoundsException e){
			assertTrue(true);
		}
	}
	
	

}
