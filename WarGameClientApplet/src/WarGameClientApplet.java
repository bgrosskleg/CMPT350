import controller.GenericController;
import controller.WarGameClientAppletController;
import view.GenericView;
import view.WarGameClientAppletView;
import model.GenericModel;
import model.WarPlayer;

public class WarGameClientApplet extends GenericClientApplet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected GenericModel createModel() 
	{
		//Prompt for name
		String name = null;
		//...
		
		return new WarPlayer(name);
	}

	@Override
	protected GenericView createView() 
	{
		return new WarGameClientAppletView(this.model);	
	}

	@Override
	protected GenericController createController() 
	{
		return new WarGameClientAppletController(this.model, this.view);
	}

	

}
