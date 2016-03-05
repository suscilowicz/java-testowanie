package lab03.zad01;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

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
			mystack.myTop();
			fail("Stack is not null");
		}
		catch (ArrayIndexOutOfBoundsException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testPop() {
		mystack.setStack(new ArrayList <Integer>(){{add(1);add(2);add(3);}});
		mystack.myPop();
		List <Integer> result = mystack.getStack();
		assertThat(result, contains(1,2));
	}
	
	@Test
	public void testPopWhenStackIsNull(){
		try {
			mystack.setStack(new ArrayList <Integer>());
			mystack.myPop();
			fail("Stack is not null");
		}
		catch (ArrayIndexOutOfBoundsException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testPopWithOneInteger() {
		mystack.setStack(new ArrayList <Integer>(){{add(1);}});
		mystack.myPop();
		boolean result = mystack.isNull();
		assertEquals(result, true);
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
	public void testPushMinAndMaxInteger() {
		mystack.setStack(new ArrayList <Integer>());
		mystack.myPush(-2147483648);
		mystack.myPush(2147483647);
		List <Integer> result = mystack.getStack();
		assertThat(result, contains(-2147483648,2147483647));
	}
	
	@Test
	public void testTop() {
		mystack.setStack(new ArrayList <Integer>());
		mystack.myPush(1);
		mystack.myPush(2);
		int result = mystack.myTop();
		assertEquals(result, 2);
		result = mystack.myTop();
		assertEquals(result, 2);
		result = mystack.myTop();
		assertEquals(result, 2);
	}
	

}
