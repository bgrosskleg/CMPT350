package controller;

import view.GenericMVCView;
import model.GenericMVCModel;

public abstract class GenericMVCController 
{
	protected GenericMVCModel model;
	protected GenericMVCView view;
	
	protected GenericMVCController(GenericMVCModel model, GenericMVCView view)
	{
		this.model = model;
		this.view = view;
	}
	
}
