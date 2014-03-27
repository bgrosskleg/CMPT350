package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.WarCardGameModel;
import model.WarCardGamePlayer;

/**
 *	contains:
 *
 *	public methods:
 *	WarCardGameClientAppletView(WarCardGameModel, final int)
 *	modelChanged()
 *	
 *	protected methods:
 *	buildPanel()
 */
public class WarCardGameClientAppletView extends GenericCardGameView
{
	private static final long serialVersionUID = 1L;

	private boolean newGame;
	
	/**
	 * sets newGame to true and prepares to initialize a game in the applet
	 * 
	 * @param model the model to be looked at
	 * @param playerNumber the number of players connected to the server
	 */
	public WarCardGameClientAppletView(WarCardGameModel model, final int playerNumber) 
	{
		super(model, playerNumber);
		this.newGame = true;
	}

	/**
	 * builds the GridBagLayout, sets the default window size, waits for players to connect
	 */
	@Override
	protected void buildPanel() 
	{			
		this.setLayout(new GridBagLayout());

		this.setPreferredSize(new Dimension(1000,1000));
		this.setMaximumSize(getPreferredSize());
		this.setMinimumSize(getPreferredSize());

		this.setBackground(Color.YELLOW);

		this.playerStatus = new JLabel("Waiting for " + (((WarCardGameModel)this.model).getRequiredNumberOfPlayers() - ((WarCardGameModel)model).getPlayers().size()) + " more players...");
		this.add(playerStatus);
	}

	/**
	 * updates the model view to the current state
	 * 
	 * if a player exits display win screen for remaining player
	 * @throws exception if too many players connect at the same times exceeding maximum allowed connections 
	 */
	@Override
	public void modelChanged() 
	{	
		if(((WarCardGameModel) model).getPlayers().size() < ((WarCardGameModel) model).getRequiredNumberOfPlayers())
		{
			if(!newGame)
			{
				JOptionPane.showMessageDialog(null, "YOU WIN! Other player left or connection lost.");
				newGame = true;
			}
			
			//REMAKE THE VIEW TO WAIT FOR PLAYERS
			this.removeAll();

			this.setBackground(Color.YELLOW);

			this.playerStatus = new JLabel("Waiting for " + (((WarCardGameModel)this.model).getRequiredNumberOfPlayers() - ((WarCardGameModel)model).getPlayers().size()) + " more players...");
			this.add(playerStatus);
		}
		else if(((WarCardGameModel) model).getPlayers().size() == ((WarCardGameModel) model).getRequiredNumberOfPlayers())
		{
			newGame = false;
			
			//REMAKE THE VIEW TO DISPLAY GAME
			this.removeAll();

			//Green pepper from http://www.december.com/html/spec/color2.html
			this.setBackground(new Color(0x39, 0x7D, 0x02));

			//Build panel to display game
			createWarCardGameBoardView();
		}
		else
		{
			new Exception("Impossible state, more players than required").printStackTrace();
		}

		this.revalidate();
		this.repaint();
	}

	private GenericCardGameCardListView p1Deck;
	private GenericCardGameCardListView p2Deck;
	private GenericCardGameCardListView p1Winpile;
	private GenericCardGameCardListView p2Winpile;

	/**
	 * creates the GameBoardView that the player sees on their screen
	 * <p>
	 * <li>creates the layout for where the players decks and cards go
	 * <li>keeps track of, and displays, the amount of cards in each deck
	 * <li>initializes the chat box
	 * <li>synchronizes separate players views so that everyone is viewing the same thing in real time
	 */
	private void createWarCardGameBoardView() 
	{
		/*
		 * 			x0		x1		x2
		 * 	 	_______________________
		 * 		|p2		|		|p2		|
		 *y0	|deck	|		|winpile|
		 * 		|		|		|		|
		 * 		|_______|_______|_______|
		 * 		|		|p2		|		|
		 *y1	|		|card	|		|
		 * 		|		|played	|		|
		 * 		|_______|_______|_______|
		 * 		|		|p1		|		|
		 *y2 	|		|card	|		|
		 * 		|		|played	|		|
		 * 		|_______|_______|_______|
		 * 		|p1		|		|p1		|
		 *y3 	|deck	|		|winpile|
		 *	 	|		|		|		|
		 *	 	|_______|_______|_______|
		 */


		// We create a JPanel with the GridLayout.
		//this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setPreferredSize(new Dimension(400,400));
		this.setMaximumSize(getPreferredSize());
		this.setMinimumSize(getPreferredSize());
		gbc.fill= GridBagConstraints.BOTH;
		gbc.weightx = 0.33;
		gbc.weighty = 0.25;

		//TODO  Make all the approriate fields in the player object
		p1Deck = new GenericCardGameCardListView(((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(0)).flipDeck);
		p2Deck = new GenericCardGameCardListView(((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(1)).flipDeck);
		p1Winpile = new GenericCardGameCardListView(((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(0)).winPile);
		p2Winpile = new GenericCardGameCardListView(((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(1)).winPile);

		JButton p1flip = new JButton("Player 1 Flip!");
		JButton p2flip = new JButton("Player 2 Flip!");


		final JTextArea chatDisplayBox = ((WarCardGameModel)model).chatArea;
		chatDisplayBox.setEditable(false);
		chatDisplayBox.setCursor(null);
		chatDisplayBox.setOpaque(true);
		chatDisplayBox.setFocusable(false);
		chatDisplayBox.setLineWrap(true);
		chatDisplayBox.setWrapStyleWord(true);
		
		final JScrollPane scrollingChat = new JScrollPane(chatDisplayBox);
		scrollingChat.setPreferredSize(new Dimension(200,100));

		final JTextField p1ChatEnterText = new JTextField("");
		final JTextField p2ChatEnterText = new JTextField("");

		JButton p1Send = new JButton("Send Chat");
		JButton p2Send = new JButton("Send Chat");

		p1flip.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Remove top card from flip deck and make it the played card
				synchronized(model)
				{
					if(((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(0)).cardPlayed == null)
					{
						((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(0)).cardPlayed = ((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(0)).flipDeck.remove(0);

						model.notifyModelSubscribers();
					}
				}
			}

		});

		p2flip.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Remove top card from flip deck and make it the played card
				synchronized(model)
				{
					if(((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(1)).cardPlayed == null)
					{
						((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(1)).cardPlayed = ((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(1)).flipDeck.remove(0);

						model.notifyModelSubscribers();
					}
				}
			}
		});

		p1Send.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				synchronized(model)
				{
					if(!p1ChatEnterText.getText().isEmpty())
					{
						chatDisplayBox.append(
								"\nPlayer 1: " +
										p1ChatEnterText.getText());
						p1ChatEnterText.setText("");


						model.notifyModelSubscribers();
					}
				}
			}
		});
		
		p2Send.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				synchronized(model)
				{
					if(!p2ChatEnterText.getText().isEmpty())
					{
						chatDisplayBox.append(
								"\nPlayer 2: " +
										p2ChatEnterText.getText());
						p2ChatEnterText.setText("");


						model.notifyModelSubscribers();
					}
				}
			}
		});



		gbc.ipady=50;
		gbc.gridx=0;
		gbc.gridy=0;
		this.add(p2Deck, gbc);

		gbc.gridx=2;
		gbc.gridy=0;
		this.add(p2Winpile, gbc);

		if(((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(1)).cardPlayed == null)
		{
			gbc.gridx=1;
			gbc.gridy=1;
			add(new JLabel("No Card Played"), gbc);
		}
		else
		{
			gbc.gridx=1;
			gbc.gridy=1;
			((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(1)).cardPlayed.faceUp();
			this.add(((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(1)).cardPlayed, gbc);
		}

		if(((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(0)).cardPlayed == null)
		{
			gbc.gridx=1;
			gbc.gridy=2;
			add(new JLabel("No Card Played"), gbc);
		}
		else
		{
			gbc.gridx=1;
			gbc.gridy=2;
			((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(0)).cardPlayed.faceUp();
			this.add(((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(0)).cardPlayed, gbc);
		}

		gbc.gridx=0;
		gbc.gridy=3;
		this.add(p1Deck, gbc);

		gbc.gridx=2;
		gbc.gridy=3;
		this.add(p1Winpile, gbc);


		//Box for chat
		gbc.gridx = 3;
		gbc.gridy = 1;
		this.add(scrollingChat, gbc);

		gbc.fill = GridBagConstraints.NONE;

		if(this.playerNumber == 2)
		{ 
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.add(p2flip, gbc);

			//Chat Stuff
			p2ChatEnterText.setPreferredSize(new Dimension(200, 5));
			gbc.gridx = 3;
			gbc.gridy = 2;
			this.add(p2ChatEnterText, gbc);

			gbc.gridx = 3;
			gbc.gridy = 3;
			this.add(p2Send, gbc);

		}

		if(this.playerNumber == 1)
		{
			gbc.gridx = 1;
			gbc.gridy = 3;
			this.add(p1flip, gbc);

			//Chat Stuff
			p1ChatEnterText.setPreferredSize(new Dimension(200, 5));
			gbc.gridx = 3;
			gbc.gridy = 2;
			this.add(p1ChatEnterText, gbc);

			gbc.gridx = 3;
			gbc.gridy = 3;
			this.add(p1Send, gbc);
		}

		this.setOpaque(true);	
	}
}
