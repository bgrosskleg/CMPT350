package controller;

import model.WarGame;

/**
 * a generic game controller class that provides simple functions that all card
 * games will implement 
 *
 */
public class GameController extends GenericController
{
	public GameController()
	{
		this.systemModel = new WarGame();
		this.comThread = new ServerCommunicationThreadOLD();
	}
	
	
	/**
	 * evaluates the players hands determining who has won the round
	 * toDo:	send cards to players winpiles?
	 * 			take in hands as parameters?
	 */
	public void evaluateHand() 
	{
		// TODO Auto-generated method stub

	}
	/**
	 * gets the game ready to be played
	 * calls all the methods needed to set up the players and cards
	 */
	public void initializeGame() 
	{
		// TODO Auto-generated method stub

	}

	/**
	 * display the end game screen
	 * reset the players hands and deck
	 * possibly increment a larger score (games won/lost statistics etc)
	 * send back to initial game screen
	 */
	public void gameOver() 
	{
		// TODO Auto-generated method stub

	}

	/**
	 * parameters:	CardList?
	 * 				Player cards go to?
	 * 				number of cards to be dealt?
	 * 				
	 * deal a card or cards to a player from a random place within the CardList
	 * 
	 */
	public void dealRandomCards() 
	{
		// TODO Auto-generated method stub

	}
}