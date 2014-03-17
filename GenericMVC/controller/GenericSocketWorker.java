package controller;

import java.net.Socket;

public abstract class GenericSocketWorker implements Runnable
{
	//http://www.oracle.com/technetwork/java/socket-140484.html
	
	Socket socket;
	GenericController controller;
	
	public GenericSocketWorker(Socket socket, GenericController controller)
	{
		this.socket = socket;
		this.controller = controller;
	}
}
