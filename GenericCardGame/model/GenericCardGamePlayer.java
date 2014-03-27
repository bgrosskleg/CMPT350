 package model;

import controller.GenericCardGameSocketWorker;
/**
 * contains:
 * 
 * public methods:
 * getSocketWorker() 
 *
 * private methods:
 * GenericCardGamePlayer(socketWorker)
 */
public abstract class GenericCardGamePlayer extends GenericMVCModel
{
	private static final long serialVersionUID = 1L;
	
	protected final int playerNumber;
	protected transient GenericCardGameSocketWorker socketWorker;
	
	/**
	 * get the socketWorker and the playerNumber from the socketWorker
	 * 
	 * @param socketWorker the socketWorker to be looked at for both this playerNumber and this socketWorker
	 */
	protected GenericCardGamePlayer(GenericCardGameSocketWorker socketWorker)
	{
		super();
		this.playerNumber = socketWorker.getConnectionNumber();
		this.socketWorker = socketWorker;
	}

	/**
	 * get the socketWorker
	 * 
	 * @return the socketWorker
	 */
	public GenericCardGameSocketWorker getSocketWorker() 
	{
		return socketWorker;
	}
}