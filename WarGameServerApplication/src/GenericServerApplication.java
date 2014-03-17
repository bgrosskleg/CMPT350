import model.GenericModel;
import view.GenericView;
import controller.GenericController;

/**
 * MVC Structure: http://leepoint.net/notes-java/GUI/structure/40mvc.html
 */
public abstract class GenericServerApplication 
{
	protected GenericModel model;
	protected GenericView view;
	protected GenericController controller;
	
	protected GenericServerApplication()
	{
		model = createModel();
    	view = createView();
    	controller = createController();
	}
	
	protected abstract GenericModel createModel();
	protected abstract GenericView createView();
	protected abstract GenericController createController();
}
