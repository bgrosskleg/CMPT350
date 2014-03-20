package controller;

import java.io.IOException;
import java.net.Socket;

import model.WarCardGameModel;
import model.WarCardGamePlayer;

public class WarCardGameServerWaitForConnectionsWorker extends GenericCardGameWaitForConnectionsWorker
{			
	public WarCardGameServerWaitForConnectionsWorker(int port, WarCardGameServerController controller) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(port, controller);
	}

	@Override
	protected WarCardGameServerSocketWorker createSocketWorker(Socket socket) 
	{		
		if(((WarCardGameModel)((WarCardGameServerController) controller).model).getPlayers().size() < ((WarCardGameServerController)this.controller).getRequiredNumberOfPlayers()
				&& this.acceptingConnections)
		{
			WarCardGameServerSocketWorker socketWorker = new WarCardGameServerSocketWorker(socket, (WarCardGameServerController)this.controller);
		
			((WarCardGameModel)((WarCardGameServerController) controller).model).getPlayers().add(new WarCardGamePlayer(socketWorker));
		
			if(((WarCardGameModel)((WarCardGameServerController) controller).model).getPlayers().size() == ((WarCardGameServerController)this.controller).getRequiredNumberOfPlayers())
			{
				this.acceptingConnections = false;
			}
				
			return socketWorker;
		}
		
		return null;
	}
}
