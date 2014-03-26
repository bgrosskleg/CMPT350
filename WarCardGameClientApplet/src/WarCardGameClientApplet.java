import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.WarCardGameClientAppletController;
import controller.WarCardGameClientAppletSocketWorker;
import view.GenericMVCView;
import view.WarCardGameClientAppletView;
import model.GenericMVCModel;
import model.WarCardGameModel;

/**
 * contains:
 * 
 * public variables:
 * objectPort(int)
 * 
 * public methods:
 * WarCardGaeClientApplet()
 * 
 * protected methods:
 * createModel()
 * createView(GenericMVCModel, playerNumber)
 * createController(GenericMVCModel, GenericMVCView)
 * createSocketWorker(GenericMVCModel)
 *
 */
public class WarCardGameClientApplet extends GenericCardGameClientApplet
{
	private static final long serialVersionUID = 1L;
	
	public static final int objectPort = 65000;
	
	public WarCardGameClientApplet()
	{
		//call the constructor from GenericCardGameClientApplet
		super();
	}
	
	@Override
	protected WarCardGameModel createModel() 
	{
		return new WarCardGameModel();
	}

	@Override
	protected WarCardGameClientAppletView createView(GenericMVCModel model, int playerNumber) 
	{
		return new WarCardGameClientAppletView((WarCardGameModel)model, playerNumber);	
	}

	@Override
	protected WarCardGameClientAppletController createController(GenericMVCModel model, GenericMVCView view) 
	{
		return new WarCardGameClientAppletController((WarCardGameModel)model, (WarCardGameClientAppletView)view);
	}

	@Override
	protected WarCardGameClientAppletSocketWorker createSocketWorker(GenericMVCModel model) 
	{
		Socket socket;
		try 
		{
			socket = new Socket(InetAddress.getByName(this.getCodeBase().getHost()), objectPort);
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
		
		return new WarCardGameClientAppletSocketWorker(socket, (WarCardGameModel) model);
	}
}
