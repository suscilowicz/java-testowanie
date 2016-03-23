package com.example.mockdemo.messenger;

public class MessageServiceMock implements MessageService {
	
	private boolean sent = false;
	private boolean connected = false;
	
	public void setSent(boolean bool) {
		sent = bool;
	}
	
	public void setConnected(boolean bool) {
		connected = bool;
	}
	

	@Override
	public ConnectionStatus checkConnection(String server) {
		if (server == null || server.contains("http://") || server.contains("https://") ) 
			return ConnectionStatus.FAILURE;
		else if (server.endsWith(".pl") && connected) 
			return ConnectionStatus.SUCCESS;
		else return ConnectionStatus.FAILURE;
	}

	@Override
	public SendingStatus send(String server, String message) throws MalformedRecipientException {
		if (server == null || message == null)
			throw new MalformedRecipientException();
		else if (server.length() < 4 || message.length() < 3)
			throw new MalformedRecipientException();
		else if (sent)
			return SendingStatus.SENT;
		else return SendingStatus.SENDING_ERROR;
	}

}
