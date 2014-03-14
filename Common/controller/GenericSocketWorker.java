package controller;

import java.net.Socket;

public abstract class GenericSocketWorker implements Runnable
{
	//http://www.oracle.com/technetwork/java/socket-140484.html
	
	Socket socket;
	
	public GenericSocketWorker(Socket socket)
	{
		this.socket = socket;
	}
}
