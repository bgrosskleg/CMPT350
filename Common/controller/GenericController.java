package controller;

import model.GenericModel;
import view.GenericView;

public abstract class GenericController 
{
	protected GenericModel model;
	protected GenericView view;
	
	protected GenericController(GenericModel model, GenericView view)
	{
		this.model = model;
		this.view = view;
	}
}
