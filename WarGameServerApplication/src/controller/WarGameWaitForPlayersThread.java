package controller;

import java.io.IOException;
import java.net.Socket;

public class WarGameWaitForPlayersThread extends GenericWaitForPlayersThread
{		
	public WarGameWaitForPlayersThread() throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(65000, "WarGameWaitForPlayersThread");
	}

	@Override
	protected GenericSocketWorker createClientWorker(Socket player) 
	{
		return new WarGameClientWorker(player);
	}
}
