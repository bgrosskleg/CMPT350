package model;

import java.util.ArrayList;

import model.Player.Dest;

public abstract class GenericGameModel 
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
	
	protected void sendCard(Card card, Player player, Dest dest)
	{
		
	}
	
	protected void receiveCard(Player player)
	{
		
	}
	
	protected abstract void dealCards();
	
	protected abstract void evalHand();
	
	protected abstract void gameOver();
	
	
}