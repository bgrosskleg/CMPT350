package controller;

import java.net.Socket;

public abstract class GenericGameClientWorker extends GenericSocketWorker
{
	public GenericGameClientWorker(Socket socket) 
	{
		super(socket);
	}
}
