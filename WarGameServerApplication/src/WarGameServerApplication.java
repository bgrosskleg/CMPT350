import javax.swing.JFrame;

import controller.GenericController;
import controller.WarGameServerController;
import view.GenericView;
import view.WarGameServerView;
import model.GenericModel;
import model.WarGameModel;

public class WarGameServerApplication extends GenericServerApplication
{
	public static void main(String [ ] args)
	{				
		WarGameServerApplication game = new WarGameServerApplication();
		
		JFrame frame = new JFrame("War Game");
		frame.add(game.view);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public WarGameServerApplication()
	{
		super();
	}

	@Override
	protected GenericModel createModel() 
	{
		return new WarGameModel();
	}

	@Override
	protected GenericView createView() 
	{
		return new WarGameServerView((WarGameModel) model);
	}

	@Override
	protected GenericController createController() 
	{
		return new WarGameServerController((WarGameModel) model, (WarGameServerView) view);
	}
}
