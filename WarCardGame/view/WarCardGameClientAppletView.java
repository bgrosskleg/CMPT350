package view;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

import controller.WarCardGameClientAppletSocketWorker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	private boolean intialized;
	
	private JTextArea chatDisplayBox;
	private JScrollPane scrollingChat;
	
	/**
	 * sets newGame to true and prepares to initialize a game in the applet
	 * 
	 * @param model the model to be looked at
	 * @param playerNumber the number of players connected to the server
	 */
	public WarCardGameClientAppletView(WarCardGameModel model, WarCardGameClientAppletSocketWorker socketWorker) 
	{
		super(model, socketWorker);
		this.newGame = true;
		this.intialized = false;
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
				intialized = false;
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
			this.removeOnlyCards();

			//Green pepper from http://www.december.com/html/spec/color2.html
			this.setBackground(new Color(0x39, 0x7D, 0x02));

			//Build panel to display game
			createWarCardGameBoardView();
			
			if(this.socketWorker.getConnectionNumber() == 1)
			{
				this.p1ChatEnterText.requestFocus();
			}
				
			else if(this.socketWorker.getConnectionNumber() == 2)
			{
				this.p2ChatEnterText.requestFocus();
			}
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
	
	private JTextField p1ChatEnterText;
	private JTextField p2ChatEnterText;

	private void removeOnlyCards()
	{
		ArrayList<Component> compList = new ArrayList<Component>();
		for(int i = 0; i < this.getComponentCount(); i++)
		{
			Component c = this.getComponent(i);
			if(c instanceof JTextField || c instanceof JTextArea || c instanceof JButton || c instanceof JScrollPane)
			{
				//Do nothing
			}
			else
			{
				compList.add(c);
			}
		}
		while(!compList.isEmpty())
		{
			this.remove(compList.remove(0));
		}
	}

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
		 * 		|_______|_______|_______|		chat
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

		
		//BUTTONS
		JButton p1flip = null;
		JButton p2flip = null;
		JButton p1Send = null;
		JButton p2Send = null;
				
		//CARD FLIPPING
		if(!this.intialized)
		{
			gbc.fill = GridBagConstraints.NONE;
			
			if(this.socketWorker.getConnectionNumber() == 1)
			{
				p1flip = new JButton("Player 1 Flip!");
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
							
				gbc.gridx = 1;
				gbc.gridy = 3;
				this.add(p1flip, gbc);
				
			}
			
			if(this.socketWorker.getConnectionNumber() == 2)
			{
				p2flip = new JButton("Player 2 Flip!");
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
				
				if(this.socketWorker.getConnectionNumber() == 2)
				{ 
					gbc.gridx = 1;
					gbc.gridy = 0;
					this.add(p2flip, gbc);
				}
			}
			
		
			//CHAT AREA
			
			final int chatWidth = 300;
			final int chatHeight = 400;
			final int textfieldHeight = 30;
			
			
			chatDisplayBox = ((WarCardGameModel)model).chatArea;
			chatDisplayBox.setEditable(false);
			chatDisplayBox.setCursor(null);
			chatDisplayBox.setOpaque(true);
			chatDisplayBox.setFocusable(false);
			chatDisplayBox.setLineWrap(true);
			chatDisplayBox.setWrapStyleWord(true);
			
			DefaultCaret caret1 = (DefaultCaret) ((WarCardGameModel)model).chatArea.getCaret();
			caret1.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			
			scrollingChat = new JScrollPane(chatDisplayBox);
		
			//Box for chat
			scrollingChat.setPreferredSize(new Dimension(chatWidth, chatHeight));
			scrollingChat.setMinimumSize(getPreferredSize());
			gbc.gridx = 3;
			gbc.gridy = 1;
			this.add(scrollingChat, gbc);
		
			
			//CHAT FIELDS AND BUTTONS
			
			if(this.socketWorker.getConnectionNumber() == 1)
			{
				p1ChatEnterText = new JTextField("");
				p1ChatEnterText.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						synchronized(model)
						{
							if(!p1ChatEnterText.getText().isEmpty())
							{
								chatDisplayBox.append("\nPlayer 1: " +	p1ChatEnterText.getText());
								p1ChatEnterText.setText("");
	
								model.notifyModelSubscribers();
							}
						}
					}
				});
				
				p1Send = new JButton("Send Chat");
				p1Send.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						synchronized(model)
						{
							if(!p1ChatEnterText.getText().isEmpty())
							{
								chatDisplayBox.append("\nPlayer 1: " + p1ChatEnterText.getText());
								p1ChatEnterText.setText("");

								model.notifyModelSubscribers();
							}
						}
					}
				});
				
				//Create player 1 chat buttons
				p1ChatEnterText.setPreferredSize(new Dimension(chatWidth, textfieldHeight));
				p1ChatEnterText.setMinimumSize(getPreferredSize());
				gbc.gridx = 3;
				gbc.gridy = 2;
				this.add(p1ChatEnterText, gbc);
					
				gbc.gridx = 3;
				gbc.gridy = 3;
				this.add(p1Send, gbc);
			}
			
			if(this.socketWorker.getConnectionNumber() == 2)
			{
				p2ChatEnterText = new JTextField("");
				p2ChatEnterText.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						synchronized(model)
						{
							if(!p2ChatEnterText.getText().isEmpty())
							{
								chatDisplayBox.append("\nPlayer 2: " + p2ChatEnterText.getText());
								p2ChatEnterText.setText("");
	
								model.notifyModelSubscribers();
							}
						}
					}
				});
				
				p2Send = new JButton("Send Chat");
				p2Send.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						synchronized(model)
						{
							if(!p2ChatEnterText.getText().isEmpty())
							{
								chatDisplayBox.append("\nPlayer 2: " + p2ChatEnterText.getText());
								p2ChatEnterText.setText("");

								model.notifyModelSubscribers();
							}
						}
					}
				});
								
				//Create player 2 chat buttons
				p2ChatEnterText.setPreferredSize(new Dimension(chatWidth, textfieldHeight));
				p2ChatEnterText.setMinimumSize(getPreferredSize());
				p2ChatEnterText.setMaximumSize(getPreferredSize());
				gbc.gridx = 3;
				gbc.gridy = 2;
				this.add(p2ChatEnterText, gbc);
									
				gbc.gridx = 3;
				gbc.gridy = 3;
				this.add(p2Send, gbc);
			}
			
			this.intialized = true;
		}
		
		gbc.fill= GridBagConstraints.BOTH;
		
		chatDisplayBox.setText(((WarCardGameModel)model).chatArea.getText());
		scrollingChat.getVerticalScrollBar().setValue(scrollingChat.getVerticalScrollBar().getMaximum());

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

		this.setOpaque(true);	
	}
}
