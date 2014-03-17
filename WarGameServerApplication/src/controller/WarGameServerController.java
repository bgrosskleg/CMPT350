package controller;

import view.WarGameServerView;
import model.WarGameModel;

/**
 * a generic game controller class that provides simple functions that all card
 * games will implement 
 *
 */
public class WarGameServerController extends GenericGameServerController
{	
	public WarGameServerController(WarGameModel model, WarGameServerView view) 
	{
		super(model, view);
		initializeGame();
	}

	@Override
	protected void initializeGame() 
	{
		this.initializeDeck(1);
		
		while(((WarGameModel)this.model).getPlayers().size() < 2)
		{/*WAIT FOR PLAYERS CONNECTION*/}
		
		//Deal cards
		dealCards();
		
		//Wait for players action
		evaluateHand();
	}

	@Override
	protected void dealCards()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameOver() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void evaluateHand() 
	{
		// TODO Auto-generated method stub
		
	}
}