package model;

public class WarPlayer extends GenericPlayer
{	
	public static enum Destination
	{
		HAND, WINPILE
	}

	public WarPlayer(String name) 
	{
		super(name);
	}
}
