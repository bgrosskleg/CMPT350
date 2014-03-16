package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class GenericWaitForPlayersThread extends Thread
{
	protected final int port;
	protected ServerSocket serverSocket;
	
	public GenericWaitForPlayersThread(int port, String threadName) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(threadName);
		
		this.port = port;
		this.serverSocket = new ServerSocket(port);
	}
	
	public void run()
	{		
		while(true)
		{
		    GenericSocketWorker worker;
		    try
		    {
		    	//server.accept returns a client connection
		    	Socket player = serverSocket.accept();
		    	worker = createClientWorker(player);
		    	Thread thread = new Thread(worker);
		    	thread.start();
		    } 
		    catch (IOException e) 
		    {
		      System.err.println("Accept failed: " + port);
		      System.exit(-1);
		    }
		}
	}
	
	protected abstract GenericSocketWorker createClientWorker(Socket player);
}
