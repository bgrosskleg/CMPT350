 package model;

import java.util.LinkedList;
import java.util.List;

 public class PlayerModel
 {
	 public List<Card> hand;
	 public Card selectedCard;
	 
	 public PlayerModel()
	 {
		 hand = new LinkedList<Card>();
	 }
 }