package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Card extends JPanel
{
	private static final long serialVersionUID = 1L;

	public static enum Value
	{
		ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
		NINE, TEN, JACK, QUEEN, KING
	}
	
	public static enum Suit
	{
		CLUB, HEART, SPADE, DIAMOND
	}
	
	public static enum Display
	{
		FACEUP, FACEDOWN
	}

	private Value value;
	private Suit suit;
	private Display display;
	
	private BufferedImage cardFace;
	private BufferedImage cardBack;
	
	public Card(Value value, Suit suit, Display display)
	{
		super();
		
		this.value = value;
		this.suit = suit;
		this.display = display;
				
		cardFace = null;
		cardBack = null;
		try 
		{
			File file = new File(imagePath);
			cardFace = ImageIO.read(file);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		if(this.)
		g.drawImage(cardFace, 0, 0, null);
	}
	
}
