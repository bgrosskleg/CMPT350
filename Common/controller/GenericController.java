package controller;

import model.GenericModel;
import view.GenericView;

public class GenericController 
{
	private GenericModel model;
	private GenericView view;
	
	protected GenericController(GenericModel model, GenericView view)
	{
		this.model = model;
		this.view = view;
	}
}
