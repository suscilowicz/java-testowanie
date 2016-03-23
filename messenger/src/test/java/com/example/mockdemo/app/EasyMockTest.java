package com.example.mockdemo.app;

import static org.junit.Assert.*;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.messenger.MessageService;

public class EasyMockTest {
	private Messenger messenger;
	private MessageService service;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Before
	public void setUp() throws Exception {
		service = createMock(MessageService.class);
		messenger = new Messenger(service);
	}

	@After
	public void tearDown() throws Exception {
		service = null;
		messenger = null;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
