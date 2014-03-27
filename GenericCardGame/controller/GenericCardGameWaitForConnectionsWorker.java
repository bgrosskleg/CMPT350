package controller;

import java.io.IOException;

import model.GenericCardGameModel;
/**
 * contains:
 * 
 * protected methods:
 * GenericCardGameWaitForConnectionsWorker(final int, final int, GenericCardGameModel) 
 */
public abstract class GenericCardGameWaitForConnectionsWorker extends GenericMVCWaitForConnectionsWorker
{	
	protected GenericCardGameWaitForConnectionsWorker(final int port, final int maxConnections, GenericCardGameModel model) throws IOException
	{	
		super(port, maxConnections, model);
	}
}
