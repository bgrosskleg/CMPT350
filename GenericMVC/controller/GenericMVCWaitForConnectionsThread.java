package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class GenericMVCWaitForConnectionsThread extends Thread
{
	protected final int port;
	protected ServerSocket serverSocket;
	protected GenericMVCController controller;
	
	protected GenericMVCWaitForConnectionsThread(int port, GenericMVCController controller, String threadName) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		super(threadName);
		this.controller = controller;
		
		this.port = port;
		this.serverSocket = new ServerSocket(port);
		
		if(this.serverSocket != null)
		{
			System.out.println("Server listening on port: " + port);
		}
	}
	
	public void run()
	{		
		while(true)
		{
			GenericMVCSocketWorker worker;
		    try
		    {
		    	//server.accept returns a client connection
		    	Socket socket = serverSocket.accept();
		    	worker = createSocketWorker(socket);
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
	
	protected abstract GenericMVCSocketWorker createSocketWorker(Socket socket);
}
