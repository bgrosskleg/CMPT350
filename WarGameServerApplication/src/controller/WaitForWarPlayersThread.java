package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WaitForWarPlayersThread extends Thread
{	
	private final int port = 65000;
	private ServerSocket serverSocket;
	
	public WaitForWarPlayersThread()
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html

		super("WaitForConnectionsThread");
		
		try 
		{
			serverSocket = new ServerSocket(port);
		} 
		catch (IOException e) 
		{
		    System.err.println("Could not listen on port " + port + "!");
		    System.exit(-1);
		}
		
		while(true)
		{
		    GenericSocketWorker worker;
		    try
		    {
		    	//server.accept returns a client connection
		    	Socket player = serverSocket.accept();
		    	worker = new WarGameClientWorker(player);
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
}
