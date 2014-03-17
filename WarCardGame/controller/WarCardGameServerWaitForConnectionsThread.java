package controller;

import java.io.IOException;
import java.net.Socket;

import model.WarCardGameModel;
import model.WarCardGamePlayer;

public class WarCardGameServerWaitForConnectionsThread extends GenericCardGameWaitForConnectionsThread
{		
	public WarCardGameServerWaitForConnectionsThread(int port, WarCardGameServerController controller) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(port, controller, "WarGameWaitForPlayersThread");
	}

	@Override
	protected WarCardGameServerSocketWorker createSocketWorker(Socket socket) 
	{		
		WarCardGameServerSocketWorker socketWorker = new WarCardGameServerSocketWorker(socket, (WarCardGameServerController)this.controller);
		
		((WarCardGameModel)((WarCardGameServerController) controller).model).getPlayers().add(new WarCardGamePlayer(socketWorker));
		
		((WarCardGameModel)((WarCardGameServerController) controller).model).notifyModelSubscribers();
		
		return socketWorker;
	}
}
