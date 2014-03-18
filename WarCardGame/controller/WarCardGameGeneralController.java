package controller;

import view.GenericCardGameView;
import model.GenericCardGameModel;
import model.GenericMVCModel;
import model.WarCardGameModel;
import model.WarCardGamePlayer;

/**
 * a generic game controller class that provides simple functions that all card
 * games will implement 
 *
 */
public abstract class WarCardGameGeneralController extends GenericCardGameController
{	

	protected WarCardGameGeneralController(GenericCardGameModel model,
			GenericCardGameView view) {
		super(model, view);
	}

	@Override
	protected void updateModel(GenericMVCModel newModel)
	{
		// Compare interesting parts of the model and update
		boolean hasChanged = false;

		for(int i = 0; i < ((WarCardGameModel)this.model).getPlayers().size();i++)
		{
			WarCardGamePlayer player = ((WarCardGamePlayer)((WarCardGameModel)this.model).getPlayers().get(i));
			WarCardGamePlayer newPlayer = ((WarCardGamePlayer)((WarCardGameModel)newModel).getPlayers().get(i));
			if(!player.winPile.equals(newPlayer.winPile))
			{
				player.winPile.clear();
				while(!newPlayer.winPile.isEmpty())
				{
					player.winPile.add(newPlayer.winPile.remove(0));
				}
				hasChanged = true;
			}
			if(!player.getHand().equals(newPlayer.getHand()))
			{
				player.getHand().clear();
				while(!newPlayer.getHand().isEmpty())
				{
					player.getHand().add(newPlayer.getHand().remove(0));
				}
				hasChanged = true;
			}
			if(player.cardPlayed.getValue().ordinal() != newPlayer.cardPlayed.getValue().ordinal()
					|| player.cardPlayed.getSuit() != newPlayer.cardPlayed.getSuit())
			{
				player.cardPlayed = newPlayer.cardPlayed;
				hasChanged = true;
			}
			//If changed were made, notify subscribers
			if(hasChanged)
			{
				this.model.notifyModelSubscribers();
			}
		}
	}
}
