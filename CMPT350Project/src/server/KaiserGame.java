package server;

import javax.swing.JFrame;

import model.Card;

public class KaiserGame 
{
	public static void main(String [ ] args)
	{		
		JFrame frame = new JFrame("Kaiser Game");
		
		frame.add(new Card(Card.Value.FIVE, Card.Suit.SPADE));
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
