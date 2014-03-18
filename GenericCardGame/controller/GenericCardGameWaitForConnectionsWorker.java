package controller;

import java.io.IOException;

public abstract class GenericCardGameWaitForConnectionsWorker extends GenericMVCWaitForConnectionsWorker
{	
	protected GenericCardGameWaitForConnectionsWorker(int port, GenericCardGameController controller) throws IOException
	{	
		super(port, controller);
	}
}
