package controller;

import java.io.IOException;
import java.net.Socket;

import model.WarCardGameModel;
import model.WarCardGamePlayer;

public class WarCardGameServerWaitForConnectionsWorker extends GenericCardGameWaitForConnectionsWorker
{			
	public WarCardGameServerWaitForConnectionsWorker(final int port, final int maxConnections, WarCardGameModel model) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(port, maxConnections, model);
	}

	@Override
	protected WarCardGameServerSocketWorker createServerSocketWorker(Socket socket, GenericMVCWaitForConnectionsWorker connectionsWorker) 
	{				
		//Create worker to handle communication to client applet
		WarCardGameServerSocketWorker serverSocketWorker = new WarCardGameServerSocketWorker(socket, (WarCardGameModel) model, (WarCardGameServerWaitForConnectionsWorker) connectionsWorker);
		
		//Create new player object
		WarCardGamePlayer newPlayer = new WarCardGamePlayer(serverSocketWorker);
		
		//Add player to model
		((WarCardGameModel) model).getPlayers().add(newPlayer);
		
		return serverSocketWorker;
	}
}
