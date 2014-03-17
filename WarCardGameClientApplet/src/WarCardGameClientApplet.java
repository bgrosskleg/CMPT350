import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.WarCardGameClientAppletController;
import controller.WarCardGameClientAppletSocketWorker;
import view.WarCardGameClientAppletView;
import model.WarPlayer;


public class WarCardGameClientApplet extends GenericCardGameClientApplet
{
	private static final long serialVersionUID = 1L;
	
	public WarCardGameClientApplet()
	{
		super();
	}
	
	@Override
	protected WarPlayer createModel() 
	{
		//Prompt for name
		String name = null;
		//...
		
		return new WarPlayer(name);
	}

	@Override
	protected WarCardGameClientAppletView createView() 
	{
		return new WarCardGameClientAppletView((WarPlayer)this.model);	
	}

	@Override
	protected WarCardGameClientAppletController createController() 
	{
		return new WarCardGameClientAppletController((WarPlayer)this.model, (WarCardGameClientAppletView)this.view);
	}

	@Override
	protected WarCardGameClientAppletSocketWorker createSocketWorker() 
	{
		Socket socket;
		try 
		{
			this.port = 65000;
			socket = new Socket(InetAddress.getByName(this.getCodeBase().getHost()), this.port);
		} 
		catch (UnknownHostException e)
		{
			e.printStackTrace();
			return null;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}
		
		return new WarCardGameClientAppletSocketWorker(socket, (WarCardGameClientAppletController)this.controller);
	}
}
