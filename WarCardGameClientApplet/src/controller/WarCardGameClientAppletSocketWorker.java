package controller;

import java.net.Socket;

public class WarCardGameClientAppletSocketWorker extends GenericCardGameClientAppletSocketWorker
{

	public WarCardGameClientAppletSocketWorker(Socket socket, WarCardGameClientAppletController controller) 
	{
		super(socket, controller);
	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		
	}

}
