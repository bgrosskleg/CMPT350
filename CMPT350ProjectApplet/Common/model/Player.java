 package model;

 public class Player
 {
	 private CardList hand;
	 private String name;
	 
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
 }