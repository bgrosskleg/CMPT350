package model;

public class WarGameModel extends GenericGameModel
{
	public WarGameModel()
	{
		super();
		
		this.initializeCards(1);
		
		//Create Players
		players.add(new Player("Player 1"));
		players.add(new Player("Player 2"));
	}
}
/*
 * HEY PAUL IT WORKS
 */

