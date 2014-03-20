package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.WarCardGameModel;

public class WarCardGameServerView extends GenericCardGameView
{
	private static final long serialVersionUID = 1L;
	
	private JLabel playerStatus;

	public WarCardGameServerView(WarCardGameModel model)
	{
		super(model);
	}

	@Override
	protected void buildPanel() 
	{	
		this.setBackground(Color.RED);
		this.setPreferredSize(new Dimension(500,500));
		this.setMaximumSize(getPreferredSize());
		this.setMinimumSize(getPreferredSize());
		
		playerStatus = new JLabel("Waiting for " + (((WarCardGameModel)this.model).requiredNumberOfPlayers-((WarCardGameModel)model).getPlayers().size()) + " more players...");
		this.add(playerStatus);
	}

	@Override
	public void modelChanged() 
	{
		if(((WarCardGameModel)model).getPlayers().size() < ((WarCardGameModel)this.model).requiredNumberOfPlayers)
		{
			//Display waiting text
			playerStatus.setText("Waiting for " + (((WarCardGameModel)this.model).requiredNumberOfPlayers-((WarCardGameModel)model).getPlayers().size()) + " more players...");
		}
		else
		{
			//Display card game
			this.removeAll();
			
			this.setBackground(Color.GREEN);
			
			//Add board game view
			this.add(new WarCardGameBoardView((WarCardGameModel)this.model));
			
			this.revalidate();
		}
	}
	
	
	private class WarCardGameBoardView extends JPanel
	{
		private static final long serialVersionUID = 1L;

		private WarCardGameBoardView(WarCardGameModel model)
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
	        
	       /* //TODO  Make all the approriate fields in the player object
	    	JPanel p1Deck = new GenericCardGameCardListView(((WarCardGamePlayer)model.getPlayers().get(1)).deck);
	    	JPanel p2Deck = new GenericCardGameCardListView(((WarCardGamePlayer)model.getPlayers().get(2)).deck);
	    	JPanel p1Winpile = new GenericCardGameCardListView(((WarCardGamePlayer)model.getPlayers().get(1)).winPile);
	    	JPanel p2Winpile = new GenericCardGameCardListView(((WarCardGamePlayer)model.getPlayers().get(2)).winPile);
	    	JPanel p1Card = ((WarCardGamePlayer)model.getPlayers().get(1)).cardPlayed;
	    	JPanel p2Card = ((WarCardGamePlayer)model.getPlayers().get(2)).cardPlayed;
	        
	    	
	    	gbc.ipady=50;
	        gbc.gridx=0;
	        gbc.gridy=0;
	    	this.add(p2Deck, gbc);
	    	
	        gbc.gridx=2;
	        gbc.gridy=0;
	        this.add(p2Winpile, gbc);
	    	
	        gbc.gridx=1;
	        gbc.gridy=1;
	        this.add(p2Card, gbc);
	    	
	        gbc.gridx=1;
	        gbc.gridy=2;
	        this.add(p1Card, gbc);
	    	
	        gbc.gridx=0;
	        gbc.gridy=3;
	        this.add(p1Deck, gbc);
	        
	        gbc.gridx=2;
	        gbc.gridy=3;
	        this.add(p1Winpile, gbc);
	        */
	        this.setOpaque(true);
	        this.setBackground(Color.BLUE);
		}
	}
}
