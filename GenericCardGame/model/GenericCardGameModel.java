package model;

import java.util.ArrayList;
/**
 * contains:
 * 
 * public methods:
 * getDeck()
 * setDeck(deck)
 * getPlayers()
 * setPlayers(players)
 * getRequiredNumberOfPlayers()
 * 
 * protected methods:
 * GenericCardGameModel()
 */
public abstract class GenericCardGameModel extends GenericMVCModel
{
	private static final long serialVersionUID = 1L;
	
	protected GenericCardGameCardList deck;	
	protected int requiredNumberOfPlayers;
	protected ArrayList<GenericCardGamePlayer> players;
		
	/**
	 * initializes the deck and the player, reduces the requiredNumberOfPlayers by 1
	 * 
	 * calls the GenericModel constructor
	 */
	protected GenericCardGameModel()
	{
		//Calls the constructor of the GenericModel
		super();
		this.deck = new GenericCardGameCardList();
		this.players = new ArrayList<GenericCardGamePlayer>();
		this.requiredNumberOfPlayers = -1;
	}
	
	/**
	 * gets the deck
	 * 
	 * @return the deck
	 */
	public GenericCardGameCardList getDeck()
	{
		return deck;
	}
	
	/**
	 * set a specific deck and send it to the players
	 * 
	 * @param deck the deck to be set as this deck
	 */
	public void setDeck(GenericCardGameCardList deck)
	{
		this.deck = deck;
		this.notifyModelSubscribers();
	}
	
	/**
	 * get the players in the ArrayList
	 * 
	 * @return the ArrayList of  players
	 */
	public ArrayList<GenericCardGamePlayer> getPlayers()
	{
		return players;
	}
	
	/**
	 * set the players in the ArrayList and notifies the players
	 * 
	 */
	public void setPlayers(ArrayList<GenericCardGamePlayer> players)
	{
		this.players = players;
		this.notifyModelSubscribers();
	}
	
	/**
	 * gets the amount of players needed before the game will initialize and start
	 * 
	 * @return this requiredNumberOfPlayers
	 */
	public int getRequiredNumberOfPlayers()
	{
		return this.requiredNumberOfPlayers;
	}
}