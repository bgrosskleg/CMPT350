package model;

import java.util.ArrayList;

public abstract class GenericGame extends GenericModel
{
	protected CardList deck;	
	protected ArrayList<GenericPlayer> players;
	
	protected GenericGame()
	{
		//Calls the constructor of the GenericModel
		super();
		deck = new CardList();
		players = new ArrayList<GenericPlayer>();		
	}
	
	protected void initializeDeck(int numOfDecks)
	{
		deck = new CardList();
		
		for(int iter = numOfDecks; iter > 1; iter--)
		{
			for(Card.Suit suit : Card.Suit.values())
			{
				for(Card.Value value: Card.Value.values())
				{
					deck.add(new Card(value, suit, Card.Display.FACEDOWN));
				}
			}
		}
	}
	
	protected abstract void dealCards();
	
	protected abstract void evalHand();
	
	protected abstract void gameOver();
	
	
}