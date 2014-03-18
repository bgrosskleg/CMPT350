package controller;

import java.net.Socket;

import model.WarCardGameModel;

public class WarCardGameServerSocketWorker extends GenericCardGameSocketWorker
{	
	private static final long serialVersionUID = 1L;

	public WarCardGameServerSocketWorker(Socket socket, WarCardGameServerController controller)
	{
		super(socket, controller);
	}
	
	@Override
	public void modelChanged() 
	{
		// TODO Auto-generated method stub
		//Transmit model to other side
		this.sendObject((WarCardGameModel)controller.model);
	}

	@Override
	public void run() 
	{
		// TODO Handle communication between client-server
		
	}
}
