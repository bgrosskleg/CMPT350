import java.io.IOException;

import javax.swing.JFrame;

import controller.WarCardGameServerController;
import controller.WarCardGameServerWaitForPlayersThread;
import view.WarCardGameServerView;
import model.WarCardGameModel;

public class WarCardGameServerApplication extends GenericCardGameServerApplication
{
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
			(new WarCardGameServerWaitForPlayersThread(65000, (WarCardGameServerController)game.controller)).start();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((WarCardGameServerController)game.controller).initializeGame();		
	}
	
	public WarCardGameServerApplication()
	{
		super();
	}

	@Override
	protected WarCardGameModel createModel() 
	{
		return new WarCardGameModel();
	}

	@Override
	protected WarCardGameServerView createView() 
	{
		return new WarCardGameServerView((WarCardGameModel) model);
	}

	@Override
	protected WarCardGameServerController createController() 
	{
		return new WarCardGameServerController((WarCardGameModel) model, (WarCardGameServerView) view);
	}
}
