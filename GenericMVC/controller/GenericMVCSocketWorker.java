package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class GenericMVCSocketWorker implements Runnable
{
	//http://www.oracle.com/technetwork/java/socket-140484.html
	
	protected Socket socket;
	protected ObjectInputStream OIS;
	protected ObjectOutputStream OOS;
	
	protected GenericMVCController controller;
	
	protected GenericMVCSocketWorker(Socket socket, GenericMVCController controller)
	{
		this.socket = socket;
		this.controller = controller;
		
		try 
		{
			OIS = new ObjectInputStream(socket.getInputStream());
			OOS = new ObjectOutputStream(socket.getOutputStream());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	protected void sendObject(Object object)
	{
		try
		{
			OOS.writeObject(object);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	protected Object recieveObject()
	{
		try 
		{
			return OIS.readObject();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		} catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
}
