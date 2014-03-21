package model;

public class WarCardGameModel extends GenericCardGameModel
{	
	private static final long serialVersionUID = 1L;

	public final int requiredNumberOfPlayers = 2;
	
	public WarCardGameModel()
	{
		//calls the constructor of the GenericGameModel
		//creates new CardList of cards and new ArrayedList of players
		super();
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
			result += ("PLAYER " + this.players.indexOf(player) + "\n");
			result += (player.toString() + "\n");
		}
		
		return result;
	}
}


