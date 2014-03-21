package controller;

import model.GenericCardGameModel;
import model.GenericMVCModel;
import view.GenericCardGameView;

public abstract class GenericCardGameController extends GenericMVCController
{
	protected GenericCardGameController(GenericCardGameModel model, GenericCardGameView view) 
	{
		super(model, view);
	}


	protected abstract void updateModel(GenericMVCModel newModel);
}
