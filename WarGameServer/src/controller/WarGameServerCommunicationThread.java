package controller;

import java.io.IOException;

public class WarGameServerCommunicationThread extends GenericCommunicationThread
{
	private static final long serialVersionUID = 1L;
	
	public WarGameServerCommunicationThread()
	{
		super("ServerCommunicationThread");
	}

	@Override
	protected void initializeConnection() throws IOException 
	{
		// TODO Auto-generated method stub
		
	}
	
	private class AcceptPlayerConnectionThread extends Thread
	{
		private AcceptPlayerConnectionThread()
		{
			
		}
	}

	@Override
	protected void processNotification() 
	{
		// TODO Auto-generated method stub
		
	}
}
