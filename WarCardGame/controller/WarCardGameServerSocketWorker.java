package controller;

import java.net.Socket;

public class WarCardGameServerSocketWorker extends GenericCardGameSocketWorker
{	
	public WarCardGameServerSocketWorker(Socket socket, WarCardGameServerController controller)
	{
		super(socket, controller);
	}

	@Override
	public void run() 
	{
		
	}
}
