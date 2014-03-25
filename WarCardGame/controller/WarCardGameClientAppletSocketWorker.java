package controller;

import java.io.IOException;
import java.net.Socket;

import model.GenericMVCModel;
import model.WarCardGameModel;
import model.WarCardGamePlayer;

public class WarCardGameClientAppletSocketWorker extends GenericCardGameSocketWorker
{	
	public WarCardGameClientAppletSocketWorker(Socket socket, WarCardGameModel model)
	{
		super(socket, model , -1);
		
		try 
		{
			this.connectionNumber = ((int) this.recieveObject());
			System.out.println("I AM PLAYER " + this.connectionNumber);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run() 
	{
		//Wait for object on stream
		while(true)
		{
			Object object = null;
			
			try 
			{
				object = this.recieveObject();
			}
			catch (Exception e) 
			{
				System.err.println("SOCKET ERROR - CLOSING CONNECTION");
				//TODO close connection and delete player
				e.printStackTrace();
			}
			
			if(object instanceof WarCardGameModel)
			{
				System.out.println("OLD MODEL: \n" + this.model.toString());
				
				//Update local model with received model, NOTE updateModel does NOT call notifySubscribers!
				synchronized(this.model)
				{
					updateModel((WarCardGameModel)object);
					
					//Notify everyone but this socket worker
					this.model.removeModelSubscriber(this);
					this.model.notifyModelSubscribers();
					this.model.addModelSubscriber(this);
				}
				
				System.out.println("NEW MODEL: \n" + this.model.toString());
			}
			else
			{
				System.err.println("Recieved object not type WarCardGameModel!");
			}
		}
	}

	@Override
	public void modelChanged() 
	{
		//Transmit model to other side
		synchronized(this.model)
		{
			try 
			{
				this.sendObject(model);
			}
			catch (IOException e) 
			{
				System.err.println("SOCKET ERROR - CLOSING CONNECTION");
				//TODO close connection and delete player
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void updateModel(GenericMVCModel newModel)
	{
		System.out.println("WarCardGameGeneralWorker: UpdateModel");
	
		// Compare interesting parts of the model and update local model
		
		if(((WarCardGameModel)this.model).getPlayers().size() != ((WarCardGameModel)newModel).getPlayers().size())
		{
			((WarCardGameModel)this.model).getPlayers().clear();
			while(!((WarCardGameModel)newModel).getPlayers().isEmpty())
			{
				((WarCardGameModel)this.model).getPlayers().add(((WarCardGameModel)newModel).getPlayers().remove(0));
			}
		}
		else
		{
			for(int i = 0; i < ((WarCardGameModel)this.model).getPlayers().size(); i++)
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
				}
				
				if(!player.flipDeck.equals(newPlayer.flipDeck))
				{
					player.flipDeck.clear();
					while(!newPlayer.flipDeck.isEmpty())
					{
						player.flipDeck.add(newPlayer.flipDeck.remove(0));
					}
				}
				
				if(player.cardPlayed != newPlayer.cardPlayed)
				{
					player.cardPlayed = newPlayer.cardPlayed;
				}
			}
		}
	}
}
