package controller;

import java.net.Socket;

public class WarCardGameServerSocketWorker extends GenericCardGameServerSocketWorker
{	
	public WarCardGameServerSocketWorker(Socket socket, WarCardGameServerController controller)
	{
		super(socket, controller);
	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		
	}
}
