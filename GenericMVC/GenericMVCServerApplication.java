
import controller.GenericMVCController;
import view.GenericMVCView;
import model.GenericMVCModel;
/**
 * contains:
 * 
 * protected methods:
 * GenericVMCServerApplication()
 * 
 */

public abstract class GenericMVCServerApplication 
{	
	protected GenericMVCModel model;
	protected GenericMVCView view;
	protected GenericMVCController controller;
		
	/**
	 * creates a model, view, and controller
	 */
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
