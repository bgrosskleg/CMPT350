 package model;

import controller.GenericCardGameSocketWorker;

public abstract class GenericCardGamePlayer extends GenericMVCModel
{
	private static final long serialVersionUID = 1L;
	
	protected transient GenericCardGameSocketWorker socketWorker;

	protected GenericCardGamePlayer(GenericCardGameSocketWorker socketWorker)
	{
		super();
		
		this.socketWorker = socketWorker;

		//this.hand = new GenericCardGameCardList(); 
	}

	public GenericCardGameSocketWorker getSocketWorker() 
	{
		return socketWorker;
	}
}