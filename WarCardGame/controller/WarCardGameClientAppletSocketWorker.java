package controller;

import java.net.Socket;

public class WarCardGameClientAppletSocketWorker extends GenericCardGameSocketWorker
{	
	private static final long serialVersionUID = 1L;

	public WarCardGameClientAppletSocketWorker(Socket socket, WarCardGameClientAppletController controller)
	{
		super(socket, controller);
	}

	@Override
	public void run() 
	{
		//TODO Handle client-server communication
	}

	@Override
	public void modelChanged() 
	{
		// TODO Auto-generated method stub
		
	}
}
