package model;

import java.util.ArrayList;

public abstract class GenericCardGameModel extends GenericModel
{
	protected CardList deck;	
	protected ArrayList<GenericPlayer> players;
		
	protected GenericCardGameModel()
	{
		//Calls the constructor of the GenericModel
		super();
		deck = new CardList();
		players = new ArrayList<GenericPlayer>();		
	}
	
	public CardList getDeck()
	{
		return deck;
	}
	
	public void setDeck(CardList deck)
	{
		this.deck = deck;
		this.notifyModelSubscribers();
	}
	
	public ArrayList<GenericPlayer> getPlayers()
	{
		return players;
	}
	
	public void setPlayers(ArrayList<GenericPlayer> players)
	{
		this.players = players;
		this.notifyModelSubscribers();
	}
}