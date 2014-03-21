package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.WarCardGameModel;
import model.WarCardGamePlayer;

public class WarCardGameBoardView extends JPanel
{
	private static final long serialVersionUID = 1L;

	public WarCardGameBoardView(WarCardGameModel model)
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
    	JPanel p1Deck = new GenericCardGameCardListView(((WarCardGamePlayer)model.getPlayers().get(0)).flipDeck);
    	JPanel p2Deck = new GenericCardGameCardListView(((WarCardGamePlayer)model.getPlayers().get(1)).flipDeck);
    	JPanel p1Winpile = new GenericCardGameCardListView(((WarCardGamePlayer)model.getPlayers().get(0)).winPile);
    	JPanel p2Winpile = new GenericCardGameCardListView(((WarCardGamePlayer)model.getPlayers().get(1)).winPile);
    	JPanel p1Card = ((WarCardGamePlayer)model.getPlayers().get(0)).cardPlayed;
    	JPanel p2Card = ((WarCardGamePlayer)model.getPlayers().get(1)).cardPlayed;
        
    	
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
        
        this.setOpaque(false);
	}
}
