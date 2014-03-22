package controller;

import java.io.IOException;

public abstract class GenericCardGameWaitForConnectionsWorker extends GenericMVCWaitForConnectionsWorker
{	
	protected GenericCardGameWaitForConnectionsWorker(final int port, final int maxConnections, GenericCardGameController controller) throws IOException
	{	
		super(port, maxConnections, controller);
	}
}
