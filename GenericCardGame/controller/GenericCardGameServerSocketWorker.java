package controller;

import java.net.Socket;

public abstract class GenericCardGameServerSocketWorker extends GenericSocketWorker
{
	public GenericCardGameServerSocketWorker(Socket socket, GenericCardGameServerController controller) 
	{
		super(socket, controller);
	}
}
