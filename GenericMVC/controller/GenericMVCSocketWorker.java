package controller;

import interfaces.GenericMVCModelSubscriber;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.GenericMVCModel;
/**
 * contains:
 * 
 * public methods:
 * public int getConnectionNumber()
 * 
 * protected methods:
 * updateModel(GenericMVCModel)
 * recieveObject()
 * sendObject(Object)
 * GenericMVCSocketWorker(Socket, GenericMVCModel, final int)
 * 
 */
public abstract class GenericMVCSocketWorker implements Runnable, GenericMVCModelSubscriber
{
	//http://www.oracle.com/technetwork/java/socket-140484.html

	protected GenericMVCModel model;
	protected Socket socket;
	protected int connectionNumber;
	protected ObjectInputStream OIS;
	protected ObjectOutputStream OOS;

	/**
	 * creates a new ObjectOutputStream and a new ObjectInputStream for the socket
	 * 
	 * @param socket what specific socket is transmitting the data
	 * @param model the current state of the model
	 * @param model.addModelSubscriber the specific client that is receiving this model
	 * @param connectionNumber the connection number assigned to a particular connection
	 * @throws general exception, prints stack trace and exits
	 */
	protected GenericMVCSocketWorker(Socket socket, GenericMVCModel model, final int connectionNumber)
	{
		this.socket = socket;
		this.model = model;
		this.model.addModelSubscriber(this);
		this.connectionNumber = connectionNumber;
		
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

	/**
	 * sends an object to the server
	 * <p>
	 * resets the ObjectOutputStream
	 * writes a generic object which is sent through the socket
	 * flushes the ObjectOutputStream
	 * <p>
	 * @param object
	 * @throws IOException
	 */
	protected void sendObject(Object object) throws IOException
	{ 
		System.out.println("GenericMVCSocketWorker: SendObject");
		//new Exception().printStackTrace();
		OOS.reset();
		OOS.writeObject(object);
		OOS.flush();
	}

	/**
	 * receives an object from the server and gives it to the client
	 * 
	 * @return the object that came through the ObjcetInputStream
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	protected Object recieveObject() throws ClassNotFoundException, IOException
	{
		Object object = OIS.readObject();
		System.out.println("GenericMVCSocketWorker: RecieveObject");
		//new Exception().printStackTrace();
		return object;
	}
	
	/**
	 * gets the connectionNumber
	 * 
	 * @return the connectionNumber
	 */
	public int getConnectionNumber()
	{
		return connectionNumber;
	}
	
	protected abstract void updateModel(GenericMVCModel newModel);
}
