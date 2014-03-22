package controller;

import java.io.IOException;
import java.net.Socket;

import view.WarCardGameClientAppletView;
import model.WarCardGameModel;

public class WarCardGameClientAppletSocketWorker extends GenericCardGameSocketWorker
{	
	public WarCardGameClientAppletSocketWorker(Socket socket, WarCardGameClientAppletController controller)
	{
		super(socket, 0, controller);
	}

	@Override
	public void run() 
	{
		//Wait for object on stream
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
				System.out.println("OLD MODEL: \n" + controller.model.toString());
				
				//Update local model with received model, NOTE updateModel does NOT call notifySubscribers!
				synchronized(this.controller.model)
				{((WarCardGameGeneralController) controller).updateModel((WarCardGameModel)object);}
				
				//Only update the client applet view, not the applet socket worker
				controller.view.modelChanged();
				
				System.out.println("NEW MODEL: \n" + controller.model.toString());
			}
			else if(object instanceof Integer)
			{
				((WarCardGameClientAppletController)controller).playerNumber = (Integer) object;
				
				((WarCardGameClientAppletView)((WarCardGameClientAppletController)controller).view).playerNumber =  (Integer) object;
		
				System.out.println("I AM PLAYER " + ((WarCardGameClientAppletController)controller).playerNumber);
			}
			else
			{
				System.err.println("Recieved object not type WarCardGameModel or Integer!");
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
