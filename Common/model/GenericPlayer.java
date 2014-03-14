 package model;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

 public class GenericPlayer
 {
	 private String name;
	 private CardList hand;
	 
	 protected GenericPlayer(String name)
	 {
		 this.name = name;
		 this.hand = new CardList();
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
	 
	 public JPanel generateHandView()
	 {
		 JPanel result = new JPanel();
		 
		 result.setLayout(new BoxLayout(result, BoxLayout.LINE_AXIS));
		 
		 hand.sort();
		 
		 for(Card card : hand)
		 {
			 result.add(card);
		 }

		 return result;
	 }
 }