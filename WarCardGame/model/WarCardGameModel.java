package model;

import javax.swing.JTextArea;

/**
 *	contains:
 *
 * 	public methods:
 *	WarCardGameModel()
 *	toString()
 */
public class WarCardGameModel extends GenericCardGameModel
{	
	private static final long serialVersionUID = 1L;
	
	public JTextArea chatArea;
	
	/**
	 * initializes a CardList of cards and an ArrayedList of players
	 * 
	 * sets the chat area to blank and the required number of players for War to two
	 */
	public WarCardGameModel()
	{
		//calls the constructor of the GenericGameModel
		//creates new CardList of cards and new ArrayedList of players
		super();
		
		this.requiredNumberOfPlayers = 2;
		this.chatArea = new JTextArea("");
	}
	
	/**
	 * prints out players and cards in string format so we can see what is happening on the server side
	 */
	@Override 
	public String toString()
	{
		String result = "";
		
		result += "*****DECK*****\n\n";
		for(GenericCardGameCard card : this.deck)
		{
			result += (card.toString() + "\n");
		}
		
		result += "*****PLAYERS*****\n\n";
		for(GenericCardGamePlayer player : this.players)
		{
			result += (player.toString() + "\n");
		}
		
		return result;
	}
}


