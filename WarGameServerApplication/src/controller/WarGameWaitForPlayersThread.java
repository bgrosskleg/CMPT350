package controller;

import java.io.IOException;
import java.net.Socket;

public class WarGameWaitForPlayersThread extends GenericWaitForPlayersThread
{		
	public WarGameWaitForPlayersThread(int port, GenericController controller) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(port, controller, "WarGameWaitForPlayersThread");
	}

	@Override
	protected GenericSocketWorker createClientWorker(Socket player) 
	{
		return new WarGameClientWorker(player);
	}
}
