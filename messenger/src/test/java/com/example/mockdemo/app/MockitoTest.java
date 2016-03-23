package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MockitoTest {
	
	private Messenger messenger;
	@Mock
	private MessageService service;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String NULL_SERVER = null;

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	private final String NULL_MESSAGE = null;
	
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		messenger = new Messenger(service);
	}

	@After
	public void tearDown() throws Exception {
		messenger = null;
		service = null;
	}

	@Test
	public void testPolaczeniaPoprawny() {
		when(service.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
		verify(service).checkConnection(VALID_SERVER);
	}
	
	@Test
	public void testPolaczeniaNiePoprawny() {
		when(service.checkConnection(INVALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
		verify(service).checkConnection(INVALID_SERVER);
	}
	
	@Test
	public void testPolaczeniaNull() {
		when(service.checkConnection(INVALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
		verify(service).checkConnection(INVALID_SERVER);
	}
	
	@Test
	public void testWyslanieWiadomosciPoprawne() throws MalformedRecipientException {
		when(service.send("VALID_SERVER", "VALID_MESSAGE")).thenReturn(SendingStatus.SENT);
		assertEquals(0, messenger.sendMessage("VALID_SERVER", "VALID_MESSAGE"));
		verify(service).send("VALID_SERVER", "VALID_MESSAGE");
	}
	
	@Test
	public void testWyslanieWiadomosciNiePoprawne() throws MalformedRecipientException {
		when(service.send("VALID_SERVER", "INVALID_MESSAGE")).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage("VALID_SERVER", "INVALID_MESSAGE"));
		verify(service).send("VALID_SERVER", "INVALID_MESSAGE");
	}
	
	@Test
	public void testWyslanieWiadomosciNiePoprawne2() throws MalformedRecipientException {
		when(service.send("INVALID_SERVER", "VALID_MESSAGE")).thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(1, messenger.sendMessage("INVALID_SERVER", "VALID_MESSAGE"));
		verify(service).send("INVALID_SERVER", "VALID_MESSAGE");
	}
	
	@Test
	public void testWyslanieWiadomosciNiePoprawne3() throws MalformedRecipientException {
		when(service.send("INVALID_SERVER", "INVALID_MESSAGE")).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage("INVALID_SERVER", "INVALID_MESSAGE"));
		verify(service).send("INVALID_SERVER", "INVALID_MESSAGE");
	}
	
	@Test
	public void testWyslanieWiadomosciNiePoprawne4() throws MalformedRecipientException {
		when(service.send("NULL_SERVER", "INVALID_MESSAGE")).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage("NULL_SERVER", "INVALID_MESSAGE"));
		verify(service).send("NULL_SERVER", "INVALID_MESSAGE");
	}
	
	@Test
	public void testWyslanieWiadomosciNiePoprawne5() throws MalformedRecipientException {
		when(service.send("VALID_SERVER", "NULL_MESSAGE")).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage("VALID_SERVER", "NULL_MESSAGE"));
		verify(service).send("VALID_SERVER", "NULL_MESSAGE");
	}
	
	@Test
	public void testWyslanieWiadomosciNiePoprawne6() throws MalformedRecipientException {
		when(service.send("NULL_SERVER", "NULL_MESSAGE")).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage("NULL_SERVER", "NULL_MESSAGE"));
		verify(service).send("NULL_SERVER", "NULL_MESSAGE");
	}
}
