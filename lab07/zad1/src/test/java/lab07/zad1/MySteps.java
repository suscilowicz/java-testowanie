package lab07.zad1;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;

import lab07.zad1.MyStack;

public class MySteps extends Steps{
	
	MyStack stack = new MyStack();
	@Given("a new stack")
	public void givenANewStack (){
		stack.setStack(new ArrayList <Integer>());
	}
	
	@When("push x by $value")
	public void whenPushXByValue(@Named("value") int value){
		stack.myPush(value);
	}
	
	@When("pop from stack")
	public void whenPopFromStack(){
		stack.myPop();
	}
	
	@Then("length is $value")
	public void thenLengthIsValue(@Named("value") int value){
		assertEquals(stack.getStack().size(),value);
	}
	
	@Then("top is $value")
	public void thenTopIsValue(@Named("value") int value){
		assertEquals(stack.myTop(),value);
	}
	
	@Then ("stack is null")
	public void thenStackIsNull(){
		assertEquals(stack.isNull(), true);
	}
	
	@Then ("stack is not null")
	public void thenStackIsNotNull(){
		assertEquals(stack.isNull(), false);
	}
	@Then ("top throws exception")
	public void thenTopTrowsException(){
		try {
			stack.myTop();
			fail("Stack is not null");
		}
		catch (ArrayIndexOutOfBoundsException e){
			assertTrue(true);
		}
	}
	@Then ("pop throws exception")
	public void thenPopTrowsException(){
		try {
			stack.myPop();
			fail("Stack is not null");
		}
		catch (ArrayIndexOutOfBoundsException e){
			assertTrue(true);
		}
	}
}
