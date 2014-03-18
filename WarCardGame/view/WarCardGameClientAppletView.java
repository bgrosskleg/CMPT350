package view;

import javax.swing.*;
import java.awt.*;

import model.WarCardGameModel;

public class WarCardGameClientAppletView extends GenericCardGameView
{
    JPanel p1Deck;
	JPanel p2Deck;
	JPanel p1Winpile;
	JPanel p2Winpile;
	JPanel p1Card;
	JPanel p2Card;
	private static final long serialVersionUID = 1L;
	private JLabel playerStatus;


	public WarCardGameClientAppletView(WarCardGameModel model) 
    {
		super(model);
		// TODO Auto-generated constructor stub
	}
    
    public JPanel createContentPane (){
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
        JPanel totalGUI = new JPanel();
        
        // We create a JPanel with the GridLayout.
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.BOTH;
        gbc.weightx = 0.33;
        gbc.weighty = 0.25;
        
        
    	JPanel p1Deck = new SquareJPanel(Color.red);
    	JPanel p2Deck = new SquareJPanel(Color.red);
    	JPanel p1Winpile = new SquareJPanel(Color.red);
    	JPanel p2Winpile = new SquareJPanel(Color.red);
    	JPanel p1Card = new SquareJPanel(Color.red);
    	JPanel p2Card = new SquareJPanel(Color.red);
        
    	
    	gbc.ipady=50;
        gbc.gridx=0;
        gbc.gridy=0;
    	mainPanel.add(p2Deck, gbc);
    	
        gbc.gridx=2;
        gbc.gridy=0;
    	mainPanel.add(p2Winpile, gbc);
    	
        gbc.gridx=1;
        gbc.gridy=1;
    	mainPanel.add(p2Card, gbc);
    	
        gbc.gridx=1;
        gbc.gridy=2;
    	mainPanel.add(p1Card, gbc);
    	
        gbc.gridx=0;
        gbc.gridy=3;
    	mainPanel.add(p1Deck, gbc);
        
        gbc.gridx=2;
        gbc.gridy=3;
    	mainPanel.add(p1Winpile, gbc);
        
    	mainPanel.setOpaque(true);
    	mainPanel.setBackground(Color.BLUE);
        return mainPanel;
    }
    
    public class SquareJPanel extends JPanel
    {
		private static final long serialVersionUID = 1L;
        
		public SquareJPanel(Color color)
    	{
	    	/*
	    	 * 	 _______________
	    	 * 	|	deckName	|
	    	 * 	|	 _______	|
	    	 * 	|	|		|	|
	    	 * 	|	| card  |	|
	    	 * 	|	|		|	|
	    	 * 	|	|_______|	|
	    	 * 	|	numCards	|
	    	 * 	|_______________|
	    	 */
	    	JLabel deckName = new JLabel(); // type of card pile
	    	JLabel numCards = new JLabel(); //number of cards in deck
	    	
	    	//GenericCardGameCard Card
            
	    	this.setPreferredSize(new Dimension(71,96));
	    	this.setBorder(getBorder());
	        this.setBackground(color);
    	}
    }
    
    

	@Override
	protected JPanel generatePanel() 
	{
		JPanel result = new JPanel();
		
		result.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		result.setBackground(Color.BLUE);
		result.setPreferredSize(new Dimension(500,500));
		result.setMaximumSize(getPreferredSize());
		result.setMinimumSize(getPreferredSize());
		
		
		playerStatus = new JLabel("Waiting for " + (2-((WarCardGameModel)model).getPlayers().size()) + " more players...");
		result.add(playerStatus);
		
		
		return result;
	}


	@Override
	public void modelChanged() 
	{
		if(((WarCardGameModel)model).getPlayers().size() < 2)
		{
			playerStatus.setText("Waiting for " + (2-((WarCardGameModel)model).getPlayers().size()) + " more players...");
		}
		else
		{
			//this.panel = generatePanel();
			this.panel.remove(playerStatus);
			this.panel.setBackground(Color.GREEN);
		}
	}

}
