import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.GenericMVCSocketWorker;
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
	
	/**
	 * calls the GenericCardGameClientApplet constructor
	 */
	public WarCardGameClientApplet()
	{
		super();
	}
	
	/**
	 * creates the WarCardGameModel
	 */
	@Override
	protected WarCardGameModel createModel() 
	{
		return new WarCardGameModel();
	}

	/**
	 * creates a new Applet view and gives the player a model
	 * 
	 * @param model the current model
	 * @param playerNumber the players id number
	 * @return the Applet view with a player and a model
	 */
	@Override
	protected WarCardGameClientAppletView createView(GenericMVCModel model, GenericMVCSocketWorker socketWorker) 
	{
		return new WarCardGameClientAppletView((WarCardGameModel)model, (WarCardGameClientAppletSocketWorker)socketWorker);	
	}

	/**
	 * creates a new Applet Controller and gives it the model and view
	 * 
	 * @param model the model parameter
	 * @param view the veiw parameter
	 * @return the ClientAppletController with a model and a view
	 */
	@Override
	protected WarCardGameClientAppletController createController(GenericMVCModel model, GenericMVCView view) 
	{
		return new WarCardGameClientAppletController((WarCardGameModel)model, (WarCardGameClientAppletView)view);
	}

	/**
	 * creates a socketWorker and gives it a socket and a model to work with
	 * 
	 * @param model the model to be given to the socketWorker
	 */
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
