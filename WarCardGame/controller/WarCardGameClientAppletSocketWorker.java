package controller;

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
		//TODO Handle client-server communication
		//Wait for object on stream
		controller.updateModel((WarCardGameModel)this.recieveObject());
	}

	@Override
	public void modelChanged() 
	{
		// TODO Auto-generated method stub
		
	}
}
