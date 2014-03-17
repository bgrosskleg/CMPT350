package controller;

import java.io.IOException;

public abstract class GenericCardGameWaitForConnectionsThread extends GenericMVCWaitForConnectionsThread
{	
	protected GenericCardGameWaitForConnectionsThread(int port, GenericCardGameController controller, String threadName) throws IOException
	{	
		super(port, controller, threadName);
	}
}
