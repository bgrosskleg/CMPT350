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

	@Override
	protected void dealCards() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void evalHand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void gameOver() {
		// TODO Auto-generated method stub
		
	}
}
/*
 * HEY PAUL IT WORKS
 */

