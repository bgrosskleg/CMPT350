package controller;

import java.io.IOException;

import view.WarCardGameServerView;
import model.GenericCardGameCard;
import model.GenericCardGameCardList;
import model.GenericCardGameModel;
import model.GenericCardGamePlayer;
import model.WarCardGameModel;
import model.WarCardGamePlayer;

/**
 * contains:
 * 
 *  public methods:
 *  WarCardGameServerController(WarCardGameModel, WarCardGameServerView)
 *  initializeGame()
 *	initializeDeck(int)
 *	initializePlayers()
 *	dealCards()
 *	gameOver(int)
 *	evaluateHand()
 *
 */
public class WarCardGameServerController extends GenericCardGameController
{	
	/**
	 * gets the model and the view
	 * 
	 * @param model the current model
	 * @param view the current view
	 */
	public WarCardGameServerController(WarCardGameModel model, WarCardGameServerView view) 
	{
		super(model, view);
	}

	/**
	 * waits for enough players, when enough players are found:
	 * <p>
	 * <li>initializes the deck
	 * <li>initializes the players
	 * <li>deals the cards
	 * <li>evaluates the players hands
	 */
	public void initializeGame() 
	{
		

		System.out.println("WAITING FOR ENOUGH PLAYERS");

		while(true)
		{
			while(((WarCardGameModel)this.model).getPlayers().size() < ((WarCardGameModel)this.model).getRequiredNumberOfPlayers())
			{
				/*WAIT FOR PLAYERS CONNECTION*/
				try 
				{
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
			System.out.println("ENOUGH PLAYERS FOUND");
	
			//Clear the chat area
			((WarCardGameModel) this.model).chatArea.setText("");
			
			//Initialize deck
			initializeDeck(1);
			
			//Initialize players
			initializePlayers();
			
			//Deal cards
			dealCards();
	
			//Wait for players action
			try 
			{
				evaluateHand();
			} 
			catch (Exception e) 
			{
				System.out.println("PLAYER LEFT GAME");
			}
		}
	}

	/**
	 * sets up the number of decks and cards to be used
	 * 
	 * some War games may have more than one deck if the users wish.
	 * 
	 * @param numOfDecks number of decks to be initialized
	 */
	public void initializeDeck(int numOfDecks)
	{
		synchronized(this.model)
		{
			((GenericCardGameModel)model).setDeck(new GenericCardGameCardList());
	
			for(int iter = numOfDecks; iter >= 1; iter--)
			{
				for(GenericCardGameCard.Suit suit : GenericCardGameCard.Suit.values())
				{
					for(GenericCardGameCard.Value value: GenericCardGameCard.Value.values())
					{
						((GenericCardGameModel)model).getDeck().add(new GenericCardGameCard(value, suit));
					}
				}
			}
	
			((GenericCardGameModel)model).getDeck().shuffle();
		
			//Notify subscribers is called imediately after initializing in dealCards()
			//model.notifyModelSubscribers();
		}

	}
	
	/**
	 * give a player a deck, a winpile, and a cardplayed
	 */
	public void initializePlayers()
	{
		for(int iter = 0 ; iter < ((WarCardGameModel)this.model).getPlayers().size(); iter++)
		{
			((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(iter)).flipDeck = new GenericCardGameCardList();
			((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(iter)).winPile = new GenericCardGameCardList();
			((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(iter)).cardPlayed = null;
			
			//Do not reset socket worker to keep remaining players connection intact,
			//but re-assign their connectionNumber ie player number
			((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(iter)).getSocketWorker().connectionNumber = iter + 1;
			try 
			{
				((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(iter)).playerNumber = iter + 1;
				((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(iter)).getSocketWorker().sendObject(iter + 1);
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				System.err.println("Failure re-assigning player numbers");
				//e.printStackTrace();
			}
		}
	}

	/**
	 * deal the cards between however many players are currently in the game
	 */
	public void dealCards()
	{
		synchronized(this.model)
		{
			while(((WarCardGameModel)this.model).getDeck().size() > 0)
			{
				for(GenericCardGamePlayer player : ((WarCardGameModel)this.model).getPlayers())
				{
					if(((WarCardGameModel)this.model).getDeck().size() > 0)
						((WarCardGamePlayer)player).flipDeck.add(((WarCardGameModel)this.model).getDeck().remove(0));
				}
			}	
		
		
			//Send all players their card
			model.notifyModelSubscribers();
		}
	}

	/**
	 * sends a popup box to both players informing them of the winner and reinitializes the game
	 * @param winner the player who has valiantly won the game
	 */
	public void gameOver(int winner) 
	{
		//This pop-ups on the server window not the client applets, commented out so no server-side interaction required
		
		//custom title, no icon
		//JOptionPane.showMessageDialog(null,
		//		"Player " + winner+1 + " wins!",
		//		"Game Over",
		//		JOptionPane.PLAIN_MESSAGE);
		//this.initializeGame();
	}

	/**
	 * evaluates the players hands and moves cards to the appropriate decks 
	 * @throws Exception general exception that will print out the StackTrace
	 */
	public void evaluateHand() throws Exception 
	{ 
		//Finds the player with the highest card and places cards accordingly
		//Doesn't handle wars yet
		int winningPlayer = -1;
		int highestCard = -1;
		for(int i = 0; i < ((WarCardGameModel)this.model).getPlayers().size();i++)
		{
			while(((WarCardGameModel)this.model).getPlayers().size() == ((WarCardGameModel)this.model).getRequiredNumberOfPlayers() &&
					 ((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).cardPlayed == null)
			{
				try 
				{
					Thread.sleep(20);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			
			if(((WarCardGameModel)this.model).getPlayers().size() < ((WarCardGameModel)this.model).getRequiredNumberOfPlayers())
			{
				throw new Exception("Not enough players");
			}
			
			if(((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).cardPlayed.getValue().ordinal() > highestCard)
			{
				highestCard = ((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).cardPlayed.getValue().ordinal();
				winningPlayer = i;
			}
		}
		//Send model for players to view
		((WarCardGameModel)this.model).notifyModelSubscribers();
		
		//Delay for the users to see the outcome of the hand
		Thread.sleep(2000);
		
		//Now we will put the cards in the appropriate places
		for(int i = 0; i < ((WarCardGameModel)this.model).getPlayers().size();i++)
		{
			((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(winningPlayer)).winPile.add(0, (((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).cardPlayed));
			((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).cardPlayed = null;
		}
		//Get ready for new hand
		//Check for empty hands, then see if game is over
		//or winpile needs to be shuffled and added to hand
		for(int i = 0; i < ((WarCardGameModel)this.model).getPlayers().size();i++)
		{
			if(((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).flipDeck.isEmpty())
			{
				if(((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).winPile.isEmpty())
				{
					this.gameOver(winningPlayer);
				}
				else
				{
					((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).winPile.shuffle();
					((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).winPile.faceDown();
					
					while(!((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).winPile.isEmpty())
						((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).flipDeck.add(((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).winPile.remove(0));
				}
			}
		}

		//Notify subscribers and get ready for next hand
		((WarCardGameModel)this.model).notifyModelSubscribers();

		evaluateHand();
	}
}
