package model;

public class WarPlayer extends GenericPlayer
{
	private Card cardPlayed;
	
	public static enum Destination
	{
		HAND,WINPILE
	}

	public WarPlayer(String name) 
	{
		super(name);
		cardPlayed = null;
	}
}
