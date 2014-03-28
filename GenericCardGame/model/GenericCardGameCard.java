package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * contains:
 * 
 * public methods:
 * paintComponent(Graphics)
 * equals(Object)
 * compareTo(GenericCardGameCard)
 * getOwner()
 * setOwner(GenericCardGamePlayer)
 * getValue()
 * getSuit()
 * faceUp()
 * toString()
 * faceDown() 
 *
 */
public class GenericCardGameCard extends JPanel implements Comparable<GenericCardGameCard>, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 71;
	public static final int HEIGHT = 96;
	
	/**
	 * each enum has been given a value in brackets behind it
	 * this will allow us to compare their values later
	 *
	 * note: in some games the ACE will be low and this may have to be changed
	 */
	public static enum Value
	{
		TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
		NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
		
		private int ordinal;
		private Value(int ordinal)
		{
			this.ordinal=ordinal;
		}	
	}
	
	public static enum Suit
	{
		CLUB, HEART, SPADE, DIAMOND
	}	
	
	public static enum Display
	{
		FACEUP, FACEDOWN
	}
	
	private GenericCardGamePlayer owner;

	private Value value;
	private Suit suit;
	private Display display;
	
	private transient ImageIcon cardFace;
	private transient ImageIcon cardBack;
	
	/**
	 * creates a simple card with a value, a suit, and two picture representations(back view/front view)
	 * 
	 * retrieves the appropriate picture associated with the value and suit of the card
	 * 
	 * @param value the number associated with the card object
	 * @param suit the suit associated with the card object
	 * @throws generic exception and prints the stackTrace so we can see what happened
	 */
	public GenericCardGameCard(Value value, Suit suit)
	{
		super();
		
		owner = null;
		
		this.value = value;
		this.suit = suit;
		this.display = Display.FACEDOWN;
				
		cardFace = null;
		cardBack = null;

		//In order to load the images both in Eclipse IDE and a Java JAR file, need to use getResource()
		//In order to use getResource(), files need to be in src folder, as a subpackage (vs. a linked folder on buildpath)
		String cardPath = "/resources/cards";

		String imagePath;
		imagePath = cardPath + "/" + suit + "/" + value + ".png";
				
		//Below method works both in Eclipse IDE and JAR's when BACK.png image is in the src folder
		//Toolkit.getDefaultToolkit().getImage(getClass().getResource("/BACK.png"));
		
		cardFace = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath)));
		
		imagePath = cardPath + "/BACK.png";
		cardBack = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath)));
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(getPreferredSize());
		this.setMinimumSize(getPreferredSize());
	}
	/**
	 * retrieves the image for the card and parses it into a Graphics2D object
	 * 
	 * @param g the image to give to the view
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		if(display.equals(Display.FACEUP))
		{
			if(cardFace == null)
			{
				g2.setColor(Color.BLACK);
				g2.setStroke(new BasicStroke(2));
				g2.drawRect(0, 0, WIDTH, HEIGHT);
				
				g2.drawString(this.value.name(), 5, 15);
				g2.drawString("of", 5, 30);
				g2.drawString(this.suit.name(), 5, 45);
			}
			else
			{
				g2.drawImage(cardFace.getImage(), 0, 0, null);
			}
		}
		else if(display.equals(Display.FACEDOWN))
		{
			if(cardBack == null)
			{
				g2.setColor(Color.BLACK);
				g2.setStroke(new BasicStroke(2));
				g2.drawRect(0, 0, WIDTH, HEIGHT);
				
				g2.drawString("Card Back", 5, 15);
			}
			else
			{
				g2.drawImage(cardBack.getImage(), 0, 0, null);
			}
		}
	}
	
	/**
	 * checks to see if two cards are equal
	 * 
	 * equals is used in the ArrayList contains function
	 * by implementing equals for each type of object it is possible to call
	 * ArrayList<Card>.contains(Card) and it will work
	 * @param other the card that we are comparing this card to
	 */
	@Override
	public boolean equals(Object other) 
	{
		if (other == null) 
		{return false;}
		
	    if (other == this) 
	    {return true;}
	    
	    if (!(other instanceof GenericCardGameCard))
	    {return false;}
	    
	    //Class specific comparison
	    //TODO ...   
	    
	   return false;
	}
	
	/**
	 * compares the ordinal values that were given to each card (TWO=2, ACE=14, etc)
	 * 
	 * @return 0 if two cards are equal, -1 if this card is less than the object it is compared to, otherwise return 1
	 */
	@Override
	public int compareTo(GenericCardGameCard that) 
	{
		if(this.value.ordinal==that.value.ordinal)
			return 0;
		if(this.value.ordinal < that.value.ordinal)
			return -1;
		else
			return 1;
	}

	/**
	 * returns this owner
	 * 
	 * @return the owner
	 */
	public GenericCardGamePlayer getOwner() 
	{
		return owner;
	}

	/**
	 * sets this owner
	 * 
	 * @param owner sets the owner
	 */
	public void setOwner(GenericCardGamePlayer owner) 
	{
		this.owner = owner;
	}
	
	/**
	 * gets this value
	 * 
	 * @return this value
	 */	
	public Value getValue()
	{
		return this.value;
	}
	
	/**
	 * gets this suit
	 * 
	 * @return this suit
	 */
	public Suit getSuit()
	{
		return this.suit;
	}
	
	/**
	 * sets the display of this card to FACEUP
	 * 
	 */
	public void faceUp()
	{
		this.display = Display.FACEUP;
	}
	
	/**
	 * sets the display of this card to FACEDOWN
	 */
	public void faceDown()
	{
		this.display = Display.FACEDOWN;
	}
	
	public void setCardFace(ImageIcon cardFace)
	{
		this.cardFace = cardFace;
	}
	
	public ImageIcon getCardFace()
	{
		return this.cardFace;
	}
	
	public void setCardBack(ImageIcon cardBack)
	{
		this.cardBack = cardBack;
	}
	
	public ImageIcon getCardBack()
	{
		return this.cardBack;
	}
	
	/**
	 * converts the card value and the suit value to a string value
	 * 
	 * used for error handling and the ability to see what is happening inside the system
	 * 
	 * @return a string representing the value and suit of a card
	 */
	@Override
	public String toString()
	{
		return (this.value + " of " + this.suit);
	}
}
