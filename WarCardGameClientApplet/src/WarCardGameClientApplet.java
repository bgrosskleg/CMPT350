import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.WarCardGameClientAppletController;
import controller.WarCardGameSocketWorker;
import view.WarCardGameClientAppletView;
import model.WarCardGameModel;


public class WarCardGameClientApplet extends GenericCardGameClientApplet
{
	private static final long serialVersionUID = 1L;
	
	public WarCardGameClientApplet()
	{
		super();
	}
	
	@Override
	protected WarCardGameModel createModel() 
	{
		return new WarCardGameModel();
	}

	@Override
	protected WarCardGameClientAppletView createView() 
	{
		return new WarCardGameClientAppletView((WarCardGameModel)this.model);	
	}

	@Override
	protected WarCardGameClientAppletController createController() 
	{
		return new WarCardGameClientAppletController((WarCardGameModel)this.model, (WarCardGameClientAppletView)this.view);
	}

	@Override
	protected WarCardGameSocketWorker createSocketWorker() 
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
		
		return new WarCardGameSocketWorker(socket, (WarCardGameClientAppletController)this.controller);
	}
}
