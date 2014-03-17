
import controller.GenericController;
import view.GenericView;
import model.GenericModel;


public abstract class GenericMVCServerApplication 
{	
	protected GenericModel model;
	protected GenericView view;
	protected GenericController controller;
		
	protected GenericMVCServerApplication()
	{
		model = createModel();
    	view = createView();
    	controller = createController();
	}
	
	protected abstract GenericModel createModel();
	protected abstract GenericView createView();
	protected abstract GenericController createController();
}
