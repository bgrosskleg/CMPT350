package server;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Card;
/**
 * WarGame is the main entry point from which the game is played
 *
 */
public class WarGame 
{
	public static void main(String [ ] args)
	{		
		JFrame frame = new JFrame("War Game");
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.LINE_AXIS));
		
		contentPane.add(new Card(Card.Value.EIGHT, Card.Suit.SPADE, Card.Display.FACEUP));
		contentPane.add(new Card(Card.Value.EIGHT, Card.Suit.SPADE, Card.Display.FACEDOWN));
		
		frame.add(contentPane);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
