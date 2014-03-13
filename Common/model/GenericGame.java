package model;

import java.util.ArrayList;

public abstract class GenericGame extends GenericModel
{
	CardList cards;	
	ArrayList<GenericPlayer> players;
	
	protected GenericGame()
	{
		super();
		cards = new CardList();
		players = new ArrayList<GenericPlayer>();		
	}
	
	protected void initializeCards(int numOfDecks)
	{
		cards = new CardList();
		
		for(int iter = numOfDecks; iter > 1; iter--)
		{
			for(Card.Suit suit : Card.Suit.values())
			{
				for(Card.Value value: Card.Value.values())
				{
					cards.add(new Card(value, suit, Card.Display.FACEDOWN));
				}
			}
		}
	}
	
	protected void sendCard(Card card, GenericPlayer player)
	{
		
	}
	
	protected void receiveCard(GenericPlayer player)
	{
		
	}
	
	protected abstract void dealCards();
	
	protected abstract void evalHand();
	
	protected abstract void gameOver();
	
	
}