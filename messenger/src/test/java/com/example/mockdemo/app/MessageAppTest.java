package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import com.example.mockdemo.messenger.MessageServiceMock;

public class MessageAppTest {
	MessageServiceMock msm;
	Messenger messenger;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String NULL_SERVER = null;
	private final String LEN_3_SERVER = ".pl";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Before
	public void setUp() throws Exception{
		msm = new MessageServiceMock();
		messenger = new Messenger(msm);
	}
	
	@Test 
	public void testPolaczeniaPoprawny(){
		msm.setConnected(true);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
	}
	
	@Test 
	public void testPolaczeniaGdyNieMaPolaczenia(){
		msm.setConnected(false);
		assertEquals(1, messenger.testConnection(VALID_SERVER));
	}
	
	@Test 
	public void testPolaczeniaGdyJestPolaczenieIZlaNazwa(){
		msm.setConnected(true);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
	}
	
	@Test 
	public void testPolaczeniaGdyNieMaPolaczeniaIZlaNazwa(){
		msm.setConnected(false);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
	}
	
	@Test 
	public void testPolaczeniaGdyJestPolaczenieINazwaJestNull(){
		msm.setConnected(true);
		assertEquals(1, messenger.testConnection(NULL_SERVER));
	}
	
	@Test 
	public void testPolaczeniaGdyNieMaPolaczeniaINazwaJestNull(){
		msm.setConnected(false);
		assertEquals(1, messenger.testConnection(NULL_SERVER));
	}
	
	@Test 
	public void testPolaczeniaGdyJestPolaczenieINazwaJestMniejszaOd3(){
		msm.setConnected(false);
		assertEquals(1, messenger.testConnection(LEN_3_SERVER));
	}
	
	@Test 
	public void testPolaczeniaGdyNieMaPolaczeniaINazwaJestMniejszaOd3(){
		msm.setConnected(false);
		assertEquals(1, messenger.testConnection(LEN_3_SERVER));
	}
	
	
	
	@After
	public void tearDown() throws Exception{
		msm = null;
		messenger = null;
	}
}
