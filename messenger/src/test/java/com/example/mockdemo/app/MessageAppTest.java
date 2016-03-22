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

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Before
	public void setUp() throws Exception{
		msm = new MessageServiceMock();
		messenger = new Messenger(msm);
	}
	
	@Test 
	public void test(){
		msm.setConnected(true);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
	}
	
	@After
	public void tearDown() throws Exception{
		msm = null;
		messenger = null;
	}
}
