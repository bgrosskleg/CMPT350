package controller;

import view.GenericMVCView;
import model.GenericMVCModel;
/**
 * contains:
 *
 * protected methods:
 * GenericMVCController(GenericMVCModel, GenericMVCView)
 */
public abstract class GenericMVCController 
{
	protected final GenericMVCModel model;
	protected final GenericMVCView view;
	/**
	 * take in a model and a view and add it to a controller
	 * 
	 * @param model the model is added to this protected model
	 * @param view the view is added to this protected view
	 */
	protected GenericMVCController(GenericMVCModel model, GenericMVCView view)
	{
		this.model = model;
		this.view = view;
	}
	
}
