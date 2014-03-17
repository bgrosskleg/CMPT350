package controller;

import java.io.IOException;
import java.net.Socket;

public class WarCardGameWaitForConnectionsThread extends GenericCardGameWaitForConnectionsThread
{		
	public WarCardGameWaitForConnectionsThread(int port, WarCardGameServerController controller) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(port, controller, "WarGameWaitForPlayersThread");
	}

	@Override
	protected WarCardGameSocketWorker createSocketWorker(Socket socket) 
	{
		return null;		
		
	}
}
