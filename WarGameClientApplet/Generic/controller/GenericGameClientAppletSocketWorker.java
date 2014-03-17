package controller;

import java.net.Socket;

public abstract class GenericGameClientAppletSocketWorker extends GenericSocketWorker
{

	public GenericGameClientAppletSocketWorker(Socket socket) 
	{
		super(socket);
	}

}
