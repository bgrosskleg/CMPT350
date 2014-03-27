package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
/**
 * contains:
 * 
 * public methods:
 * GenericCardGameCardList()
 * shuffle()
 * sort()
 * faceUp()
 * faceDown()
 * toString()
 */
public class GenericCardGameCardList extends ArrayList<GenericCardGameCard> implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * an ArrayList of type GenericCardGameCard
	 * 
	 * creates an ArrayList
	 * shuffles this ArrayList
	 */
	public GenericCardGameCardList()
	{
		super();
		this.shuffle();
	}
	
	/**
	 * randomizes the ArrayList
	 * 
	 * shuffle is a static function inside java which takes a list and shuffles it randomly
	 * collections is a data type inside of java
	 */
	public void shuffle()
	{
		//http://stackoverflow.com/questions/4228975/how-to-randomize-arraylist
		//shuffle is a static function inside java which takes a list and shuffles it randomly
		//Collections is a data type inside of java
		Collections.shuffle(this);
	}
	
	public void sort()
	{
		//TODO  SORT CARDS SMALLEST TO LARGEST, ALTERNATING RED BLACK SUITS
	}
	
	/**
	 * goes through the ArrayList and sets all of their displays to FACEUP
	 */
	public void faceUp()
	{
		for(GenericCardGameCard card : this)
		{
			card.faceUp();
		}
	}
	
	/**
	 * goes through the ArrayList and sets all of their displays to FACEDOWN
	 */
	public void faceDown()
	{
		for(GenericCardGameCard card : this)
		{
			card.faceDown();
		}
	}	
	
	/**
	 * converts the card value to a string 
	 * 
	 * used for error handling and the ability to see what is happening inside the system
	 * 
	 * @return a string representing the card, or EMPTY if there is no card
	 */
	@Override
	public String toString()
	{
		if(this.isEmpty())
		{
			return "EMPTY";
		}
		
		String result = "";
		for(GenericCardGameCard card : this)
		{
			result += (card.toString() + "\n");
		}
		
		return result;
	}
}
