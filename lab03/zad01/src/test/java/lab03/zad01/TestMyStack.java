package lab03.zad01;

import static org.junit.Assert.*;

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
	public void test() {
		fail("Not yet implemented");
	}

}
