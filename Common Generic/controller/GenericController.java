package controller;

import view.GenericView;
import model.GenericModel;

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
