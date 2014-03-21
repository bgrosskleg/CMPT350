package controller;

import javax.swing.JOptionPane;

import view.WarCardGameServerView;
import model.GenericCardGameCard;
import model.GenericCardGameCardList;
import model.GenericCardGameModel;
import model.GenericCardGamePlayer;
import model.WarCardGameModel;
import model.WarCardGamePlayer;

/**
 * a generic game controller class that provides simple functions that all card
 * games will implement 
 *
 */
public class WarCardGameServerController extends WarCardGameGeneralController
{	
	public WarCardGameServerController(WarCardGameModel model, WarCardGameServerView view) 
	{
		super(model, view);
	}

	public void initializeGame() 
	{
		initializeDeck(1);

		System.out.println("WAITING FOR ENOUGH PLAYERS");

		while(((WarCardGameModel)this.model).getPlayers().size() < ((WarCardGameModel)this.model).requiredNumberOfPlayers)
		{
			/*WAIT FOR PLAYERS CONNECTION*/
			try 
			{
				Thread.sleep(50);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("ENOUGH PLAYERS FOUND");

		//Deal cards
		dealCards();

		//Wait for players action
		//evaluateHand();
	}

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
		}
		
		model.notifyModelSubscribers();

	}

	public void dealCards()
	{
		synchronized(this.model)
		{
			while(((WarCardGameModel)this.model).getDeck().size() > 0)
			{
				for(GenericCardGamePlayer player : ((WarCardGameModel)this.model).getPlayers())
				{
					if(((WarCardGameModel)this.model).getDeck().size() > 0)
						player.getHand().add(((WarCardGameModel)this.model).getDeck().remove(0));
				}
			}	
		}
		
		//Send all players their card
		((WarCardGameModel)this.model).notifyModelSubscribers();
	}

	public void gameOver(int winner) 
	{
		// TODO Auto-generated method stub
		//custom title, no icon
		JOptionPane.showMessageDialog(null,
				"Player " + winner+1 + " wins!",
				"Game Over",
				JOptionPane.PLAIN_MESSAGE);
		this.initializeGame();
	}

	public void evaluateHand() 
	{
		//Finds the player with the highest card and places cards accordingly
		//Doesn't handle wars yet
		int winningPlayer = -1;
		int highestCard = -1;
		for(int i = 0; i < ((WarCardGameModel)this.model).getPlayers().size();i++)
		{
			while(((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).cardPlayed == null)
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
			if(((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).cardPlayed.getValue().ordinal() > highestCard)
			{
				highestCard = ((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).cardPlayed.getValue().ordinal();
				winningPlayer = i;
			}
		}
		//Send model for players to view
		((WarCardGameModel)this.model).notifyModelSubscribers();
		//Now we will put the cards in the appropriate places
		for(int i = 0; i < ((WarCardGameModel)this.model).getPlayers().size();i++)
		{
			((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(winningPlayer)).winPile.add(((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).cardPlayed);
			((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).cardPlayed = null;
		}
		//Get ready for new hand
		//Check for empty hands, then see if game is over
		//or winpile needs to be shuffled and added to hand
		for(int i = 0; i < ((WarCardGameModel)this.model).getPlayers().size();i++)
		{
			if(((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).getHand().isEmpty())
			{
				if(((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).winPile.isEmpty())
				{
					this.gameOver(winningPlayer);
				}
				else
				{
					((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).winPile.shuffle();
					while(!((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).winPile.isEmpty())
						((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).getHand().add(((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i)).winPile.remove(0));
				}
			}
		}

		//Notify subscribers and get ready for next hand
		((WarCardGameModel)this.model).notifyModelSubscribers();

		evaluateHand();
	}
}
