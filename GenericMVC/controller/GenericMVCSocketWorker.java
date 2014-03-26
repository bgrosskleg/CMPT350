package controller;

import interfaces.GenericMVCModelSubscriber;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.GenericMVCModel;

public abstract class GenericMVCSocketWorker implements Runnable, GenericMVCModelSubscriber
{
	//http://www.oracle.com/technetwork/java/socket-140484.html

	protected GenericMVCModel model;
	protected Socket socket;
	protected int connectionNumber;
	protected GenericMVCWaitForConnectionsWorker connectionsWorker;
	protected ObjectInputStream OIS;
	protected ObjectOutputStream OOS;

	protected GenericMVCSocketWorker(Socket socket, GenericMVCModel model, GenericMVCWaitForConnectionsWorker connectionsWorker)
	{
		this.socket = socket;
		this.model = model;
		this.model.addModelSubscriber(this);
		if(connectionsWorker != null)
		{
			this.connectionNumber = ++connectionsWorker.currentConnections;
		
			this.connectionsWorker = connectionsWorker;
		}
		else
		{
			this.connectionNumber = -1;
		}
		
		try
		{		
			//CREATE OBJECTOUTPUTSTREAM FIRST, http://frequal.com/java/OpenObjectOutputStreamFirst.html
			OOS = new ObjectOutputStream(socket.getOutputStream());
			OIS = new ObjectInputStream(socket.getInputStream());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}

	protected void sendObject(Object object) throws IOException
	{ 
		System.out.println("GenericMVCSocketWorker: SendObject");
		
		OOS.reset();
		OOS.writeObject(object);
		OOS.flush();
	}

	protected Object recieveObject() throws ClassNotFoundException, IOException
	{
		Object object = OIS.readObject();
		System.out.println("GenericMVCSocketWorker: RecieveObject");
		
		return object;
	}
	
	public int getConnectionNumber()
	{
		return connectionNumber;
	}
	
	protected abstract void updateModel(GenericMVCModel newModel);
}
