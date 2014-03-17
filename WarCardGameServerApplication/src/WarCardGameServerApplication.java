import javax.swing.JFrame;

import controller.GenericController;
import controller.WarCardGameServerController;
import view.GenericView;
import view.WarGameServerView;
import model.GenericModel;
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
		
		((WarCardGameServerController)game.controller).initializeGame();
	}
	
	public WarCardGameServerApplication()
	{
		super();
	}

	@Override
	protected GenericModel createModel() 
	{
		return new WarCardGameModel();
	}

	@Override
	protected GenericView createView() 
	{
		return new WarGameServerView((WarCardGameModel) model);
	}

	@Override
	protected GenericController createController() 
	{
		return new WarCardGameServerController((WarCardGameModel) model, (WarGameServerView) view);
	}
}
