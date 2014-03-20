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
	public void run() 
	{
		while(true)
		{
			Object object = this.recieveObject();
			if(object instanceof WarCardGameModel)
			{
				controller.updateModel((WarCardGameModel)object);
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
		/*
		 * try 
		{
			this.OOS.reset();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//synchronized((WarCardGameModel)((WarCardGameServerController)controller).model)
		//{
			//this.sendObject(((WarCardGameModel)((WarCardGameServerController)controller).model));
		//synchronized(this.controller.model)
		//{
			this.sendObject(controller.model);
		//}
		
			//}
	}
}
