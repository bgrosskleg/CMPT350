 package model;

 public class GenericPlayer
 {
	 private CardList hand;
	 private String name;

	 protected GenericPlayer(String name)
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