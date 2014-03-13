package model;

import java.util.ArrayList;

public class WarGame extends GenericGame
{	
	public WarGame()
	{
		//calls the constructor of the GenericGame
		//creates new CardList of cards and new ArrayedList of players
		super();

		//initialize 1 deck of cards
		this.initializeDeck(1);
		this.deck.shuffle();

		
		//Start thread that waits for players
		
	}

	@Override
	protected void dealCards() 
	{
		while(!deck.isEmpty())
		{
			for(int i = 0; i < players.size() && !deck.isEmpty(); i++)
			{
				sendCard(deck.remove(0), players.get(i));
			}
		}
	}

	@Override
	protected void evalHand() 
	{
		/*
		 *receive a card from each player, and send them to the winner 
		 */
		//CardList currentRound = new CardList();
		//Card temp;
		for(int i = 0; i < players.size(); i++)
		{
			/*
			 * receive cards somehow, and put them in currentRound
			 */
		}
		
	}

	@Override
	protected void gameOver()
	{
		// TODO Auto-generated method stub

	}

	public int getNumOfPlayers() 
	{
		return numOfPlayers;
	}

	public void setNumOfPlayers(int numOfPlayers) 
	{
		this.numOfPlayers = numOfPlayers;
		this.notifyModelSubscribers();
	}
}


