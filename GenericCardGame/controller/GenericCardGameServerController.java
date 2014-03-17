package controller;

import model.Card;
import model.CardList;
import model.GenericCardGameModel;
import view.GenericCardGameServerView;

public abstract class GenericCardGameServerController extends GenericController 
{
	public GenericCardGameServerController(GenericCardGameModel model, GenericCardGameServerView view)
	{
		super(model, view);
	}
	
	/**
	 * gets the game ready to be played
	 * calls all the methods needed to set up the players and cards
	 */
	public abstract void initializeGame();
		
	public void initializeDeck(int numOfDecks)
	{
		((GenericCardGameModel)model).setDeck(new CardList());
		
		for(int iter = numOfDecks; iter > 1; iter--)
		{
			for(Card.Suit suit : Card.Suit.values())
			{
				for(Card.Value value: Card.Value.values())
				{
					((GenericCardGameModel)model).getDeck().add(new Card(value, suit));
				}
			}
		}
		
		((GenericCardGameModel)model).getDeck().shuffle();
		
		model.notifyModelSubscribers();
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
}
