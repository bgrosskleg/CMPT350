package controller;

import interfaces.GenericMVCModelSubscriber;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class GenericMVCSocketWorker implements Runnable, GenericMVCModelSubscriber
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
		this.controller.model.addModelSubscriber(this);

		try 
		{
			//CREATE OBJECTOUTPUTSTREAM FIRST, http://frequal.com/java/OpenObjectOutputStreamFirst.html
			OOS = new ObjectOutputStream(socket.getOutputStream());
			OIS = new ObjectInputStream(socket.getInputStream());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}

	protected void sendObject(Object object) throws IOException
	{ 
		synchronized(this.controller.model)
		{
			System.out.println("GenericMVCSocketWorker: SendObject");
			//new Exception().printStackTrace();
			OOS.reset();
			OOS.writeObject(object);
			OOS.flush();
		}
	}

	protected Object recieveObject() throws ClassNotFoundException, IOException
	{
		Object object = OIS.readObject();
		System.out.println("GenericMVCSocketWorker: RecieveObject");
		//new Exception().printStackTrace();
		return object;
	}
}
