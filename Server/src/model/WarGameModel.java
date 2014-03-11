package model;

import model.Player.Dest;

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
	protected void dealCards() 
	{
		while(!cards.isEmpty())
		{
			for(int i = 0; i < players.size() && !cards.isEmpty(); i++)
			{
				sendCard(cards.remove(0), players.get(i), Dest.HAND);
			}
		}
	}

	@Override
	protected void evalHand() {
		/*
		 *receive a card from each player, and send them to the winner 
		 */
		//CardList currentRound = new CardList();
		//Card temp;
		for(int i = 0; i < players.size(); i++)
		{
			/*
			 * receive cards somehow, and put them in currentRound
			 */
		}
		
	}

	@Override
	protected void gameOver() {
		// TODO Auto-generated method stub

	}
}


