package controller;

import java.net.Socket;

public class WarCardGameClientAppletSocketWorker extends GenericCardGameSocketWorker
{	
	public WarCardGameClientAppletSocketWorker(Socket socket, WarCardGameClientAppletController controller)
	{
		super(socket, controller);
	}

	@Override
	public void run() 
	{
		//TODO
	}
}
