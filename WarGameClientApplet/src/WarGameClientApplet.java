import controller.WarGameClientAppletController;
import view.WarGameClientAppletView;
import model.WarPlayer;

public class WarGameClientApplet extends GenericClientApplet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void initializeModel() 
	{
		//Prompt for name
		String name = null;
		//...
		
		this.model = new WarPlayer(name);
	}

	@Override
	protected void initializeView() 
	{
		this.view = new WarGameClientAppletView(this.model);	
	}

	@Override
	protected void initializeController() 
	{
		this.controller = new WarGameClientAppletController(this.model, this.view);
	}

	

}
