package controller;

import model.WarCardGameModel;
import view.WarCardGameClientAppletView;


public class WarCardGameClientAppletController extends WarCardGameGeneralController
{

	public int playerNumber;
	
	public WarCardGameClientAppletController(WarCardGameModel model, WarCardGameClientAppletView view) 
	{
		super(model, view);
	}
}
