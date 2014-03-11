package model;

import java.util.ArrayList;

public class GenericGameModel 
{
	CardList cards;	
	ArrayList<Player> players;
	
	protected GenericGameModel()
	{
		cards = new CardList();				//new CardList which extends
		players = new ArrayList<Player>();		
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
}