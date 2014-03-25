package model;

import java.util.ArrayList;

public abstract class GenericCardGameModel extends GenericMVCModel
{
	private static final long serialVersionUID = 1L;
	
	protected GenericCardGameCardList deck;	
	protected int requiredNumberOfPlayers;
	protected ArrayList<GenericCardGamePlayer> players;
		
	protected GenericCardGameModel()
	{
		//Calls the constructor of the GenericModel
		super();
		this.deck = new GenericCardGameCardList();
		this.players = new ArrayList<GenericCardGamePlayer>();
		this.requiredNumberOfPlayers = -1;
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
	
	public int getRequiredNumberOfPlayers()
	{
		return this.requiredNumberOfPlayers;
	}
}