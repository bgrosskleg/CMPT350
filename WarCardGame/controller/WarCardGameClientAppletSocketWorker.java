package controller;

import java.net.Socket;

import model.WarCardGameModel;

public class WarCardGameClientAppletSocketWorker extends GenericCardGameSocketWorker
{	
	public WarCardGameClientAppletSocketWorker(Socket socket, WarCardGameClientAppletController controller)
	{
		super(socket, controller);
	}

	@Override
	public void run() 
	{
		//Wait for object on stream
		while(true)
		{
			Object object = this.recieveObject();
			if(object instanceof WarCardGameModel)
			{
				System.out.println("OLD MODEL: \n" + controller.model.toString());
				
				//Update local model with received model, NOTE updateModel does NOT call notifySubscribers!
				synchronized(this.controller.model)
				{((WarCardGameGeneralController) controller).updateModel((WarCardGameModel)object);}
				
				//Only update the client applet view, not the applet socket worker
				controller.view.modelChanged();
				
				System.out.println("NEW MODEL: \n" + controller.model.toString());
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
