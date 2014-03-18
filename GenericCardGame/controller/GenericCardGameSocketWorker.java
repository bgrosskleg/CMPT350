package controller;

import java.net.Socket;

public abstract class GenericCardGameSocketWorker extends GenericMVCSocketWorker
{
	private static final long serialVersionUID = 1L;

	protected GenericCardGameSocketWorker(Socket socket, GenericCardGameController controller)
	{
		super(socket, controller);
	}
}
