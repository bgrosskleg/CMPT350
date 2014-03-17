package controller;

import view.GenericView;
import model.GenericModel;

public abstract class GenericCardGameClientAppletController extends GenericController 
{
	public GenericCardGameClientAppletController(GenericModel model, GenericView view)
	{
		super(model, view);
	}
}
