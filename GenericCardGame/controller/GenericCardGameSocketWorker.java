package controller;

import java.net.Socket;

import model.GenericCardGameModel;

public abstract class GenericCardGameSocketWorker extends GenericMVCSocketWorker
{	
	protected GenericCardGameSocketWorker(Socket socket, GenericCardGameModel model, GenericCardGameWaitForConnectionsWorker connectionsWorker)
	{
		super(socket, model, connectionsWorker);
	}
}
