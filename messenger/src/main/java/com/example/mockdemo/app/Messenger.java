package com.example.mockdemo.app;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class Messenger {

	private MessageService ms;

	public Messenger(MessageService ms) {
		this.ms = ms;
	}

	/*Tymczasowo -> Pozniej to zniknie */
	public Messenger() {
		// TODO Auto-generated constructor stub
	}

	public int testConnection(String server) {
		if(ms.checkConnection(server) == ConnectionStatus.SUCCESS)
			return 0;
		return 1;
	}

	public int sendMessage(String server, String message) {
		int result = -1;
		try {
			SendingStatus status = ms.send(server, message);
			
			if (status == SendingStatus.SENT) 
				result = 0;
			else if (status == SendingStatus.SENDING_ERROR) 
				result = 1;
		}
		catch(MalformedRecipientException ex) {
			result = 2;
		}
		return result;
	}
}
