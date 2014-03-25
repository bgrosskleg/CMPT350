package controller;

import java.net.Socket;

import model.GenericCardGameModel;

public abstract class GenericCardGameSocketWorker extends GenericMVCSocketWorker
{	
	protected GenericCardGameSocketWorker(Socket socket, GenericCardGameModel model, final int connectionNumber)
	{
		super(socket, model, connectionNumber);
	}
}
