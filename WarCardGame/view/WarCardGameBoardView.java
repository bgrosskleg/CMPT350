package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import model.GenericCardGameCard;
import model.WarCardGameModel;
import model.WarCardGamePlayer;

public class WarCardGameBoardView extends GenericCardGameView
{
	private static final long serialVersionUID = 1L;
		
	private GenericCardGameCardListView p1Deck;
	private GenericCardGameCardListView p2Deck;
	private GenericCardGameCardListView p1Winpile;
	private GenericCardGameCardListView p2Winpile;
	private GenericCardGameCard p1Card;
	private GenericCardGameCard p2Card;

	public WarCardGameBoardView(WarCardGameModel model, int playerNumber)
	{
		super(model, playerNumber);
		this.state = GenericCardGameView.State.READY;
	}

	@Override
	public void modelChanged() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void buildPanel() 
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
        this.setLayout(new GridBagLayout());
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
        p1Card = ((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(0)).cardPlayed;
        p2Card = ((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(1)).cardPlayed;
        
    	JButton p1flip = new JButton("Player 1 Flip!");
    	JButton p2flip = new JButton("Player 2 Flip!");
    	
    	p1flip.addActionListener(new ActionListener()
    	{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Remove top card from flip deck and make it the played card
				synchronized(model)
				{
					//p1Card = ((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(0)).flipDeck.remove(0);
				
					//model.notifyModelSubscribers();
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
					//p2Card = ((WarCardGamePlayer)((WarCardGameModel)model).getPlayers().get(1)).flipDeck.remove(0);
				
					//model.notifyModelSubscribers();
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
    	
        if(p2Card != null)
        {
        gbc.gridx=1;
        gbc.gridy=1;
        this.add(p2Card, gbc);
        }
    	
        if(p1Card != null)
        {
        gbc.gridx=1;
        gbc.gridy=2;
        this.add(p1Card, gbc);
        }
    	
        gbc.gridx=0;
        gbc.gridy=3;
        this.add(p1Deck, gbc);
        
        gbc.gridx=2;
        gbc.gridy=3;
        this.add(p1Winpile, gbc);
        
        gbc.fill = GridBagConstraints.NONE;
        
        if(this.playerNumber == 2)
        { 
        	gbc.gridx = 1;
	        gbc.gridy = 0;
	        this.add(p2flip, gbc);
        }
        
        if(this.playerNumber == 1)
        {
        	gbc.gridx = 1;
        	gbc.gridy = 3;
        	this.add(p1flip, gbc);
        }
        
        this.setOpaque(false);
	}
}
