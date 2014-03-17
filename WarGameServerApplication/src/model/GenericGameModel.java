package model;

import java.util.ArrayList;

public abstract class GenericGameModel extends GenericModel
{
	protected CardList deck;	
	protected ArrayList<GenericPlayer> players;
		
	protected GenericGameModel()
	{
		//Calls the constructor of the GenericModel
		super();
		deck = new CardList();
		players = new ArrayList<GenericPlayer>();		
	}
	
	public void initializeDeck(int numOfDecks)
	{
		deck = new CardList();
		
		for(int iter = numOfDecks; iter > 1; iter--)
		{
			for(Card.Suit suit : Card.Suit.values())
			{
				for(Card.Value value: Card.Value.values())
				{
					deck.add(new Card(value, suit));
				}
			}
		}
		
		this.notifyModelSubscribers();
	}
	
	public abstract void dealCards();
	
	
	/**
	 * display the end game screen
	 * reset the players hands and deck
	 * possibly increment a larger score (games won/lost statistics etc)
	 * send back to initial game screen
	 */
	public abstract void gameOver();
	
	/**
	 * evaluates the players hands determining who has won the round
	 * toDo:	send cards to players winpiles?
	 * 			take in hands as parameters?
	 */
	public abstract void evaluateHand();
	
	/**
	 * gets the game ready to be played
	 * calls all the methods needed to set up the players and cards
	 */
	public abstract void initializeGame();
}