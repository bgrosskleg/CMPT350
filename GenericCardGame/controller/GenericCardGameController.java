package controller;

import model.GenericCardGameModel;
import view.GenericCardGameView;
/**
 * contains:
 * 
 *  protected methods:
 *  GenericCardGameController(GenericCardGameModel, GenericCardGameView)
 *
 */
public abstract class GenericCardGameController extends GenericMVCController
{
	protected GenericCardGameController(GenericCardGameModel model, GenericCardGameView view) 
	{
		super(model, view);
	}
}
