
import controller.GenericMVCController;
import view.GenericMVCView;
import model.GenericMVCModel;


public abstract class GenericMVCServerApplication 
{	
	protected GenericMVCModel model;
	protected GenericMVCView view;
	protected GenericMVCController controller;
		
	protected GenericMVCServerApplication()
	{
		model = createModel();
    	view = createView();
    	controller = createController();
	}
	
	protected abstract GenericMVCModel createModel();
	protected abstract GenericMVCView createView();
	protected abstract GenericMVCController createController();
}
