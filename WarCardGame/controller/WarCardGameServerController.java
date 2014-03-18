package controller;

import view.WarCardGameServerView;
import model.GenericCardGameCard;
import model.GenericCardGameCardList;
import model.GenericCardGameModel;
import model.GenericCardGamePlayer;
import model.WarCardGameModel;

/**
 * a generic game controller class that provides simple functions that all card
 * games will implement 
 *
 */
public class WarCardGameServerController extends GenericCardGameController
{	
	private int requiredNumberOfPlayers = 2;
	
	public WarCardGameServerController(WarCardGameModel model, WarCardGameServerView view) 
	{
		super(model, view);
	}

	public void initializeGame() 
	{
		initializeDeck(1);
		
		System.out.println("WAITING FOR ENOUGH PLAYERS");
		
		while(((WarCardGameModel)this.model).getPlayers().size() < requiredNumberOfPlayers)
		{
			/*WAIT FOR PLAYERS CONNECTION*/
			try 
			{
				Thread.sleep(50);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("ENOUGH PLAYERS FOUND");
		
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

	public int getRequiredNumberOfPlayers()
	{
		return requiredNumberOfPlayers;
	}
	
	public void dealCards()
	{
		while(((WarCardGameModel)this.model).getDeck().size() > 0)
		{
			for(GenericCardGamePlayer player : ((WarCardGameModel)this.model).getPlayers())
			{
				player.getHand().add(((WarCardGameModel)this.model).getDeck().remove(0));
			}
		}
		
		//Send all players their card
		((WarCardGameModel)this.model).notifyModelSubscribers();
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