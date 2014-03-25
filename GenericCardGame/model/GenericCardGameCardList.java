package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class GenericCardGameCardList extends ArrayList<GenericCardGameCard> implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	public GenericCardGameCardList()
	{
		super();
		this.shuffle();
	}
	
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
	
	public void faceUp()
	{
		for(GenericCardGameCard card : this)
		{
			card.faceUp();
		}
	}
	
	public void faceDown()
	{
		for(GenericCardGameCard card : this)
		{
			card.faceDown();
		}
	}	
	
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
