package controller;

import model.Card;
import model.CardList;
import model.GenericGameModel;
import view.GenericGameServerView;

public abstract class GenericGameServerController extends GenericController 
{
	public GenericGameServerController(GenericGameModel model, GenericGameServerView view)
	{
		super(model, view);
		
		initializeGame();
	}
	
	/**
	 * gets the game ready to be played
	 * calls all the methods needed to set up the players and cards
	 */
	protected abstract void initializeGame();
		
	protected void initializeDeck(int numOfDecks)
	{
		((GenericGameModel)model).setDeck(new CardList());
		
		for(int iter = numOfDecks; iter > 1; iter--)
		{
			for(Card.Suit suit : Card.Suit.values())
			{
				for(Card.Value value: Card.Value.values())
				{
					((GenericGameModel)model).getDeck().add(new Card(value, suit));
				}
			}
		}
		
		((GenericGameModel)model).getDeck().shuffle();
		
		model.notifyModelSubscribers();
	}
	
	protected abstract void dealCards();
	
	
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
}
