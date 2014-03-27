package controller;

import java.io.IOException;
import java.net.Socket;

import model.WarCardGameModel;
import model.WarCardGamePlayer;

/**
 * 	contains:
 * 
 *  public methods:
 *	WarCardGameServerWaitForConnectionsWorker(final int, final int, WarCardGameModel)
 *
 *	protected methods:
 *	createServerSocketWorker(Socket, GenericMVCWaitForConnectionsWorker)
 */
public class WarCardGameServerWaitForConnectionsWorker extends GenericCardGameWaitForConnectionsWorker
{		
	/**
	 * the server port that sits there and waits for connections so it can update all of the subscribers
	 * 
	 * @param port the port to wait at
	 * @param maxConnections the maximum number of players that can connect to the server
	 * @param model the current model everyone can see
	 * @throws IOException
	 */
	public WarCardGameServerWaitForConnectionsWorker(final int port, final int maxConnections, WarCardGameModel model) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(port, maxConnections, model);
	}

	/**
	 * creates a player and then assigns a socketWorker and a model to that player
	 * 
	 * @param socket the socket the serverSocketWorker uses to communicate with the player
	 * @param connectionWorker the worker assigned to serving this player
	 * @return serverSocketWorker the socket assigned to this player
	 */
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
