package model;

import javax.swing.JTextArea;

public class WarCardGameModel extends GenericCardGameModel
{	
	private static final long serialVersionUID = 1L;
	
	public JTextArea chatArea;
	
	public WarCardGameModel()
	{
		//calls the constructor of the GenericGameModel
		//creates new CardList of cards and new ArrayedList of players
		super();
		
		this.requiredNumberOfPlayers = 2;
		this.chatArea = new JTextArea("");
	}
	
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


