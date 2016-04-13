package sample.projekt3;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.*;
import static org.hamcrest.Matchers.*;

import sample.projekt3.Haszowanie;

public class MySteps extends Steps {
	Haszowanie hash;
	private int a;
	
	@Given("a new hash table")
	public void givenANewHashTable(){
		hash = new Haszowanie(13);
	}
	
	@When("add x by $value")
	public void whenAddXByValue(@Named("value") int value){
		hash.dodajHasz(value);
		a = value;
	}
	
	@Then("hash value is $value")
	public void thenHashValueIsValue(@Named("value") int value){
		assertThat(hash.znajdzHasz(a), is(equalTo(value)));
	}
	
	@Then("add the same value throw exception")
	public void whenAddTheSameValueThrowException(){
		try {
			hash.dodajHasz(a);
			fail("it isnt the same int");
		}
		catch (IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@Given("incorrect modulo $value for table")
	public void givenAddIncorrectModuloForTable(@Named("value") int value){
		try {
			hash = new Haszowanie(value);
			fail("it isnt the same int");
		}
		catch (IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@Given("full hash table")
	public void givenAddFullHashTable(){
		hash = new Haszowanie(13);
		hash.tabHaszujaca = new Integer[1];
		hash.tabHaszujaca[0]=0;
		
		
	}
	@Then("add new value throw exception")
	public void thenAddNewValueThrowException(){
		try {
			hash.dodajHasz(14);
			fail("table isnt full");
		}
		catch (ArrayIndexOutOfBoundsException e){
			assertTrue(true);
		}
	}
	
	@Then("delete x by $value")
	public void thenDeleteXByValue(@Named("value") int value){
		hash.usunHash(value);
	}
	
	@Then("throw exception delete x by $value")
	public void addNewValueThrowException(@Named("value") int value){
		try {
			hash.usunHash(value);
			fail("table isnt full");
		}
		catch (ArrayIndexOutOfBoundsException e){
			assertTrue(true);
		}
	}
	
	@When("add wrong x throw exception")
	public void addWrongXThrowException(){
		try {
			hash.dodajHasz(-1);
			fail(":(");
		}
		catch (IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@When("add null x throw exception")
	public void addNullXThrowException(){
		Integer x = null;
		try {
			hash.dodajHasz(x);
			fail(":(");
		}
		catch (NullPointerException e){
			assertTrue(true);
		}
	}
}
