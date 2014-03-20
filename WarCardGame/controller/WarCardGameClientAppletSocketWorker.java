package controller;

import java.io.IOException;
import java.net.Socket;

import model.WarCardGameModel;

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
		//Wait for object on stream
		while(true)
		{
			Object object = this.recieveObject();
			if(object instanceof WarCardGameModel)
			{
				System.out.println("Old number of players: " + ((WarCardGameModel)((WarCardGameClientAppletController)controller).model).getPlayers().size());
				controller.updateModel((WarCardGameModel)object);
				System.out.println("New number of players: " + ((WarCardGameModel)((WarCardGameClientAppletController)controller).model).getPlayers().size());
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
		try 
		{
			this.OOS.reset();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sendObject(controller.model);
	}
}
