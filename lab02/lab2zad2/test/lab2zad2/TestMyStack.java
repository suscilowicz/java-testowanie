package lab2zad2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestMyStack {
	
private MyStack mystack;
	
	@Before
	public void setup(){
		mystack = new MyStack();
	}

	@Test
	public void testPush() {
		mystack.setStack(new ArrayList <Integer>());
		mystack.myPush(1);
		mystack.myPush(2);
		mystack.myPush(3);
		mystack.myPush(4);
		List <Integer> result = mystack.getStack();
		assertThat(result, contains(1,2,3,4));
	}
	
	@Test
	public void testPop() {
		mystack.setStack(new ArrayList <Integer>(){{add(1);add(2);add(3);}});
		mystack.myPop();
		List <Integer> result = mystack.getStack();
		assertThat(result, contains(1,2));
	}
	
	@Test
	public void testMyTop(){
		mystack.setStack(new ArrayList <Integer>(){{add(1);add(2);add(3);}});
		int result = mystack.myTop();
		assertEquals(result, 3);
	}
	
	@Test
	public void isNull(){
		mystack.setStack(new ArrayList <Integer>());
		boolean result = mystack.isNull();
		assertEquals(result, false);
	}
	
	@Test
	public void isNotNull(){
		mystack.setStack(new ArrayList <Integer>(){{add(1);add(2);add(3);}});
		boolean result = mystack.isNull();
		assertEquals(result, false);
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
	
	@After
	public void teardown(){
		mystack = null;
	}

}
