 package model;

 public class Player
 {
	 private CardList hand;
	 private String name;
	 
	 public static enum Dest
	 {
		 HAND, WINPILE
	 }
	 
	 protected Player(String name)
	 {
		 this.name = name;
	 }

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public CardList getHand() 
	{
		return hand;
	}

	public void setHand(CardList hand) 
	{
		this.hand = hand;
	}
 }