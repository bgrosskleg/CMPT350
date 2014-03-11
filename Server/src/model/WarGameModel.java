package model;

public class WarGameModel extends GenericGameModel
{
	public WarGameModel()
	{
		//calls the constructor of the GenericGameModel
		//creates new CardList of cards and new ArrayedList of players
		super();
		
		//initialize 1 deck of cards
		this.initializeCards(1);
		
		//Create Players
		players.add(new Player("Player 1"));
		players.add(new Player("Player 2"));
	}
}
/*
 * HEY PAUL IT WORKS
 */

