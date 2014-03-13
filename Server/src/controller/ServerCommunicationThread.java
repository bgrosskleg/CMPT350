package controller;

import java.io.IOException;

public class ServerCommunicationThread extends GenericCommunicationThread
{
	private static final long serialVersionUID = 1L;

	public ServerCommunicationThread()
	{
		super("ServerCommunicationThread");
	}

	@Override
	protected void initializeConnection() throws IOException 
	{
		// TODO Auto-generated method stub
		
	}
}
