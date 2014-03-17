package controller;

import java.io.IOException;
import java.net.Socket;

public class WarCardGameServerWaitForPlayersThread extends GenericCardGameServerWaitForPlayersThread
{		
	public WarCardGameServerWaitForPlayersThread(int port, WarCardGameServerController controller) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(port, controller, "WarGameWaitForPlayersThread");
	}

	@Override
	protected GenericCardGameServerSocketWorker createServerSocketWorker(Socket socket) 
	{
		return new WarCardGameServerSocketWorker(socket, (WarCardGameServerController) controller);
	}
}
