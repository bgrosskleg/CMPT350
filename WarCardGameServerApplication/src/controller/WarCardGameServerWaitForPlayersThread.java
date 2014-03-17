package controller;

import java.io.IOException;
import java.net.Socket;

import model.WarCardGameModel;
import model.WarPlayer;

public class WarCardGameServerWaitForPlayersThread extends GenericCardGameServerWaitForPlayersThread
{		
	public WarCardGameServerWaitForPlayersThread(int port, WarCardGameServerController controller) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(port, controller, "WarGameWaitForPlayersThread");
	}

	@Override
	protected WarCardGameServerSocketWorker createServerSocketWorker(Socket socket) 
	{		
		((WarCardGameModel)((WarCardGameServerController) controller).model).getPlayers().add(new WarPlayer("test"));
		((WarCardGameModel)((WarCardGameServerController) controller).model).notifyModelSubscribers();
		return new WarCardGameServerSocketWorker(socket, (WarCardGameServerController) controller);
	}
}
