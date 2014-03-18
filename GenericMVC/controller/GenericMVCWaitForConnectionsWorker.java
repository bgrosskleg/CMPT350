package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class GenericMVCWaitForConnectionsWorker implements Runnable
{
	protected final int port;
	protected ServerSocket serverSocket;
	protected GenericMVCController controller;
	protected boolean acceptingConnections;
	
	protected GenericMVCWaitForConnectionsWorker(int port, GenericMVCController controller) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		this.controller = controller;
		
		this.port = port;
		this.serverSocket = new ServerSocket(port);
		this.acceptingConnections = true;
		if(this.serverSocket != null)
		{
			System.out.println("Server listening on port: " + port);
		}
	}
	
	@Override
	public void run()
	{		
		while(acceptingConnections)
		{
			GenericMVCSocketWorker worker;
		    try
		    {
		    	//server.accept returns a client connection
		    	System.out.println("WAITING FOR CONNECTION");
		    	
		    	Socket socket = serverSocket.accept();
		    	System.out.println("CONNECTION ACCEPTED");
		    	
		    	worker = createSocketWorker(socket);
		    	System.out.println("SOCKET WORKER CREATED");
		    	
		    	(new Thread(worker)).start();
		    	System.out.println("THREAD STARTED");
		    } 
		    catch (IOException e) 
		    {
		      System.err.println("Accept failed: " + port);
		      System.exit(-1);
		    }
		}
		
		System.out.println("STOPPED ACCEPTING CONNECTIONS");
	}
	
	public void stopAcceptingConnections()
	{
		this.acceptingConnections = false;
	}
	
	public void resumeAcceptingConnections()
	{
		this.acceptingConnections = true;
		this.run();
	}
	
	protected abstract GenericMVCSocketWorker createSocketWorker(Socket socket);
}
