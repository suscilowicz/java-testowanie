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
	private final String INVALID_SERVER2 = "http://inf.ug.edu.pl";
	private final String INVALID_SERVER3 = "https://inf.ug.edu.pl";
	private final String NULL_SERVER = null;
	private final String LEN_3_SERVER = ".pl";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	private final String NULL_MESSAGE = null;

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
	public void testPolaczeniaGdyJestPolaczenieINazwaHttp(){
		msm.setConnected(true);
		assertEquals(1, messenger.testConnection(INVALID_SERVER2));
	}
	
	@Test 
	public void testPolaczeniaGdyNieMaPolaczeniaINazwaHttp(){
		msm.setConnected(false);
		assertEquals(1, messenger.testConnection(INVALID_SERVER2));
	}
	@Test 
	public void testPolaczeniaGdyJestPolaczenieINazwaHttps(){
		msm.setConnected(true);
		assertEquals(1, messenger.testConnection(INVALID_SERVER3));
	}
	
	@Test 
	public void testPolaczeniaGdyNieMaPolaczeniaINazwaHttps(){
		msm.setConnected(false);
		assertEquals(1, messenger.testConnection(INVALID_SERVER3));
	}
	
	@Test
	public void testWyslanieWiadomosciPoprawne(){
		msm.setSent(true);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void testWyslanieWiadomosciNiepoprawne(){
		msm.setSent(false);
		assertEquals(1, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void testWyslanieWiadomosciNaZlySerwer(){
		msm.setSent(false);
		assertEquals(1, messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void testWyslanieWiadomosciNaZlySerwer2(){
		msm.setSent(false);
		assertEquals(1, messenger.sendMessage(INVALID_SERVER2, VALID_MESSAGE));
	}
	
	@Test
	public void testWyslanieWiadomosciNaZlySerwer3(){
		msm.setSent(false);
		assertEquals(1, messenger.sendMessage(INVALID_SERVER3, VALID_MESSAGE));
	}
	
	@Test
	public void testWyslanieWiadomosciNaSerwerGdzieDlugoscNazwyMniejszaOd3(){
		msm.setSent(false);
		assertEquals(2, messenger.sendMessage(LEN_3_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void testWyslanieNiepoprawnejWiadomosci(){
		msm.setSent(false);
		assertEquals(2, messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void testWyslanieWiadomosciNull(){
		msm.setSent(false);
		assertEquals(2, messenger.sendMessage(INVALID_SERVER, NULL_MESSAGE));
	}
	
	@Test
	public void testWyslanieWiadomosciNull2(){
		msm.setSent(false);
		assertEquals(2, messenger.sendMessage(VALID_SERVER, NULL_MESSAGE));
	}
	
	@Test
	public void testWyslanieWiadomosciNaSerwerNull(){
		msm.setSent(false);
		assertEquals(2, messenger.sendMessage(NULL_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void testWyslanieWiadomosciNaSerwerNull2(){
		msm.setSent(false);
		assertEquals(2, messenger.sendMessage(NULL_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void testWyslanieNullWiadomosciNaSerwerNull(){
		msm.setSent(false);
		assertEquals(2, messenger.sendMessage(NULL_SERVER, NULL_MESSAGE));
	}
	
	
	@After
	public void tearDown() throws Exception{
		msm = null;
		messenger = null;
	}
}
