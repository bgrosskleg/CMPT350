package view;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.WarGameAppletCommunicationThread;
import controller.WarPlayerController;
import model.CardList;
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
	
	private static WarPlayer player;
	private static WarPlayerController controller;
	private static WarGameAppletCommunicationThread comThread;
		
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
    	//Create local model
    	String name = JOptionPane.showInputDialog(null, "Please enter your name:", "Welcome New Player", JOptionPane.PLAIN_MESSAGE);
    	player = new WarPlayer(name);
    	
    	//Create controller
        controller = new WarPlayerController();         	
    	
    	//Create communication thread
        comThread = new WarGameAppletCommunicationThread(this);
        comThread.start();
    	
    	//Wait for cards from game
        while(player.getHand().isEmpty())
        {
        	//Wait
        }
    	
    	//Display hand and start game
    	add(player.generateHandView());	
	}

}
