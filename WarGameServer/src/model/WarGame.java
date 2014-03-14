package model;

public class WarGame extends GenericGame
{	
	public WarGame()
	{
		//calls the constructor of the GenericGame
		//creates new CardList of cards and new ArrayedList of players
		super();

		//initialize 1 deck of cards
		this.initializeDeck(1);
		this.deck.shuffle();
		
		//Start thread that waits for players
		
	}

	@Override
	protected void dealCards() 
	{
		this.deck.shuffle();
		
		//Populate each players hand
		while(!deck.isEmpty())
		{
			for(int i = 0; i < players.size() && !deck.isEmpty(); i++)
			{
				players.get(i).getHand().add(deck.remove(0));
			}
		}
		
		//Send players their cardList
		
	}

	@Override
	protected void evalHand() 
	{
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
	protected void gameOver()
	{
		// TODO Auto-generated method stub

	}
}


