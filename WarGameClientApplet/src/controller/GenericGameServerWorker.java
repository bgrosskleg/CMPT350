package controller;

import java.net.Socket;

public abstract class GenericGameServerWorker extends GenericSocketWorker
{

	public GenericGameServerWorker(Socket socket) 
	{
		super(socket);
	}

}
