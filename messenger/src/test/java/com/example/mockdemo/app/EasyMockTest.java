package com.example.mockdemo.app;

import static org.junit.Assert.*;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class EasyMockTest {
	private Messenger messenger;
	private MessageService service;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String NULL_SERVER = null;

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	private final String NULL_MESSAGE = null;

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
	public void testPolaczeniaPoprawny() {
		expect(service.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS).anyTimes();
		replay(service);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
		verify(service);
	}
	
	@Test
	public void testPolaczeniaNiePoprawny() {
		expect(service.checkConnection(INVALID_SERVER)).andReturn(ConnectionStatus.FAILURE).anyTimes();
		replay(service);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
		verify(service);
	}
	
	@Test
	public void testPolaczeniaNull() {
		expect(service.checkConnection(NULL_SERVER)).andReturn(ConnectionStatus.FAILURE).anyTimes();
		replay(service);
		assertEquals(1, messenger.testConnection(NULL_SERVER));
		verify(service);
	}
	
	@Test
	public void testWyslanieWiadomosciPoprawne() throws MalformedRecipientException {
		expect(service.send("VALID_SERVER", "VALID_MESSAGE")).andReturn(SendingStatus.SENT);
		replay(service);
		assertEquals(0, messenger.sendMessage("VALID_SERVER", "VALID_MESSAGE"));
		verify(service);
	}
	
	@Test
	public void testWyslanieWiadomosciNiePoprawne() throws MalformedRecipientException {
		expect(service.send("VALID_SERVER", "INVALID_MESSAGE")).andThrow(new MalformedRecipientException());
		replay(service);
		assertEquals(2, messenger.sendMessage("VALID_SERVER", "INVALID_MESSAGE"));
		verify(service);
	}
	
	@Test
	public void testWyslanieWiadomosciNiePoprawne2() throws MalformedRecipientException {
		expect(service.send("INVALID_SERVER", "VALID_MESSAGE")).andReturn(SendingStatus.SENDING_ERROR);
		replay(service);
		assertEquals(1, messenger.sendMessage("INVALID_SERVER", "VALID_MESSAGE"));
		verify(service);
	}
	
	@Test
	public void testWyslanieWiadomosciNiePoprawne3() throws MalformedRecipientException {
		expect(service.send("INVALID_SERVER", "INVALID_MESSAGE")).andReturn(SendingStatus.SENDING_ERROR);
		replay(service);
		assertEquals(1, messenger.sendMessage("INVALID_SERVER", "INVALID_MESSAGE"));
		verify(service);
	}
	
	@Test
	public void testWyslanieWiadomosciNiePoprawne4() throws MalformedRecipientException {
		expect(service.send("NULL_SERVER", "INVALID_MESSAGE")).andThrow(new MalformedRecipientException());
		replay(service);
		assertEquals(2, messenger.sendMessage("NULL_SERVER", "INVALID_MESSAGE"));
		verify(service);
	}
	
	@Test
	public void testWyslanieWiadomosciNiePoprawne5() throws MalformedRecipientException {
		expect(service.send("VALID_SERVER", "NULL_MESSAGE")).andThrow(new MalformedRecipientException());
		replay(service);
		assertEquals(2, messenger.sendMessage("VALID_SERVER", "NULL_MESSAGE"));
		verify(service);
	}
	
	@Test
	public void testWyslanieWiadomosciNiePoprawne6() throws MalformedRecipientException {
		expect(service.send("NULL_SERVER", "NULL_MESSAGE")).andThrow(new MalformedRecipientException());
		replay(service);
		assertEquals(2, messenger.sendMessage("NULL_SERVER", "NULL_MESSAGE"));
		verify(service);
	}

}
