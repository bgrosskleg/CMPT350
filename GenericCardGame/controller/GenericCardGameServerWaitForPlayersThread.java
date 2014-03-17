package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class GenericCardGameServerWaitForPlayersThread extends Thread
{
	protected final int port;
	protected ServerSocket serverSocket;
	protected GenericCardGameServerController controller;
	
	protected GenericCardGameServerWaitForPlayersThread(int port, GenericCardGameServerController controller, String threadName) throws IOException
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
			GenericCardGameServerSocketWorker worker;
		    try
		    {
		    	//server.accept returns a client connection
		    	Socket player = serverSocket.accept();
		    	worker = createServerSocketWorker(player);
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
	
	protected abstract GenericCardGameServerSocketWorker createServerSocketWorker(Socket socket);
}
