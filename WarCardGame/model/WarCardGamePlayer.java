package model;

import controller.GenericCardGameSocketWorker;


public class WarCardGamePlayer extends GenericCardGamePlayer
{	
	private static final long serialVersionUID = 1L;
	
	public String name;
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
		cardPlayed = null;
		name = null;
		winPile = new GenericCardGameCardList();
		flipDeck = new GenericCardGameCardList();
	}
		
	@Override
	public String toString()
	{
		String result = "";
		
		if(name == null)
		{result += ("Name: NULL \n");}
		else
		{result += ("Name: " + name + "\n");}
		
		if(cardPlayed == null)
		{result += ("CardPlayed: NULL \n");}
		else
		{result += ("Card Played: " + cardPlayed.toString() + "\n");}
		
		result += ("Win Pile:\n" + winPile.toString() + "\n");
		result += ("Flip Deck:\n" + flipDeck.toString() + "\n");
		
		return result;
	}
}
