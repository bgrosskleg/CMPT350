package controller;

import view.WarCardGameServerView;
import model.WarCardGameModel;

/**
 * a generic game controller class that provides simple functions that all card
 * games will implement 
 *
 */
public class WarCardGameServerController extends GenericCardGameServerController
{	
	public WarCardGameServerController(WarCardGameModel model, WarCardGameServerView view) 
	{
		super(model, view);
	}

	@Override
	public void initializeGame() 
	{
		this.initializeDeck(1);
		
		System.out.println("GET'S HERE 1");
		
		while(((WarCardGameModel)this.model).getPlayers().size() < 2)
		{/*WAIT FOR PLAYERS CONNECTION*/}
		
		System.out.println("GET'S HERE 2");
		
		//Deal cards
		dealCards();
		
		//Wait for players action
		evaluateHand();
	}

	@Override
	public void dealCards()
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