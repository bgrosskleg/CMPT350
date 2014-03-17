 package model;

import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

 public abstract class GenericPlayer extends GenericModel
 {
	 private String name;
	 private CardList hand;
	 
	 private Socket socket;
	 	 
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
		 this.notifyModelSubscribers();
	 }

	 public CardList getHand() 
	 {
		 return hand;
	 }

	 public void setHand(CardList hand) 
	 {
		 this.hand = hand;
		 this.notifyModelSubscribers();
	 }
	 
	 public Socket getSocket() 
	 {
		 return socket;
	 }

	 public void setSocket(Socket socket) 
	 {
		 this.socket = socket;
		 this.notifyModelSubscribers();
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