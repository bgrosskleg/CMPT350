package controller;

import java.io.IOException;
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
		try 
		{
			this.OOS.reset();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sendObject(new WarCardGameModel());
	}

	@Override
	public void run() 
	{
		// TODO Handle communication between client-server
		
	}
}
