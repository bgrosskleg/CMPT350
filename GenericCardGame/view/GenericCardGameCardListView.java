package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.GenericCardGameCardList;

public class GenericCardGameCardListView extends JPanel
{
	private static final long serialVersionUID = 1L;

	GenericCardGameCardList cards;
	
	GenericCardGameCardListView(GenericCardGameCardList cards)
	{
		this.cards = cards;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		/*
    	 * 	 _______________
    	 * 	|				|
    	 * 	|	 _______	|
    	 * 	|	|		|	|
    	 * 	|	| card  |	|
    	 * 	|	|		|	|
    	 * 	|	|_______|	|
    	 * 	|	numCards	|
    	 * 	|_______________|
    	 */
		
		Graphics2D g2 = (Graphics2D) g;
			
		if(cards.size() > 0)
		{
			//Paint top card
			cards.get(0).paintComponent(g);
		}
		
		//Indicate how many cards are in the stack
		g2.setFont(new Font("Arial", Font.BOLD, 22)); 
		g2.drawString(String.valueOf(cards.size()), 25, 115);
	}
}
