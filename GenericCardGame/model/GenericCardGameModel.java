package model;

import java.util.ArrayList;

public abstract class GenericCardGameModel extends GenericMVCModel
{
	protected GenericCardGameCardList deck;	
	protected ArrayList<GenericCardGamePlayer> players;
		
	protected GenericCardGameModel()
	{
		//Calls the constructor of the GenericModel
		super();
		deck = new GenericCardGameCardList();
		players = new ArrayList<GenericCardGamePlayer>();		
	}
	
	public GenericCardGameCardList getDeck()
	{
		return deck;
	}
	
	public void setDeck(GenericCardGameCardList deck)
	{
		this.deck = deck;
		this.notifyModelSubscribers();
	}
	
	public ArrayList<GenericCardGamePlayer> getPlayers()
	{
		return players;
	}
	
	public void setPlayers(ArrayList<GenericCardGamePlayer> players)
	{
		this.players = players;
		this.notifyModelSubscribers();
	}
}