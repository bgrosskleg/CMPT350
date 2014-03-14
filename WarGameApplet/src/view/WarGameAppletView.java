package view;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.Card;
import model.WarPlayer;
/**
 * parameters:	serialVersionUID
 * methods:		none
 * 
 * to be explained..? 
 * the view the player can see in the browser window?
 */
public class WarGameAppletView extends JApplet
{
	private static final long serialVersionUID = 1L;
	
	private WarPlayer me;
	
	public void init()
	{
		try 
        {
            SwingUtilities.invokeAndWait(new Runnable() 
            {
                public void run() 
                {
                    createGUI();
                }
            });
        }
        catch (Exception e) 
        {
            System.err.println("createGUI didn't successfully complete");
            e.printStackTrace();
        } 		
    }

    /**
     * Creates the GUI of the applet
     */
    private void createGUI() 
    {    	
    	String name = JOptionPane.showInputDialog(this, "Please enter your name:", "Welcome New Player", JOptionPane.PLAIN_MESSAGE);
    	me = new WarPlayer(name);
    	
    	me.getHand().add(new Card(Card.Value.ACE, Card.Suit.HEART));
    	me.getHand().add(new Card(Card.Value.THREE, Card.Suit.DIAMOND));
    	me.getHand().add(new Card(Card.Value.KING, Card.Suit.SPADE));
    	me.getHand().add(new Card(Card.Value.JACK, Card.Suit.HEART));
    	me.getHand().add(new Card(Card.Value.FOUR, Card.Suit.HEART));
    	me.getHand().add(new Card(Card.Value.SEVEN, Card.Suit.CLUB));
    	
    	add(me.generateHandView());	
	}

}
