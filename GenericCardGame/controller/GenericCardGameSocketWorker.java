package controller;

import java.net.Socket;

import model.GenericCardGameModel;
/**
 * contains:
 * 
 * protected methods:
 * GenericCardGameSocketWorker(Socket, GenericCardGameModel, final int)
 *
 */
public abstract class GenericCardGameSocketWorker extends GenericMVCSocketWorker
{	
	protected GenericCardGameSocketWorker(Socket socket, GenericCardGameModel model, GenericCardGameWaitForConnectionsWorker connectionsWorker)
	{
		super(socket, model, connectionsWorker);
	}
}
