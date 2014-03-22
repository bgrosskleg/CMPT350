package controller;

import java.net.Socket;

public abstract class GenericCardGameSocketWorker extends GenericMVCSocketWorker
{
	
	public final int playerNum;
	
	protected GenericCardGameSocketWorker(Socket socket, final int playerNum, GenericCardGameController controller)
	{
		super(socket, controller);
		this.playerNum = playerNum;
	}
}
