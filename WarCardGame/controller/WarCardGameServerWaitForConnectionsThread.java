package controller;

import java.io.IOException;
import java.net.Socket;

public class WarCardGameServerWaitForConnectionsThread extends GenericCardGameWaitForConnectionsThread
{		
	public WarCardGameServerWaitForConnectionsThread(int port, WarCardGameServerController controller) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(port, controller, "WarGameWaitForPlayersThread");
	}

	@Override
	protected WarCardGameClientAppletSocketWorker createSocketWorker(Socket socket) 
	{
		return null;		
		
	}
}
