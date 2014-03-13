package controller;

/**
 * a generic game controller class that provides simple functions that all card
 * games will implement 
 *
 */
public abstract class ServerController extends GenericController
{
	/**
	 * a generic function to evaluate what cards the players have given
	 * points will be allocated and cards will be moved within this method
	 */
	public abstract void evaluateHand();

	/**
	 * a generic start of game function to set up the players and deal the hands
	 */
	public abstract void initializeGame();

	public abstract void gameOver();
	/**
	 * will deal a card from a random part of the list whatever the list size
	 * this gets rid of the need to shuffle the cards
	 */
	public abstract void dealRandomCards();
}