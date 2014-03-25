 package model;

import controller.GenericCardGameSocketWorker;

public abstract class GenericCardGamePlayer extends GenericMVCModel
{
	private static final long serialVersionUID = 1L;
	
	protected final int playerNumber;
	protected transient GenericCardGameSocketWorker socketWorker;

	protected GenericCardGamePlayer(GenericCardGameSocketWorker socketWorker)
	{
		super();
		this.playerNumber = socketWorker.getConnectionNumber();
		this.socketWorker = socketWorker;
	}

	public GenericCardGameSocketWorker getSocketWorker() 
	{
		return socketWorker;
	}
}