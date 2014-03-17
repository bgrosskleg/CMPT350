package controller;

import java.net.Socket;

public abstract class GenericCardGameSocketWorker extends GenericMVCSocketWorker
{
	protected GenericCardGameSocketWorker(Socket socket, GenericCardGameController controller)
	{
		super(socket, controller);
	}
}
