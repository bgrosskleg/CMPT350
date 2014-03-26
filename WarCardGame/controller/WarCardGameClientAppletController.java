package controller;

import model.WarCardGameModel;
import view.WarCardGameClientAppletView;

/**
 * contains:
 * 
 * public variables:
 * playerNumber(int)
 * 
 * public methods:
 * WarCardGameClientAppletController(WarCardGameModel, WarCardGameClientAppletView)
 *
 */
public class WarCardGameClientAppletController extends GenericCardGameController
{
	public int playerNumber;
	
	/**
	 * implements the generic view given in GenericCardGameController
	 * @param model the model to be received
	 * @param view the view to be sent
	 */
	public WarCardGameClientAppletController(WarCardGameModel model, WarCardGameClientAppletView view) 
	{
		super(model, view);
	}
}
