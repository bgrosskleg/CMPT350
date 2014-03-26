package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import model.GenericMVCModel;
/**
 * contains:
 * 
 * public methods:
 * run()
 * 
 * protected methods:
 * GenericMVCWaitForConnectionsWorker(final int, final int, GenericMVCModel)
 *
 */
public abstract class GenericMVCWaitForConnectionsWorker implements Runnable
{
	protected final int port;
	protected ServerSocket serverSocket;
	protected GenericMVCModel model;
	protected final int maxConnections;
	protected int currentConnections;
	
	/**
	 * listens at the port and waits to be connected to until the applet is closed
	 * 
	 * @param port the virtual connection point
	 * @param maxConnections controls how many people may access the applet
	 * @param model the current state of the model
	 * @throws IOException
	 */
	protected GenericMVCWaitForConnectionsWorker(final int port, final int maxConnections, GenericMVCModel model) throws IOException
	{
		//http://www.oracle.com/technetwork/java/socket-140484.html
		this.model = model;
		
		this.port = port;
		this.serverSocket = new ServerSocket(port);
		this.maxConnections = maxConnections;
		if(this.serverSocket != null)
		{
			System.out.println("Server listening on port: " + port);
		}
	}
	
	@Override
	/**
	 * starts the GenericMVCSocketWorker running
	 * <p>
	 * creates a worker, a socket, and a socketworker.
	 * starts a new thread and notifies the subscribers (users listening on ports) of the current model
	 * runs until the maximum number of allowed subscribers have connected
	 * 
	 * @throws if the port is not available, terminates the program
	 */
	public void run()
	{		
		//runs until the maximum allowed users have accessed the applet
		while(currentConnections < maxConnections)
		{
			GenericMVCSocketWorker worker;
			try
			{
				//server.accept returns a client connection
				System.out.println("WAITING FOR CONNECTION");

				Socket socket = serverSocket.accept();
				System.out.println("CONNECTION ACCEPTED");

				worker = createServerSocketWorker(socket, model);
				System.out.println("SOCKET WORKER CREATED");

				(new Thread(worker)).start();
				System.out.println("THREAD STARTED");

				model.notifyModelSubscribers();
				System.out.println("SUBSCRIBERS NOTIFIED");

				currentConnections++;
				System.out.println(currentConnections + " CONNECTIONS");
			} 
			catch (IOException e) 
			{
				System.err.println("Accept failed: " + port);
				System.exit(-1);
			}
		}

		System.out.println("STOPPED ACCEPTING CONNECTIONS");
	}
	protected abstract GenericMVCSocketWorker createServerSocketWorker(Socket socket, GenericMVCModel model);
}
