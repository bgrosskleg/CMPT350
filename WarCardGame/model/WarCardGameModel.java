package model;

public class WarCardGameModel extends GenericCardGameModel
{	
	private static final long serialVersionUID = 1L;

	public final int requiredNumberOfPlayers = 4;
	
	public WarCardGameModel()
	{
		//calls the constructor of the GenericGameModel
		//creates new CardList of cards and new ArrayedList of players
		super();
	}
}


