package controller;

import java.io.IOException;
import java.net.Socket;

import model.WarCardGameModel;

public class WarCardGameServerSocketWorker extends GenericCardGameSocketWorker
{	
	public WarCardGameServerSocketWorker(Socket socket, final int playerNum, WarCardGameServerController controller)
	{
		super(socket, playerNum, controller);
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			Object object = null;
			
			try 
			{
				object = this.recieveObject();
			} 
			catch (Exception e) 
			{
				System.err.println("SOCKET ERROR - CLOSING CONNECTION");
				//TODO close connection and delete player
				e.printStackTrace();
			}
			
			if(object instanceof WarCardGameModel)
			{
				//Update local model with received model, NOTE updateModel does NOT call notifySubscribers!
				synchronized(this.controller.model)
				{((GenericCardGameController)controller).updateModel((WarCardGameModel)object);}
				
				//Notify all subscribers on server, including all server socket workers and server view
				controller.model.notifyModelSubscribers();
			}
			else
			{
				System.err.println("Recieved object not type WarCardGameModel!");
			}
		}
	}
	
	@Override
	public void modelChanged() 
	{
		//Transmit model to other side
		synchronized(this.controller.model)
		{
			try 
			{
				this.sendObject(controller.model);
			}
			catch (IOException e) 
			{
				System.err.println("SOCKET ERROR - CLOSING CONNECTION");
				//TODO close connection and delete player
				e.printStackTrace();
			}
		}
	}
}
