import javax.swing.JFrame;

import controller.WarGameServerController;
import view.WarGameServerView;
import model.WarGameModel;

/**
 * WarGame is the main entry point from which the game is played
 * MVC Structure: http://leepoint.net/notes-java/GUI/structure/40mvc.html
 */
public class WarGameServerApplication
{
	public static void main(String [ ] args)
	{		
		WarGameModel model = new WarGameModel();
		WarGameServerView view = new WarGameServerView(model);
		WarGameServerController controller = new WarGameServerController(model, view);
		
		JFrame frame = new JFrame("War Game");
		frame.add(view);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
