package model;

import controller.GenericCardGameSocketWorker;

/**
 *	contains:
 *
 * 	public methods:
 * 	WarCardGamePlayer(GenericCardGameSocketWorker socketWorker)
 *	getPlayerNumber()
 *	toString()
 */
public class WarCardGamePlayer extends GenericCardGamePlayer
{	
	private static final long serialVersionUID = 1L;

	public GenericCardGameCard cardPlayed;
	public GenericCardGameCardList winPile;
	public GenericCardGameCardList flipDeck;
	
	/**
	 * HAND is where the ArrayList of cards that are currently in the players hand go
	 * WINPILE is where the ArrayList of cards the player has won go
	 * 
	 * when the player runs out of cards in their hand the WINPILE is taken and put into the HAND
	 */
	public static enum Destination
	{
		HAND, WINPILE
	}

	/**
	 * initializes the winPile and the flipDeck assiciated with this instance of a player
	 * 
	 * @param socketWorker the socket worker that recieves and sends information about the model
	 */
	public WarCardGamePlayer(GenericCardGameSocketWorker socketWorker) 
	{
		super(socketWorker);
		this.cardPlayed = null;
		this.winPile = new GenericCardGameCardList();
		this.flipDeck = new GenericCardGameCardList();
	}
	
	/**
	 * gets the PlayerNumber
	 * 
	 * @return the playerNumber
	 */
	public int getPlayerNumber()
	{
		return playerNumber;
	}
		
	/**
	 * prints out information about this player
	 */
	@Override
	public String toString()
	{
		String result = "";
		
		result += ("PLAYER " + playerNumber + "\n");
		
		if(cardPlayed == null)
		{result += ("CardPlayed: NULL \n");}
		else
		{result += ("Card Played: " + cardPlayed.toString() + "\n");}
		
		result += ("Win Pile:\n" + winPile.toString() + "\n");
		result += ("Flip Deck:\n" + flipDeck.toString() + "\n");
		
		return result;
	}
}
