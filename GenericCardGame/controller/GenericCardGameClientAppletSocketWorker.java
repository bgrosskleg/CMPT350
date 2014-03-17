package controller;

import java.net.Socket;

public abstract class GenericCardGameClientAppletSocketWorker extends GenericSocketWorker
{

	public GenericCardGameClientAppletSocketWorker(Socket socket, GenericCardGameClientAppletController controller) 
	{
		super(socket, controller);
	}

}
