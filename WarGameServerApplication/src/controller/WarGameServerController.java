package controller;

import view.WarGameServerView;
import model.Card;
import model.GenericPlayer;
import model.WarGameModel;

/**
 * a generic game controller class that provides simple functions that all card
 * games will implement 
 *
 */
public class WarGameServerController extends GenericController
{	
	public WarGameServerController(WarGameModel model, WarGameServerView view) 
	{
		super(model, view);
		
	
	}

	protected void sendCard(Card card, GenericPlayer player)
	{
		
	}
	
	protected void receiveCard(GenericPlayer player)
	{
		
	}
}