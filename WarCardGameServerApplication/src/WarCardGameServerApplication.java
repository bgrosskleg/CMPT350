import java.io.IOException;

import javax.swing.JFrame;

import controller.WarCardGameServerController;
import controller.WarCardGameServerWaitForConnectionsWorker;
import view.WarCardGameServerView;
import model.WarCardGameModel;
/**
 * contains:
 * 
 * public methods:
 * main(String [ ])
 * arCardGameServerApplication()
 * 
 * protected methods:
 * createModel()
 * createView()
 * createController()
 */
public class WarCardGameServerApplication extends GenericCardGameServerApplication
{
	public static final int objectPort = 65000;
	
	/**
	 * the entry point into the server side of the application
	 * 
	 * @param args the args parameter
	 * @throws general exception and prints the StackTrace if anything goes wrong
	 */
	public static void main(String [ ] args)
	{				
		WarCardGameServerApplication game = new WarCardGameServerApplication();
		
		JFrame frame = new JFrame("War Game");
		frame.add(game.view);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try
		{
			WarCardGameServerWaitForConnectionsWorker worker = new WarCardGameServerWaitForConnectionsWorker(objectPort, ((WarCardGameModel)game.model).getRequiredNumberOfPlayers(), (WarCardGameModel)game.model);
			(new Thread(worker)).start();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(-1);
		}
		
		((WarCardGameServerController)game.controller).initializeGame();		
	}
	
	/**
	 * creates an instance of a GenericCardGameServerApplication
	 */
	public WarCardGameServerApplication()
	{
		super();
	}

	/**
	 * creates a new model 
	 */
	@Override
	protected WarCardGameModel createModel() 
	{
		return new WarCardGameModel();
	}

	/**
	 * creates a new view and gives it a model
	 */
	@Override
	protected WarCardGameServerView createView() 
	{
		return new WarCardGameServerView((WarCardGameModel) model);
	}

	/**
	 * creates a new controller and gives it a model and a view
	 */
	@Override
	protected WarCardGameServerController createController() 
	{
		return new WarCardGameServerController((WarCardGameModel) model, (WarCardGameServerView) view);
	}
}
