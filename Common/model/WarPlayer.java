package model;

public class WarPlayer extends GenericPlayer
{	
	public Card cardPlayed;
	
	public static enum Destination
	{
		HAND, WINPILE
	}

	public WarPlayer(String name) 
	{
		super(name);
		cardPlayed = null;
	}
}
