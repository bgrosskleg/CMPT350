package controller;

import java.io.IOException;
import java.net.Socket;

import model.WarCardGameModel;
import model.WarCardGamePlayer;

public class WarCardGameServerWaitForConnectionsWorker extends GenericCardGameWaitForConnectionsWorker
{			
	public WarCardGameServerWaitForConnectionsWorker(final int port, final int maxConnections, WarCardGameServerController controller) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(port, maxConnections, controller);
	}

	@Override
	protected WarCardGameServerSocketWorker createSocketWorker(Socket socket) 
	{				
		//Create worker to handle communication to client applet
		WarCardGameServerSocketWorker socketWorker = new WarCardGameServerSocketWorker(socket, this.currentConnections + 1, (WarCardGameServerController)this.controller);
		
		//Create new player object
		WarCardGamePlayer newPlayer = new WarCardGamePlayer(socketWorker);
		
		//Send notify client which player they are
		try 
		{
			socketWorker.sendObject(newPlayer.getPlayerNumber());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Add player to model
		((WarCardGameModel)((WarCardGameServerController) controller).model).getPlayers().add(newPlayer);
		
		return socketWorker;
	}
}
