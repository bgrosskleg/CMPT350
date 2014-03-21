package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GenericCardGameCard extends JPanel implements Comparable<GenericCardGameCard>, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 71;
	public static final int HEIGHT = 96;
	
	//each enum has been given a value in brackets behind it (this will allow us to compare them later)
	//** if we ever implement a game where aces are low this will have to be overwritten
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
	
	private ImageIcon cardFace;
	private ImageIcon cardBack;
	
	public GenericCardGameCard(Value value, Suit suit)
	{
		super();
		
		owner = null;
		
		this.value = value;
		this.suit = suit;
		this.display = Display.FACEDOWN;
				
		cardFace = null;
		cardBack = null;
		try 
		{
			//Filepath's originate at the root folder of the project itself
			//to get the image, step up one level to CMPT350 folder with '../'
			//then drill down into 'GenericCardGame' and find the resource needed
			String cardPath = "../GenericCardGame/resources/cards";
			String imagePath;
			imagePath = cardPath + "/" + suit + "/" + value + ".png";
			
			File imageFile = new File(imagePath);
			
			//System.out.println(imagePath);
			cardFace = new ImageIcon(ImageIO.read(imageFile));
			
			imagePath = cardPath + "/BACK.png";
			cardBack = new ImageIcon(ImageIO.read(new File(imagePath)));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(getPreferredSize());
		this.setMinimumSize(getPreferredSize());
	}
	
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
				
				g2.drawString("Card Back", 5, 15);
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
				g2.drawString(this.value.name(), 5, 15);
				g2.drawString("of", 5, 30);
				g2.drawString(this.suit.name(), 5, 45);
			}
			else
			{
				g2.drawImage(cardBack.getImage(), 0, 0, null);
			}
		}
	}
	
	/**
	 * Equals is used in the ArrayList contains function
	 * By implementing equals for each type of object it is possible to call
	 * ArrayList<Card>.contains(Card) and it will work
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

	public GenericCardGamePlayer getOwner() 
	{
		return owner;
	}

	public void setOwner(GenericCardGamePlayer owner) 
	{
		this.owner = owner;
	}
	
	public Value getValue()
	{
		return this.value;
	}
	
	public Suit getSuit()
	{
		return this.suit;
	}
	
	@Override
	public String toString()
	{
		return (this.value + " of " + this.suit);
	}
}
