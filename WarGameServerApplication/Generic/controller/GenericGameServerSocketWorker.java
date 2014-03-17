package controller;

import java.net.Socket;

public abstract class GenericGameServerSocketWorker extends GenericSocketWorker
{
	public GenericGameServerSocketWorker(Socket socket) 
	{
		super(socket);
	}
}
