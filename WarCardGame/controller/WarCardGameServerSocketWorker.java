package controller;

import java.net.Socket;

import model.WarCardGameModel;

public class WarCardGameServerSocketWorker extends GenericCardGameSocketWorker
{	
	public WarCardGameServerSocketWorker(Socket socket, WarCardGameServerController controller)
	{
		super(socket, controller);
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			Object object = this.recieveObject();
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
		{this.sendObject(controller.model);}
	}
}
