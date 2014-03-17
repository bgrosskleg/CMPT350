package controller;

import view.WarCardGameServerView;
import model.GenericCardGameCard;
import model.GenericCardGameCardList;
import model.GenericCardGameModel;
import model.WarCardGameModel;

/**
 * a generic game controller class that provides simple functions that all card
 * games will implement 
 *
 */
public class WarCardGameServerController extends GenericCardGameController
{	
	public WarCardGameServerController(WarCardGameModel model, WarCardGameServerView view) 
	{
		super(model, view);
	}

	public void initializeGame() 
	{
		initializeDeck(1);
		
		System.out.println("GET'S HERE 1");
		
		while(((WarCardGameModel)this.model).getPlayers().size() < 2)
		{/*WAIT FOR PLAYERS CONNECTION*/}
		
		System.out.println("GET'S HERE 2");
		
		//Deal cards
		dealCards();
		
		//Wait for players action
		evaluateHand();
	}
	
	public void initializeDeck(int numOfDecks)
	{
		((GenericCardGameModel)model).setDeck(new GenericCardGameCardList());

		for(int iter = numOfDecks; iter > 1; iter--)
		{
			for(GenericCardGameCard.Suit suit : GenericCardGameCard.Suit.values())
			{
				for(GenericCardGameCard.Value value: GenericCardGameCard.Value.values())
				{
					((GenericCardGameModel)model).getDeck().add(new GenericCardGameCard(value, suit));
				}
			}
		}

		((GenericCardGameModel)model).getDeck().shuffle();

		model.notifyModelSubscribers();
	}

	public void dealCards()
	{
		// TODO Auto-generated method stub
		
	}

	public void gameOver() 
	{
		// TODO Auto-generated method stub
		
	}

	public void evaluateHand() 
	{
		// TODO Auto-generated method stub
		
	}
}