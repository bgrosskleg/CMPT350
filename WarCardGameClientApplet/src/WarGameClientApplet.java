import controller.WarCardGameClientAppletController;
import view.WarCardGameClientAppletView;
import model.WarPlayer;


public class WarGameClientApplet extends GenericCardGameClientApplet
{
	private static final long serialVersionUID = 1L;

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
		return new WarCardGameClientAppletController(this.model, this.view);
	}

	

}
