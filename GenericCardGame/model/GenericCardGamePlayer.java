 package model;

import controller.GenericCardGameSocketWorker;

public abstract class GenericCardGamePlayer extends GenericMVCModel
{
	private static final long serialVersionUID = 1L;
	
	protected final int playerNum;
	protected transient GenericCardGameSocketWorker socketWorker;

	protected GenericCardGamePlayer(GenericCardGameSocketWorker socketWorker)
	{
		super();
		this.playerNum = socketWorker.playerNum;
		this.socketWorker = socketWorker;
	}

	public GenericCardGameSocketWorker getSocketWorker() 
	{
		return socketWorker;
	}
}