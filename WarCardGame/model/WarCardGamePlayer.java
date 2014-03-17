package model;

import controller.WarCardGameClientAppletSocketWorker;


public class WarCardGamePlayer extends GenericCardGamePlayer
{	
	public GenericCardGameCard cardPlayed;
	public String name;
	
	public static enum Destination
	{
		HAND, WINPILE
	}

	public WarCardGamePlayer(WarCardGameClientAppletSocketWorker socketWorker) 
	{
		super(socketWorker);
		cardPlayed = null;
		name = null;
	}
}
