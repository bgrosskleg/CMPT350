package model;

import controller.GenericCardGameSocketWorker;


public class WarCardGamePlayer extends GenericCardGamePlayer
{	
	private static final long serialVersionUID = 1L;

	public GenericCardGameCard cardPlayed;
	public GenericCardGameCardList winPile;
	public GenericCardGameCardList flipDeck;
	
	public static enum Destination
	{
		HAND, WINPILE
	}

	public WarCardGamePlayer(GenericCardGameSocketWorker socketWorker) 
	{
		super(socketWorker);
		this.cardPlayed = null;
		this.winPile = new GenericCardGameCardList();
		this.flipDeck = new GenericCardGameCardList();
	}
	
	public int getPlayerNumber()
	{
		return playerNumber;
	}
		
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
